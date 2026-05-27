package com.kalyptien.wlgyl.block;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import com.kalyptien.wlgyl.block.custom.*;
import com.kalyptien.wlgyl.item.ModItems;
import com.kalyptien.wlgyl.util.FruitsVariant;
import com.kalyptien.wlgyl.worldgen.tree.ModTreeGrowers;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(WhenLifeGivesYouLemonsMod.MOD_ID);

    // LEAVES
    public static final DeferredBlock<Block> LEMON_LEAVES = registerBlock("lemon_leaves",
            () -> new CitrusLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), FruitsVariant.LEMON, ModItems.LEMON));
    public static final DeferredBlock<Block> ORANGE_LEAVES = registerBlock("orange_leaves",
            () -> new CitrusLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), FruitsVariant.ORANGE, ModItems.ORANGE));
    public static final DeferredBlock<Block> LIME_LEAVES = registerBlock("lime_leaves",
            () -> new CitrusLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), FruitsVariant.LIME, ModItems.LIME));
    public static final DeferredBlock<Block> GRAPEFRUIT_LEAVES = registerBlock("grapefruit_leaves",
            () -> new CitrusLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), FruitsVariant.GRAPEFRUIT, ModItems.GRAPEFRUIT));
    public static final DeferredBlock<Block> CAVIAR_LEMON_LEAVES = registerBlock("caviar_lemon_leaves",
            () -> new CitrusLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), FruitsVariant.CAVIAR_LEMON, ModItems.CAVIAR_LEMON));
    public static final DeferredBlock<Block> BUDDHA_HAND_LEAVES = registerBlock("buddha_hand_leaves",
            () -> new CitrusLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), FruitsVariant.BUDDHA_HAND, ModItems.BUDDHA_HAND));
    public static final DeferredBlock<Block> BLOOD_ORANGE_LEAVES = registerBlock("blood_orange_leaves",
            () -> new CitrusLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), FruitsVariant.BLOOD_ORANGE, ModItems.BLOOD_ORANGE));

    //SAPLINGS
    public static final DeferredBlock<Block> LEMON_SAPLING = registerBlock("lemon_sapling",
            () -> new SaplingBlock(ModTreeGrowers.LEMON_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> ORANGE_SAPLING = registerBlock("orange_sapling",
            () -> new SaplingBlock(ModTreeGrowers.ORANGE_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> BLOOD_ORANGE_SAPLING = registerBlock("blood_orange_sapling",
            () -> new SaplingBlock(ModTreeGrowers.BLOOD_ORANGE_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> BUDDHA_HAND_SAPLING = registerBlock("buddha_hand_sapling",
            () -> new SaplingBlock(ModTreeGrowers.BUDDHA_HAND_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> LIME_SAPLING = registerBlock("lime_sapling",
            () -> new SaplingBlock(ModTreeGrowers.LIME_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> GRAPEFRUIT_SAPLING = registerBlock("grapefruit_sapling",
            () -> new SaplingBlock(ModTreeGrowers.GRAPEFRUIT_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> CAVIAR_LEMON_SAPLING = registerBlock("caviar_lemon_sapling",
            () -> new SaplingBlock(ModTreeGrowers.CAVIAR_LEMON_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    //AGRUME WOOD

    public static final DeferredBlock<Block> CITRUS_LOG = registerBlock("citrus_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> CITRUS_WOOD = registerBlock("citrus_wood",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_CITRUS_LOG = registerBlock("stripped_citrus_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final DeferredBlock<Block> STRIPPED_CITRUS_WOOD = registerBlock("stripped_citrus_wood",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> CITRUS_PLANKS = registerBlock("citrus_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final DeferredBlock<StairBlock> CITRUS_STAIRS = registerBlock("citrus_stairs",
            () -> new StairBlock(ModBlocks.CITRUS_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));
    public static final DeferredBlock<SlabBlock> CITRUS_SLAB = registerBlock("citrus_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)));

    public static final DeferredBlock<PressurePlateBlock> CITRUS_PRESSURE_PLATE = registerBlock("citrus_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)));
    public static final DeferredBlock<ButtonBlock> CITRUS_BUTTON = registerBlock("citrus_button",
            () -> new ButtonBlock(BlockSetType.OAK, 20, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));

    public static final DeferredBlock<FenceBlock> CITRUS_FENCE = registerBlock("citrus_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<FenceGateBlock> CITRUS_FENCE_GATE = registerBlock("citrus_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));

    public static final DeferredBlock<DoorBlock> CITRUS_DOOR = registerBlock("citrus_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
    public static final DeferredBlock<TrapDoorBlock> CITRUS_TRAPDOOR = registerBlock("citrus_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));


    //CRAFT BLOCK
    public static final DeferredBlock<Block> SQUEEZER = registerBlock("squeezer",
            () -> new SqueezerBlock(BlockBehaviour.Properties.of().noOcclusion().randomTicks().strength(0.5F)));

    public static final DeferredBlock<Block> BREWING_BARREL = registerBlock("brewing_barrel",
            () -> new BrewingBarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BARREL)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
