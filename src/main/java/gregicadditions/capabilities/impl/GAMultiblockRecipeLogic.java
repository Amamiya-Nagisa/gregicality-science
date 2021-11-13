package gregicadditions.capabilities.impl;

import gregtech.api.GTValues;
import gregtech.api.capability.IMultipleTankHandler;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.recipes.MatchingMode;
import gregtech.api.recipes.Recipe;
import gregtech.api.util.GTUtility;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

import java.util.Arrays;
import java.util.List;

public class GAMultiblockRecipeLogic extends MultiblockRecipeLogic {

    // Field used for maintenance
    protected int previousRecipeDuration;

    // Fields used for distinct mode
    protected int lastRecipeIndex = 0;
    protected ItemStack[][] lastItemInputsMatrix;

    public GAMultiblockRecipeLogic(RecipeMapMultiblockController tileEntity) {
        super(tileEntity);
    }

    /**
     * Used to reset cached values after multiblock structure deforms
     */
    public void invalidate() {
        super.invalidate();
        lastRecipeIndex = 0;
    }

    protected List<IItemHandlerModifiable> getInputBuses() {
        RecipeMapMultiblockController controller = (RecipeMapMultiblockController) metaTileEntity;
        return controller.getAbilities(MultiblockAbility.IMPORT_ITEMS);
    }

    @Override
    protected int[] calculateOverclock(int EUt, long voltage, int duration) {
        if (!allowOverclocking) {
            return new int[]{EUt, duration};
        }
        boolean negativeEU = EUt < 0;
        int tier = getOverclockingTier(voltage);
        if (GTValues.V[tier] <= EUt || tier == 0)
            return new int[]{EUt, duration};
        if (negativeEU)
            EUt = -EUt;
        if (EUt <= 16) {
            int multiplier = EUt <= 8 ? tier : tier - 1;
            int resultEUt = EUt * (1 << multiplier) * (1 << multiplier);
            int resultDuration = duration / (1 << multiplier);
            previousRecipeDuration = resultDuration;
            return new int[]{negativeEU ? -resultEUt : resultEUt, resultDuration};
        } else {
            int resultEUt = EUt;
            double resultDuration = duration;
            //do not overclock further if duration is already too small
            while (resultDuration >= 3 && resultEUt <= GTValues.V[tier - 1]) {
                resultEUt *= 4;
                resultDuration /= 2.8;
            }
            previousRecipeDuration = (int) resultDuration;
            return new int[]{negativeEU ? -resultEUt : resultEUt, (int) Math.ceil(resultDuration)};
        }
    }

    @Override
    protected int getOverclockingTier(long voltage) {
        return GTUtility.getTierByVoltage(voltage);
    }

    @Override
    protected void trySearchNewRecipe() {
        if (metaTileEntity instanceof GARecipeMapMultiblockController) {
            GARecipeMapMultiblockController controller = (GARecipeMapMultiblockController) metaTileEntity;
            if (controller.canDistinct && controller.isDistinct) {
                trySearchNewRecipeDistinct();
                return;
            }
        }
        trySearchNewRecipeCombined();
    }

    // TODO May need to do more here
    protected void trySearchNewRecipeCombined() {
        super.trySearchNewRecipe();
    }

    private void trySearchNewRecipeDistinct() {
        long maxVoltage = getMaxVoltage();
        Recipe currentRecipe = null;
        List<IItemHandlerModifiable> importInventory = getInputBuses();
        IMultipleTankHandler importFluids = getInputTank();

        // Our caching implementation
        // This guarantees that if we get a recipe cache hit, our efficiency is no different from other machines
        if (previousRecipe != null && previousRecipe.matches(false, importInventory.get(lastRecipeIndex), importFluids)) {
            currentRecipe = previousRecipe;
            if (setupAndConsumeRecipeInputs(currentRecipe, lastRecipeIndex)) {
                setupRecipe(currentRecipe);
                return;
            }
        }

        // On a cache miss, our efficiency is much worse, as it will check
        // each bus individually instead of the combined inventory all at once.
        for (int i = 0; i < importInventory.size(); i++) {
            IItemHandlerModifiable bus = importInventory.get(i);
            boolean dirty = checkRecipeInputsDirty(bus, importFluids, i);
            if (dirty /*|| forceRecipeRecheck*/) { //todo recipe logic
//                this.forceRecipeRecheck = false;
                currentRecipe = findRecipe(maxVoltage, bus, importFluids, MatchingMode.DEFAULT);
                if (currentRecipe != null) {
                    this.previousRecipe = currentRecipe;
                }
            }
            if (currentRecipe != null && setupAndConsumeRecipeInputs(currentRecipe, i)) {
                lastRecipeIndex = i;
                setupRecipe(currentRecipe);
                break;
            }
        }
    }

