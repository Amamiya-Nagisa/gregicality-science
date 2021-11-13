package gregicadditions.jei.multi.simple;

import com.google.common.collect.Lists;
import gregicadditions.item.GAMetaBlocks;
import gregicadditions.item.metal.MetalCasing1;
import gregicadditions.machines.GAMetaTileEntities;
import gregtech.api.GTValues;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.common.blocks.BlockBoilerCasing;
import gregtech.common.blocks.BlockMultiblockCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.integration.jei.multiblock.MultiblockInfoPage;
import gregtech.integration.jei.multiblock.MultiblockShapeInfo;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;

import java.util.ArrayList;
import java.util.List;

import static gregicadditions.item.GAMetaBlocks.METAL_CASING_1;

public class LargeCentrifugeInfo extends MultiblockInfoPage {
	@Override
	public MultiblockControllerBase getController() {
		return GAMetaTileEntities.LARGE_CENTRIFUGE;
	}

	@Override
	public List<MultiblockShapeInfo> getMatchingShapes() {
		ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
			shapeInfo.add(MultiblockShapeInfo.builder()
					.aisle("#XEX#", "XXGXX", "#XXX#")
					.aisle("IXXXX", "i###X", "XXXXX")
					.aisle("XXMXX", "G#P#G", "XXmXX")
					.aisle("OXXXX", "o###X", "XXXXX")
					.aisle("#XHX#", "XXSXX", "#XXX#")
					.where('E', MetaTileEntities.ENERGY_INPUT_HATCH[GTValues.HV], EnumFacing.NORTH)
					.where('S', GAMetaTileEntities.LARGE_CENTRIFUGE, EnumFacing.SOUTH)
					.where('H', maintenanceIfEnabled(METAL_CASING_1.getState(MetalCasing1.CasingType.TUMBAGA)), EnumFacing.SOUTH)
					.where('X', METAL_CASING_1.getState(MetalCasing1.CasingType.TUMBAGA))
					.where('#', Blocks.AIR.getDefaultState())
					.where('I', MetaTileEntities.ITEM_IMPORT_BUS[GTValues.LV], EnumFacing.WEST)
					.where('O', MetaTileEntities.ITEM_EXPORT_BUS[GTValues.LV], EnumFacing.WEST)
					.where('i', MetaTileEntities.FLUID_IMPORT_HATCH[GTValues.LV], EnumFacing.WEST)
					.where('o', MetaTileEntities.FLUID_EXPORT_HATCH[GTValues.LV], EnumFacing.WEST)
					.where('M', GAMetaBlocks.MOTOR_CASING.getDefaultState())
					.where('m', MetaTileEntities.MUFFLER_HATCH[0], EnumFacing.UP)
					.where('P', MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TITANIUM_PIPE))
					.where('G', MetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.GRATE_CASING))
					.build());

		shapeInfo.add(MultiblockShapeInfo.builder()
				.aisle("#XEX#", "XXGXX", "#XXX#")
				.aisle("IXXXX", "i###X", "XXXXX")
				.aisle("XXMXX", "m#P#G", "XXGXX")
				.aisle("OXXXX", "o###X", "XXXXX")
				.aisle("#XHX#", "XXSXX", "#XXX#")
				.where('E', MetaTileEntities.ENERGY_INPUT_HATCH[GTValues.HV], EnumFacing.NORTH)
				.where('S', GAMetaTileEntities.LARGE_CENTRIFUGE, EnumFacing.SOUTH)
				.where('H', maintenanceIfEnabled(METAL_CASING_1.getState(MetalCasing1.CasingType.TUMBAGA)), EnumFacing.SOUTH)
				.where('X', METAL_CASING_1.getState(MetalCasing1.CasingType.TUMBAGA))
				.where('#', Blocks.AIR.getDefaultState())
				.where('I', MetaTileEntities.ITEM_IMPORT_BUS[GTValues.LV], EnumFacing.WEST)
				.where('O', MetaTileEntities.ITEM_EXPORT_BUS[GTValues.LV], EnumFacing.WEST)
				.where('i', MetaTileEntities.FLUID_IMPORT_HATCH[GTValues.LV], EnumFacing.WEST)
				.where('o', MetaTileEntities.FLUID_EXPORT_HATCH[GTValues.LV], EnumFacing.WEST)
				.where('M', GAMetaBlocks.MOTOR_CASING.getDefaultState())
				.where('m', MetaTileEntities.MUFFLER_HATCH[0], EnumFacing.WEST)
				.where('P', MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TITANIUM_PIPE))
				.where('G', MetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.GRATE_CASING))
				.build());

		shapeInfo.add(MultiblockShapeInfo.builder()
				.aisle("#XEX#", "XXGXX", "#XXX#")
				.aisle("IXXXX", "i###X", "XXXXX")
				.aisle("XXMXX", "G#P#m", "XXGXX")
				.aisle("OXXXX", "o###X", "XXXXX")
				.aisle("#XHX#", "XXSXX", "#XXX#")
				.where('E', MetaTileEntities.ENERGY_INPUT_HATCH[GTValues.HV], EnumFacing.NORTH)
				.where('S', GAMetaTileEntities.LARGE_CENTRIFUGE, EnumFacing.SOUTH)
				.where('H', maintenanceIfEnabled(METAL_CASING_1.getState(MetalCasing1.CasingType.TUMBAGA)), EnumFacing.SOUTH)
				.where('X', METAL_CASING_1.getState(MetalCasing1.CasingType.TUMBAGA))
				.where('#', Blocks.AIR.getDefaultState())
				.where('I', MetaTileEntities.ITEM_IMPORT_BUS[GTValues.LV], EnumFacing.WEST)
				.where('O', MetaTileEntities.ITEM_EXPORT_BUS[GTValues.LV], EnumFacing.WEST)
				.where('i', MetaTileEntities.FLUID_IMPORT_HATCH[GTValues.LV], EnumFacing.WEST)
				.where('o', MetaTileEntities.FLUID_EXPORT_HATCH[GTValues.LV], EnumFacing.WEST)
				.where('M', GAMetaBlocks.MOTOR_CASING.getDefaultState())
				.where('m', MetaTileEntities.MUFFLER_HATCH[0], EnumFacing.EAST)
				.where('P', MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TITANIUM_PIPE))
				.where('G', MetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.GRATE_CASING))
				.build());
		shapeInfo.add(MultiblockShapeInfo.builder()
				.aisle("#XEX#", "XXmXX", "#XXX#")
				.aisle("IXXXX", "i###X", "XXXXX")
				.aisle("XXMXX", "G#P#G", "XXGXX")
				.aisle("OXXXX", "o###X", "XXXXX")
				.aisle("#XHX#", "XXSXX", "#XXX#")
				.where('E', MetaTileEntities.ENERGY_INPUT_HATCH[GTValues.HV], EnumFacing.NORTH)
				.where('S', GAMetaTileEntities.LARGE_CENTRIFUGE, EnumFacing.SOUTH)
				.where('H', maintenanceIfEnabled(METAL_CASING_1.getState(MetalCasing1.CasingType.TUMBAGA)), EnumFacing.SOUTH)
				.where('X', METAL_CASING_1.getState(MetalCasing1.CasingType.TUMBAGA))
				.where('#', Blocks.AIR.getDefaultState())
				.where('I', MetaTileEntities.ITEM_IMPORT_BUS[GTValues.LV], EnumFacing.WEST)
				.where('O', MetaTileEntities.ITEM_EXPORT_BUS[GTValues.LV], EnumFacing.WEST)
				.where('i', MetaTileEntities.FLUID_IMPORT_HATCH[GTValues.LV], EnumFacing.WEST)
				.where('o', MetaTileEntities.FLUID_EXPORT_HATCH[GTValues.LV], EnumFacing.WEST)
				.where('M', GAMetaBlocks.MOTOR_CASING.getDefaultState())
				.where('m', MetaTileEntities.MUFFLER_HATCH[0], EnumFacing.NORTH)
				.where('P', MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TITANIUM_PIPE))
				.where('G', MetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.GRATE_CASING))
				.build());

		return Lists.newArrayList(shapeInfo);
	}

	@Override
	public String[] getDescription() {
		return new String[]{"This multiblock only forms with at least 16 tumbaga casings."};
	}
}
