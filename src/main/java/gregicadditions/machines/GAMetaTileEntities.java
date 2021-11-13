package gregicadditions.machines;

import gregicadditions.GAConfig;
import gregicadditions.GAValues;
import gregicadditions.Gregicality;
import gregicadditions.client.ClientHandler;
import gregicadditions.machines.multi.*;
import gregicadditions.machines.multi.advance.*;
import gregicadditions.machines.multi.advance.hyper.*;
import gregicadditions.machines.multi.centralmonitor.MetaTileEntityCentralMonitor;
import gregicadditions.machines.multi.centralmonitor.MetaTileEntityMonitorScreen;
import gregicadditions.machines.multi.drill.MetaTileEntityFluidDrillingPlant;
import gregicadditions.machines.multi.impl.MetaTileEntityRotorHolderForNuclearCoolant;
import gregicadditions.machines.multi.mega.MetaTileEntityMegaBlastFurnace;
import gregicadditions.machines.multi.mega.MetaTileEntityMegaDistillationTower;
import gregicadditions.machines.multi.mega.MetaTileEntityMegaVacuumFreezer;
import gregicadditions.machines.multi.miner.*;
import gregicadditions.machines.multi.multiblockpart.MetaTileEntityQubitHatch;
import gregicadditions.machines.multi.miner.MetaTileEntityChunkMiner;
import gregicadditions.machines.multi.miner.MetaTileEntityLargeMiner;
import gregicadditions.machines.multi.miner.MetaTileEntityVoidMiner;
import gregicadditions.machines.multi.miner.Miner;
import gregicadditions.machines.multi.nuclear.*;
import gregicadditions.machines.multi.qubit.*;
import gregicadditions.machines.multi.simple.*;
import gregicadditions.machines.multi.uumatter.*;
import gregicadditions.recipes.GARecipeMaps;
import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.metatileentity.SimpleGeneratorMetaTileEntity;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.render.Textures;
import net.minecraft.util.ResourceLocation;

import static gregtech.common.metatileentities.MetaTileEntities.registerSimpleMetaTileEntity;

public class GAMetaTileEntities {

    // TODO Move to CEu
    public static MetaTileEntityMonitorScreen MONITOR_SCREEN; // todo move to CEu
    public static MetaTileEntityCentralMonitor CENTRAL_MONITOR; // todo move to CEu
    public static MetaTileEntityLargeMiner[] LARGE_MINER = new MetaTileEntityLargeMiner[3]; // todo move to CEu
    public static MetaTileEntityBatteryTower BATTERY_TOWER; // todo move to CEu, and rework
    public static MetaTileEntityFluidDrillingPlant[] FLUID_DRILLING_PLANT = new MetaTileEntityFluidDrillingPlant[3]; // todo move to CEu
    public static MetaTileEntityChunkMiner[] MINER = new MetaTileEntityChunkMiner[3]; // todo move to CEu
    public static SimpleMachineMetaTileEntity[] DISASSEMBLER = new SimpleMachineMetaTileEntity[14]; // todo move to CEu

    // TODO Nuclear rework
    public static MetaTileEntityNuclearReactor NUCLEAR_REACTOR;
    public static MetaTileEntityNuclearReactor NUCLEAR_BREEDER;
    public static MetaTileEntityGasCentrifuge GAS_CENTRIFUGE;
    public static MetaTileEntityHotCoolantTurbine HOT_COOLANT_TURBINE;
    public static MetaTileEntityRotorHolderForNuclearCoolant[] ROTOR_HOLDER = new MetaTileEntityRotorHolderForNuclearCoolant[4];

