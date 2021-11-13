package gregicadditions.jei.multi.mega;

import com.google.common.collect.Lists;
import gregicadditions.item.GAMetaBlocks;
import gregicadditions.item.GAMultiblockCasing;
import gregicadditions.jei.GAMultiblockShapeInfo;
import gregicadditions.machines.GAMetaTileEntities;
import gregtech.api.GTValues;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.common.blocks.*;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.integration.jei.multiblock.MultiblockInfoPage;
import gregtech.integration.jei.multiblock.MultiblockShapeInfo;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;

import java.util.ArrayList;
import java.util.List;

public class MegaVacuumFreezerInfo extends MultiblockInfoPage {
    @Override
    public MultiblockControllerBase getController() {
        return GAMetaTileEntities.MEGA_VACUUM_FREEZER;
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() { //TODO fix integral frameworks per page
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
//        for (BlockWireCoil.CoilType coilType : BlockWireCoil.CoilType.values()) {
            GAMultiblockShapeInfo.Builder builder = GAMultiblockShapeInfo.builder();
            builder.aisle("#HXMIO#", "#XXSfE#", "#XXXXX#", "#XXXXX#", "#XXXXX#", "#XXXXX#", "#XXXXX#")
                    .aisle("XXXXXXX", "XPFFFPX", "XPFFFPX", "XPPPPPX", "XPFFFPX", "XPFFFPX", "XXXXXXX");
            for (int i = 0; i < 3; i++) {
                builder.aisle("XXXXXXX", "XFAAAFX", "XFAAAFX", "XPGGGPX", "XFAAAFX", "XFAAAFX", "XXXXXXX");
            }
            builder.aisle("XXXXXXX", "XPFFFPX", "XPFFFPX", "XPPPPPX", "XPFFFPX", "XPFFFPX", "XXXXXXX")
                    .aisle("#XXXXX#", "#XXXXX#", "#XXXXX#", "#XXXXX#", "#XXXXX#", "#XXXXX#", "#XXXXX#")
                    .where('H', MetaTileEntities.ENERGY_INPUT_HATCH[GTValues.IV], EnumFacing.NORTH)
                    .where('S', GAMetaTileEntities.MEGA_VACUUM_FREEZER, EnumFacing.NORTH)
                    .where('M', maintenanceIfEnabled(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.ALUMINIUM_FROSTPROOF)), EnumFacing.NORTH)
                    .where('X', MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.ALUMINIUM_FROSTPROOF))
                    .where('#', Blocks.AIR.getDefaultState())
                    .where('I', MetaTileEntities.ITEM_IMPORT_BUS[GTValues.HV], EnumFacing.NORTH)
                    .where('E', MetaTileEntities.FLUID_EXPORT_HATCH[GTValues.HV], EnumFacing.NORTH)
                    .where('O', MetaTileEntities.ITEM_EXPORT_BUS[GTValues.HV], EnumFacing.NORTH)
                    .where('f', MetaTileEntities.FLUID_IMPORT_HATCH[GTValues.HV], EnumFacing.NORTH)
                    .where('P', MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TUNGSTENSTEEL_PIPE))
                    .where('F', GAMetaBlocks.MUTLIBLOCK_CASING.getState(GAMultiblockCasing.CasingType.TIERED_HULL_IV))
                    .where('G', MetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.GRATE_CASING));
            shapeInfo.add(builder.build());
//        }
        return Lists.newArrayList(shapeInfo);
    }

    @Override
    public String[] getDescription() {
        return new String[]{I18n.format("gtadditions.multiblock.mega_vacuum_freezer.description")};
    }

    @Override
    public float getDefaultZoom() {
        return 0.4f;
    }
}
