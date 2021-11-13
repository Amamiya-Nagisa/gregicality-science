package gregicadditions.recipes.categories;

import gregicadditions.item.GAExplosive;
import gregicadditions.item.GAMetaBlocks;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregicadditions.GAMaterials.*;
import static gregicadditions.item.GAMetaItems.*;
import static gregtech.api.GTValues.L;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.MarkerMaterials.Color.Magenta;
import static gregtech.api.unification.material.MarkerMaterials.Tier.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class MetaItemRecipes {

    public static void init() {

        // Pyrolytic Carbon
        COMPRESSOR_RECIPES.recipeBuilder().EUt(120).duration(300)
                .input(ingot, Graphite)
                .outputs(PYROLYTIC_CARBON.getStackForm())
                .buildAndRegister();

        // Freedom Wrench
        ASSEMBLER_RECIPES.recipeBuilder().duration(200).EUt(512)
                .inputs(ELECTRIC_MOTOR_HV.getStackForm())
                .input(circuit, Advanced, 2)
                .input(stick, StainlessSteel)
                .fluidInputs(SolderingAlloy.getFluid(L * 10))
                .outputs(FREEDOM_WRENCH.getStackForm())
                .buildAndRegister();

        // Cooling Containers
        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(380).EUt(1150000)
                .input(plate, Steel, 64)
                .input(plate, Steel, 64)
                .input(plate, Steel, 64)
                .input(plate, Steel, 64)
                .inputs(LASER_COOLING_UNIT.getStackForm())
                .inputs(MAGNETIC_TRAP.getStackForm())
                .fluidInputs(SolderingAlloy.getFluid(L))
                .outputs(EMPTY_LASER_COOLING_CONTAINER.getStackForm())
                .buildAndRegister();

        CANNER_RECIPES.recipeBuilder().duration(280).EUt(90000)
                .inputs(EMPTY_LASER_COOLING_CONTAINER.getStackForm())
                .fluidInputs(Rubidium.getFluid(L * 2))
                .outputs(BOSE_EINSTEIN_COOLING_CONTAINER.getStackForm())
                .buildAndRegister();

        // Laser Diode
        ASSEMBLER_RECIPES.recipeBuilder().duration(260).EUt(980000)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .inputs(SMD_DIODE_BIOWARE.getStackForm())
                .input(craftingLens, Magenta)
                .input(wireFine, Gold, 3)
                .outputs(LASER_DIODE.getStackForm())
                .buildAndRegister();

        // Laser Cooling Unit
        ASSEMBLER_RECIPES.recipeBuilder().duration(300).EUt(1200000)
                .fluidInputs(SolderingAlloy.getFluid(L * 2))
                .input(wireFine, Gold, 4)
                .inputs(MetaBlocks.METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.ALUMINIUM_FROSTPROOF))
                .inputs(LASER_DIODE.getStackForm())
                .input(circuit, Ultimate)
                .outputs(LASER_COOLING_UNIT.getStackForm())
                .buildAndRegister();

        // Magnetic Trap
        ASSEMBLER_RECIPES.recipeBuilder().duration(480).EUt(1000000)
                .fluidInputs(SolderingAlloy.getFluid(L * 3))
                .input(wireGtDouble, EnrichedNaquadahTriniumEuropiumDuranide, 2)
                .inputs(MetaBlocks.METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.ALUMINIUM_FROSTPROOF))
                .outputs(MAGNETIC_TRAP.getStackForm())
                .buildAndRegister();

        // Gravi Star
        GTRecipeHandler.removeRecipesByInputs(AUTOCLAVE_RECIPES, new ItemStack[]{new ItemStack(Items.NETHER_STAR)}, new FluidStack[]{Darmstadtium.getFluid(L * 2)});
        AUTOCLAVE_RECIPES.recipeBuilder().duration(480).EUt(7680)
                .inputs(new ItemStack(Items.NETHER_STAR))
                .fluidInputs(Dubnium.getFluid(L * 2))
                .outputs(GRAVI_STAR.getStackForm())
                .buildAndRegister();

        // Unstable Star
        AUTOCLAVE_RECIPES.recipeBuilder().duration(480).EUt(122880)
                .inputs(GRAVI_STAR.getStackForm())
                .fluidInputs(Adamantium.getFluid(L * 2))
                .outputs(UNSTABLE_STAR.getStackForm())
                .buildAndRegister();

        // Plant Balls
        COMPRESSOR_RECIPES.recipeBuilder().duration(300).EUt(2)
                .input("listAllmushroom", 8)
                .outputs(PLANT_BALL.getStackForm())
                .buildAndRegister();

        COMPRESSOR_RECIPES.recipeBuilder().duration(300).EUt(2)
                .input("listAllfruit", 8)
                .outputs(PLANT_BALL.getStackForm())
                .buildAndRegister();

        COMPRESSOR_RECIPES.recipeBuilder().duration(300).EUt(2)
                .input("listAllveggie", 8)
                .outputs(PLANT_BALL.getStackForm())
                .buildAndRegister();

        COMPRESSOR_RECIPES.recipeBuilder().duration(300).EUt(2)
                .input("listAllspice", 8)
                .outputs(PLANT_BALL.getStackForm())
                .buildAndRegister();

        COMPRESSOR_RECIPES.recipeBuilder().duration(300).EUt(2)
                .input("listAllgrain", 8)
                .outputs(PLANT_BALL.getStackForm())
                .buildAndRegister();

        COMPRESSOR_RECIPES.recipeBuilder().duration(300).EUt(2)
                .input("listAllnut", 8)
                .outputs(PLANT_BALL.getStackForm())
                .buildAndRegister();

        COMPRESSOR_RECIPES.recipeBuilder().duration(300).EUt(2)
                .input("listAllpepper", 8)
                .outputs(PLANT_BALL.getStackForm())
                .buildAndRegister();

        COMPRESSOR_RECIPES.recipeBuilder().duration(300).EUt(2)
                .input("listAllherb", 8)
                .outputs(PLANT_BALL.getStackForm())
                .buildAndRegister();

        COMPRESSOR_RECIPES.recipeBuilder().duration(300).EUt(2)
                .input("listAllfiber", 8)
                .outputs(PLANT_BALL.getStackForm())
                .buildAndRegister();

        COMPRESSOR_RECIPES.recipeBuilder().duration(300).EUt(2)
                .input(dust, BrownAlgae, 8)
                .outputs(PLANT_BALL.getStackForm())
                .buildAndRegister();

        COMPRESSOR_RECIPES.recipeBuilder().duration(300).EUt(2)
                .input(dust, RedAlgae, 8)
                .outputs(PLANT_BALL.getStackForm())
                .buildAndRegister();

        COMPRESSOR_RECIPES.recipeBuilder().duration(300).EUt(2)
                .input(dust, GreenAlgae, 8)
                .outputs(PLANT_BALL.getStackForm())
                .buildAndRegister();

        // Glass Tube
        FLUID_SOLIDFICATION_RECIPES.recipeBuilder().EUt(16).duration(80)
                .fluidInputs(Glass.getFluid(L))
                .notConsumable(SHAPE_MOLD_BALL.getStackForm())
                .outputs(GLASS_TUBE.getStackForm())
                .buildAndRegister();

        // Mince Meat
        MACERATOR_RECIPES.recipeBuilder().duration(60).EUt(16)
                .inputs(new ItemStack(Items.PORKCHOP))
                .output(dustSmall, Meat, 6)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder().duration(60).EUt(16)
                .inputs(new ItemStack(Items.BEEF))
                .output(dustSmall, Meat, 6)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder().duration(60).EUt(16)
                .inputs(new ItemStack(Items.RABBIT))
                .output(dustSmall, Meat, 6)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder().duration(40).EUt(16)
                .inputs(new ItemStack(Items.CHICKEN))
                .output(dust, Meat)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder().duration(40).EUt(16)
                .inputs(new ItemStack(Items.MUTTON))
                .output(dust, Meat)
                .buildAndRegister();

        // Explosives
        CHEMICAL_RECIPES.recipeBuilder().duration(80).EUt(480)
                .inputs(GELLED_TOLUENE.getStackForm(4))
                .fluidInputs(NitrationMixture.getFluid(200))
                .outputs(GAMetaBlocks.EXPLOSIVE.getItemVariant(GAExplosive.ExplosiveType.ITNT))
                .fluidOutputs(DilutedSulfuricAcid.getFluid(150))
                .buildAndRegister();

        ModHandler.addShapedRecipe("powder_barrel", GAMetaBlocks.EXPLOSIVE.getItemVariant(GAExplosive.ExplosiveType.POWDER_BARREL),
                "PSP", "GGG", "PGP",
                'P', new UnificationEntry(plate, Wood),
                'S', "string",
                'G', new UnificationEntry(dust, Gunpowder));

        // Glass Lens
        ModHandler.addShapedRecipe("glass_lens", OreDictUnifier.get(lens, Glass),
                "FfF", "FGF", "FDF",
                'F', new ItemStack(Items.FLINT),
                'G', new ItemStack(Blocks.GLASS),
                'D', new ItemStack(Items.DIAMOND));
    }
}