    // TODO Organize
    public static SimpleMachineMetaTileEntity[] DEHYDRATOR = new SimpleMachineMetaTileEntity[14];
    public static SimpleMachineMetaTileEntity[] DECAY_CHAMBER = new SimpleMachineMetaTileEntity[14];
    public static SimpleMachineMetaTileEntity[] GREEN_HOUSE = new SimpleMachineMetaTileEntity[14];
    public static SimpleGeneratorMetaTileEntity[] NAQUADAH_REACTOR = new SimpleGeneratorMetaTileEntity[8]; // todo idk what but something needs to be done about this
    public static SimpleGeneratorMetaTileEntity[] ROCKET_GENERATOR = new SimpleGeneratorMetaTileEntity[8];
    public static TileEntityLargeThermalCentrifuge LARGE_THERMAL_CENTRIFUGE;
    public static TileEntityLargeElectrolyzer LARGE_ELECTROLYZER;
    public static TileEntityLargeCentrifuge LARGE_CENTRIFUGE;
    public static TileEntityLargeCutting LARGE_CUTTING;
    public static TileEntityLargeMacerator LARGE_MACERATOR;
    public static TileEntityLargeMixer LARGE_MIXER;
    public static TileEntityLargeBenderAndForming LARGE_BENDER_AND_FORMING;
    public static TileEntityLargeSifter LARGE_SIFTER;
    public static TileEntityLargeWashingPlant LARGE_WASHING_PLANT;
    public static TileEntityLargeWiremill LARGE_WIREMILL;
    public static TileEntityLargeExtruder LARGE_EXTRUDER;
    public static TileEntityLargeAssembler LARGE_ASSEMBLER;
    public static TileEntityLargeCircuitAssemblyLine LARGE_CIRCUIT_ASSEMBLY_LINE;
    public static MetaTileEntityVoidMiner[] VOID_MINER = new MetaTileEntityVoidMiner[3];
    public static MetaTileEntityAdvancedDistillationTower ADVANCED_DISTILLATION_TOWER;
    public static MetaTileEntityLargeRocketEngine LARGE_ROCKET_ENGINE;
    public static TileEntityAlloyBlastFurnace ALLOY_BLAST_FURNACE;
    public static TileEntityLargeForgeHammer LARGE_FORGE_HAMMER;
    public static MetaTileEntityLargeNaquadahReactor LARGE_NAQUADAH_REACTOR;
    public static MetaTileEntityHyperReactorI HYPER_REACTOR_I;
    public static MetaTileEntityHyperReactorII HYPER_REACTOR_II;
    public static MetaTileEntityHyperReactorIII HYPER_REACTOR_III;
    public static MetaTileEntityAdvFusionReactor ADVANCED_FUSION_REACTOR;
    public static MetaTileEntityStellarForge STELLAR_FORGE;
    public static MetaTileEntityQubitComputer QUBIT_COMPUTER;
    public static MetaTileEntityBioReactor BIO_REACTOR;
    public static TileEntityLargePackager LARGE_PACKAGER;
    public static MetaTileEntityCosmicRayDetector COSMIC_RAY_DETECTOR;
    public static TileEntityLargeLaserEngraver LARGE_LASER_ENGRAVER;
    public static MetaTileEntityQubitHatch[] QBIT_INPUT_HATCH = new MetaTileEntityQubitHatch[GAValues.QUBIT.length];
    public static MetaTileEntityQubitHatch[] QBIT_OUTPUT_HATCH = new MetaTileEntityQubitHatch[GAValues.QUBIT.length];
    public static MetaTileEntitySteamPump STEAM_PUMP;
    public static MetaTileEntitySteamMixer STEAM_MIXER;
    public static MetaTileEntityPlasmaCondenser PLASMA_CONDENSER;
    public static MetaTileEntityElectricImplosion ELECTRIC_IMPLOSION;
    public static TileEntitySteamMiner STEAM_MINER;
    public static TileEntityChemicalPlant CHEMICAL_PLANT;
    public static TileEntityLargeBrewery LARGE_BREWERY;
    public static TileEntityLargeElectromagnet LARGE_ELECTROMAGNET;
    public static TileEntityLargeExtractor LARGE_EXTRACTOR;
    public static TileEntityLargeArcFurnace LARGE_ARC_FURNACE;
    public static TileEntityLargeCanningMachine LARGE_CANNING_MACHINE;
    public static TileEntityLargeMassFabricator LARGE_MASS_FABRICATOR;
    public static TileEntityLargeReplicator LARGE_REPLICATOR;
    public static MetaTileEntityMegaDistillationTower MEGA_DISTILLATION_TOWER;
    public static MetaTileEntityMegaBlastFurnace MEGA_BLAST_FURNACE;
    public static MetaTileEntityMegaVacuumFreezer MEGA_VACUUM_FREEZER;