    // Replacing this for optimization reasons
    protected boolean checkRecipeInputsDirty(IItemHandler inputs, IMultipleTankHandler fluidInputs, int index) {
        boolean shouldRecheckRecipe = false;

        if (lastItemInputsMatrix == null || lastItemInputsMatrix.length != getInputBuses().size()) {
            lastItemInputsMatrix = new ItemStack[getInputBuses().size()][];
        }
        if (lastItemInputsMatrix[index] == null || lastItemInputsMatrix[index].length != inputs.getSlots()) {
            this.lastItemInputsMatrix[index] = new ItemStack[inputs.getSlots()];
            Arrays.fill(lastItemInputsMatrix[index], ItemStack.EMPTY);
        }
//        if (lastFluidInputs == null || lastFluidInputs.length != fluidInputs.getTanks()) { todo recipe logic
//            this.lastFluidInputs = new FluidStack[fluidInputs.getTanks()];
//        }
        for (int i = 0; i < lastItemInputsMatrix[index].length; i++) {
            ItemStack currentStack = inputs.getStackInSlot(i);
            ItemStack lastStack = lastItemInputsMatrix[index][i];
            if (!areItemStacksEqual(currentStack, lastStack)) {
                this.lastItemInputsMatrix[index][i] = currentStack.isEmpty() ? ItemStack.EMPTY : currentStack.copy();
                shouldRecheckRecipe = true;
            } else if (currentStack.getCount() != lastStack.getCount()) {
                lastStack.setCount(currentStack.getCount());
                shouldRecheckRecipe = true;
            }
        }
//        for (int i = 0; i < lastFluidInputs.length; i++) { todo recipe logic
//            FluidStack currentStack = fluidInputs.getTankAt(i).getFluid();
//            FluidStack lastStack = lastFluidInputs[i];
//            if ((currentStack == null && lastStack != null) ||
//                    (currentStack != null && !currentStack.isFluidEqual(lastStack))) {
//                this.lastFluidInputs[i] = currentStack == null ? null : currentStack.copy();
//                shouldRecheckRecipe = true;
//            } else if (currentStack != null && lastStack != null &&
//                    currentStack.amount != lastStack.amount) {
//                lastStack.amount = currentStack.amount;
//                shouldRecheckRecipe = true;
//            }
//        }
        return shouldRecheckRecipe;
    }

    protected boolean setupAndConsumeRecipeInputs(Recipe recipe, int index) {
        RecipeMapMultiblockController controller = (RecipeMapMultiblockController) metaTileEntity;
        if (controller.checkRecipe(recipe, false)) {

            int[] resultOverclock = calculateOverclock(recipe.getEUt(), recipe.getDuration());
            int totalEUt = resultOverclock[0] * resultOverclock[1];
            IItemHandlerModifiable importInventory = getInputBuses().get(index);
            IItemHandlerModifiable exportInventory = getOutputInventory();
            IMultipleTankHandler importFluids = getInputTank();
            IMultipleTankHandler exportFluids = getOutputTank();
            boolean setup = (totalEUt >= 0 ? getEnergyStored() >= (totalEUt > getEnergyCapacity() / 2 ? resultOverclock[0] : totalEUt) :
                    (getEnergyStored() - resultOverclock[0] <= getEnergyCapacity())) &&
                    MetaTileEntity.addItemsToItemHandler(exportInventory, true, recipe.getAllItemOutputs(exportInventory.getSlots())) &&
                    MetaTileEntity.addFluidsToFluidHandler(exportFluids, true, recipe.getFluidOutputs()) &&
                    recipe.matches(true, importInventory, importFluids);

            if (setup) {
                controller.checkRecipe(recipe, true);
                return true;
            }
        }
        return false;
    }
}