    public static void init() {

        // todo REORGANIZE IDs, there will be conflicts, and it is also a total mess right now

        // todo rename everything to start with "MetaTileEntity"

        // todo get rid of all of the dumb overrides for base classes. GAWorkableTieredMetaTileEntity, GATieredMetaTileEntity, etc etc etc

        // todo comment this better for ID range clarity

        // Simple Machines
        registerSimpleMetaTileEntity(DEHYDRATOR, 2000, "dehydrator", GARecipeMaps.CHEMICAL_DEHYDRATOR_RECIPES, Textures.SIFTER_OVERLAY, true, GAMetaTileEntities::location);
        registerSimpleMetaTileEntity(DECAY_CHAMBER, 2015, "decay_chamber", GARecipeMaps.DECAY_CHAMBERS_RECIPES, Textures.REPLICATOR_OVERLAY, true, GAMetaTileEntities::location);
        registerSimpleMetaTileEntity(GREEN_HOUSE, 2030, "green_house", GARecipeMaps.GREEN_HOUSE_RECIPES, Textures.FERMENTER_OVERLAY, true, GAMetaTileEntities::location);

        // Simple Generators
        NAQUADAH_REACTOR[4] = GregTechAPI.registerMetaTileEntity(2051, new SimpleGeneratorMetaTileEntity(location("naquadah_reactor.mk2"), GARecipeMaps.NAQUADAH_REACTOR_FUELS, ClientHandler.NAQADAH_OVERLAY, 5));
        NAQUADAH_REACTOR[5] = GregTechAPI.registerMetaTileEntity(2052, new SimpleGeneratorMetaTileEntity(location("naquadah_reactor.mk3"), GARecipeMaps.NAQUADAH_REACTOR_FUELS, ClientHandler.NAQADAH_OVERLAY, 6));
        NAQUADAH_REACTOR[6] = GregTechAPI.registerMetaTileEntity(2053, new SimpleGeneratorMetaTileEntity(location("naquadah_reactor.mk4"), GARecipeMaps.NAQUADAH_REACTOR_FUELS, ClientHandler.NAQADAH_OVERLAY, 7));

        ROCKET_GENERATOR[3] = GregTechAPI.registerMetaTileEntity(2065, new SimpleGeneratorMetaTileEntity(location("rocket_generator.mk1"), GARecipeMaps.ROCKET_FUEL_RECIPES, ClientHandler.ROCKET_OVERLAY, 4));
        ROCKET_GENERATOR[4] = GregTechAPI.registerMetaTileEntity(2066, new SimpleGeneratorMetaTileEntity(location("rocket_generator.mk2"), GARecipeMaps.ROCKET_FUEL_RECIPES, ClientHandler.ROCKET_OVERLAY, 5));
        ROCKET_GENERATOR[5] = GregTechAPI.registerMetaTileEntity(2067, new SimpleGeneratorMetaTileEntity(location("rocket_generator.mk3"), GARecipeMaps.ROCKET_FUEL_RECIPES, ClientHandler.ROCKET_OVERLAY, 6));

        // Steam Machines
        STEAM_PUMP = GregTechAPI.registerMetaTileEntity(2075, new MetaTileEntitySteamPump(location("pump.steam")));
        STEAM_MIXER = GregTechAPI.registerMetaTileEntity(2077, new MetaTileEntitySteamMixer(location("steam_mixer")));
        STEAM_MINER = GregTechAPI.registerMetaTileEntity(2079, new TileEntitySteamMiner(location("steam_miner")));

        // Multiblocks

        // "Upgraded Versions"
        LARGE_CIRCUIT_ASSEMBLY_LINE = GregTechAPI.registerMetaTileEntity(3000, new TileEntityLargeCircuitAssemblyLine(location("large_circuit_assembly")));
        LARGE_THERMAL_CENTRIFUGE = GregTechAPI.registerMetaTileEntity(3001, new TileEntityLargeThermalCentrifuge(location("large_thermal_centrifuge")));
        LARGE_ELECTROLYZER = GregTechAPI.registerMetaTileEntity(3002, new TileEntityLargeElectrolyzer(location("large_electrolyzer")));
        LARGE_BENDER_AND_FORMING = GregTechAPI.registerMetaTileEntity(3003, new TileEntityLargeBenderAndForming(location("large_bender_and_forming"), RecipeMaps.BENDER_RECIPES));
        LARGE_CENTRIFUGE = GregTechAPI.registerMetaTileEntity(3004, new TileEntityLargeCentrifuge(location("large_centrifuge")));
        LARGE_CUTTING = GregTechAPI.registerMetaTileEntity(3005, new TileEntityLargeCutting(location("large_cutting")));
        LARGE_MACERATOR = GregTechAPI.registerMetaTileEntity(3006, new TileEntityLargeMacerator(location("large_macerator")));
        LARGE_MIXER = GregTechAPI.registerMetaTileEntity(3007, new TileEntityLargeMixer(location("large_mixer")));
        LARGE_SIFTER = GregTechAPI.registerMetaTileEntity(3008, new TileEntityLargeSifter(location("large_sifter")));
        LARGE_WASHING_PLANT = GregTechAPI.registerMetaTileEntity(3009, new TileEntityLargeWashingPlant(location("large_washing_plant"), RecipeMaps.ORE_WASHER_RECIPES));
        LARGE_WIREMILL = GregTechAPI.registerMetaTileEntity(3010, new TileEntityLargeWiremill(location("large_wiremill")));
        LARGE_EXTRUDER = GregTechAPI.registerMetaTileEntity(3011, new TileEntityLargeExtruder(location("large_extruder")));
        LARGE_ASSEMBLER = GregTechAPI.registerMetaTileEntity(3012, new TileEntityLargeAssembler(location("large_assembler")));
        ADVANCED_DISTILLATION_TOWER = GregTechAPI.registerMetaTileEntity(3013, new MetaTileEntityAdvancedDistillationTower(location("advanced_distillation_tower"), RecipeMaps.DISTILLERY_RECIPES));
        LARGE_ROCKET_ENGINE = GregTechAPI.registerMetaTileEntity(3015, new MetaTileEntityLargeRocketEngine(location("large_rocket_engine")));
        ALLOY_BLAST_FURNACE = GregTechAPI.registerMetaTileEntity(3016, new TileEntityAlloyBlastFurnace(location("alloy_blast_furnace")));
        LARGE_FORGE_HAMMER = GregTechAPI.registerMetaTileEntity(3017, new TileEntityLargeForgeHammer(location("large_forge_hammer")));
        LARGE_NAQUADAH_REACTOR = GregTechAPI.registerMetaTileEntity(3018, new MetaTileEntityLargeNaquadahReactor(location("large_naquadah_reactor")));
        LARGE_BREWERY = GregTechAPI.registerMetaTileEntity(3019, new TileEntityLargeBrewery(location("large_brewery"), RecipeMaps.BREWING_RECIPES));
        LARGE_ELECTROMAGNET = GregTechAPI.registerMetaTileEntity(3020, new TileEntityLargeElectromagnet(location("large_electromagnet"), RecipeMaps.POLARIZER_RECIPES));
        LARGE_EXTRACTOR = GregTechAPI.registerMetaTileEntity(3021, new TileEntityLargeExtractor(location("large_extractor")));
        LARGE_ARC_FURNACE = GregTechAPI.registerMetaTileEntity(3022, new TileEntityLargeArcFurnace(location("large_arc_furnace")));
        LARGE_CANNING_MACHINE = GregTechAPI.registerMetaTileEntity(3023, new TileEntityLargeCanningMachine(location("large_canning_machine"), RecipeMaps.CANNER_RECIPES));
        LARGE_MASS_FABRICATOR = GregTechAPI.registerMetaTileEntity(3024, new TileEntityLargeMassFabricator(location("large_mass_fabricator"), RecipeMaps.MASS_FABRICATOR_RECIPES));
        LARGE_REPLICATOR = GregTechAPI.registerMetaTileEntity(3025, new TileEntityLargeReplicator(location("large_replicator"), RecipeMaps.REPLICATOR_RECIPES));
        MEGA_DISTILLATION_TOWER = GregTechAPI.registerMetaTileEntity(3026, new MetaTileEntityMegaDistillationTower(location("mega_distillation_tower")));
        MEGA_BLAST_FURNACE = GregTechAPI.registerMetaTileEntity(3027, new MetaTileEntityMegaBlastFurnace(location("mega_blast_furnace")));
        MEGA_VACUUM_FREEZER = GregTechAPI.registerMetaTileEntity(3028, new MetaTileEntityMegaVacuumFreezer(location("mega_vacuum_freezer")));
        ELECTRIC_IMPLOSION = GregTechAPI.registerMetaTileEntity(3039, new MetaTileEntityElectricImplosion(location("electric_implosion")));
        LARGE_PACKAGER = GregTechAPI.registerMetaTileEntity(3040, new TileEntityLargePackager(location("large_packager"), RecipeMaps.PACKER_RECIPES));
        LARGE_LASER_ENGRAVER = GregTechAPI.registerMetaTileEntity(3041, new TileEntityLargeLaserEngraver(location("large_laser_engraver")));

        // Totally new Multis
        CHEMICAL_PLANT = GregTechAPI.registerMetaTileEntity(3200, new TileEntityChemicalPlant(location("chemical_plant")));
        VOID_MINER[0] = GregTechAPI.registerMetaTileEntity(3201, new MetaTileEntityVoidMiner(location("void_miner"), GTValues.UV, GAConfig.multis.voidMiner.maxTemp));
        VOID_MINER[1] = GregTechAPI.registerMetaTileEntity(3202, new MetaTileEntityVoidMiner(location("void_miner.uhv"), GTValues.UHV, GAConfig.multis.voidMiner.maxTempUHV));
        VOID_MINER[2] = GregTechAPI.registerMetaTileEntity(3203, new MetaTileEntityVoidMiner(location("void_miner.uev"), GTValues.UEV, GAConfig.multis.voidMiner.maxTempUEV));
        HYPER_REACTOR_I = GregTechAPI.registerMetaTileEntity(3204, new MetaTileEntityHyperReactorI(location("hyper_reactor.i"), GAConfig.multis.hyperReactors.euGeneration[0]));
        HYPER_REACTOR_II = GregTechAPI.registerMetaTileEntity(3205, new MetaTileEntityHyperReactorII(location("hyper_reactor.ii"), GAConfig.multis.hyperReactors.euGeneration[1]));
        HYPER_REACTOR_III = GregTechAPI.registerMetaTileEntity(3206, new MetaTileEntityHyperReactorIII(location("hyper_reactor.iii"), GAConfig.multis.hyperReactors.euGeneration[2]));
        STELLAR_FORGE = GregTechAPI.registerMetaTileEntity(3207, new MetaTileEntityStellarForge(location("stellar_forge")));
        ADVANCED_FUSION_REACTOR = GregTechAPI.registerMetaTileEntity(3208, new MetaTileEntityAdvFusionReactor(location("advanced_fusion_reactor")));
        QUBIT_COMPUTER = GregTechAPI.registerMetaTileEntity(3209, new MetaTileEntityQubitComputer(location("qubit_computer")));
        BIO_REACTOR = GregTechAPI.registerMetaTileEntity(3210, new MetaTileEntityBioReactor(location("bio_reactor")));
        PLASMA_CONDENSER = GregTechAPI.registerMetaTileEntity(3211, new MetaTileEntityPlasmaCondenser(location("plasma_condenser")));
        COSMIC_RAY_DETECTOR = GregTechAPI.registerMetaTileEntity(3212, new MetaTileEntityCosmicRayDetector(location("cosmic_ray_detector")));

        // Misc MTEs
        QBIT_INPUT_HATCH[0] = GregTechAPI.registerMetaTileEntity(3603, new MetaTileEntityQubitHatch(location("qubit_hatch.input.16"), 0, 16, false));
        QBIT_OUTPUT_HATCH[0] = GregTechAPI.registerMetaTileEntity(3604, new MetaTileEntityQubitHatch(location("qubit_hatch.output.1"), 0, 1, true));








        // TODO Move to CEu
        CENTRAL_MONITOR = GregTechAPI.registerMetaTileEntity(3948, new MetaTileEntityCentralMonitor(location("central_monitor")));
        MONITOR_SCREEN = GregTechAPI.registerMetaTileEntity(3949, new MetaTileEntityMonitorScreen(location("monitor_screen")));
        FLUID_DRILLING_PLANT[0] = GregTechAPI.registerMetaTileEntity(3954, new MetaTileEntityFluidDrillingPlant(location("fluid_drilling_plant_mv"), 2));
        FLUID_DRILLING_PLANT[1] = GregTechAPI.registerMetaTileEntity(3955, new MetaTileEntityFluidDrillingPlant(location("fluid_drilling_plant_hv"), 3));
        FLUID_DRILLING_PLANT[2] = GregTechAPI.registerMetaTileEntity(3956, new MetaTileEntityFluidDrillingPlant(location("fluid_drilling_plant_ev"), 4));
        MINER[0] = GregTechAPI.registerMetaTileEntity(3984, new MetaTileEntityChunkMiner(location("miner.lv"), Miner.Type.LV, 1));
        MINER[1] = GregTechAPI.registerMetaTileEntity(3985, new MetaTileEntityChunkMiner(location("miner.mv"), Miner.Type.MV, 2));
        MINER[2] = GregTechAPI.registerMetaTileEntity(3986, new MetaTileEntityChunkMiner(location("miner.hv"), Miner.Type.HV, 3));
        LARGE_MINER[0] = GregTechAPI.registerMetaTileEntity(3987, new MetaTileEntityLargeMiner(location("miner.basic"), Miner.Type.BASIC));
        LARGE_MINER[1] = GregTechAPI.registerMetaTileEntity(3988, new MetaTileEntityLargeMiner(location("miner.large"), Miner.Type.LARGE));
        LARGE_MINER[2] = GregTechAPI.registerMetaTileEntity(3989, new MetaTileEntityLargeMiner(location("miner.advance"), Miner.Type.ADVANCE));
        BATTERY_TOWER = GregTechAPI.registerMetaTileEntity(3990, new MetaTileEntityBatteryTower(location("battery_tower")));
        // todo this needs to deal with tiered tooltip
        if (GAConfig.Misc.enableDisassembly) registerSimpleMetaTileEntity(DISASSEMBLER, 3900, "disassembler", GARecipeMaps.DISASSEMBLER_RECIPES, Textures.ASSEMBLER_OVERLAY, true, GAMetaTileEntities::location);

        // TODO Nuclear Rework
        //GAS_CENTRIFUGE = GregTechAPI.registerMetaTileEntity(4020, new MetaTileEntityGasCentrifuge(location("gas_centrifuge")));
        //HOT_COOLANT_TURBINE = GregTechAPI.registerMetaTileEntity(2544, new MetaTileEntityHotCoolantTurbine(location("large_turbine.hot_coolant"), MetaTileEntityHotCoolantTurbine.TurbineType.HOT_COOLANT));
        //NUCLEAR_REACTOR = GregTechAPI.registerMetaTileEntity(2545, new MetaTileEntityNuclearReactor(location("nuclear_reactor"), GARecipeMaps.NUCLEAR_REACTOR_RECIPES));
        //NUCLEAR_BREEDER = GregTechAPI.registerMetaTileEntity(2546, new MetaTileEntityNuclearReactor(location("nuclear_breeder"), GARecipeMaps.NUCLEAR_BREEDER_RECIPES));
        //ROTOR_HOLDER[0] = GregTechAPI.registerMetaTileEntity(3600, new MetaTileEntityRotorHolderForNuclearCoolant(location("rotor_holder.hv"), GTValues.HV, 1.1f));
        //ROTOR_HOLDER[1] = GregTechAPI.registerMetaTileEntity(3601, new MetaTileEntityRotorHolderForNuclearCoolant(location("rotor_holder.luv"), GTValues.LuV, 1.35f));
        //ROTOR_HOLDER[2] = GregTechAPI.registerMetaTileEntity(3602, new MetaTileEntityRotorHolderForNuclearCoolant(location("rotor_holder.uhv"), GTValues.UHV, 1.7f));
    }

    public static ResourceLocation location(String name) {
        return new ResourceLocation(Gregicality.MODID, name);
    }
}
