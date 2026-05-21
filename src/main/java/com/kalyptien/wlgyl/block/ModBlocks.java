package com.kalyptien.wlgyl.block;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import com.kalyptien.wlgyl.block.custom.*;
import com.kalyptien.wlgyl.item.ModItems;
import com.kalyptien.wlgyl.util.AgrumesVariant;
import com.kalyptien.wlgyl.util.FruitsVariant;
import com.kalyptien.wlgyl.worldgen.tree.ModTreeGrowers;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(WhenLifeGivesYouLemonsMod.MOD_ID);

    public static final DeferredBlock<Block> LEMON_LEAVES = registerBlock("lemon_leaves",
            () -> new AgrumeLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), AgrumesVariant.LEMON, ModItems.LEMON));
    public static final DeferredBlock<Block> ORANGE_LEAVES = registerBlock("orange_leaves",
            () -> new AgrumeLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), AgrumesVariant.ORANGE, ModItems.ORANGE));
    public static final DeferredBlock<Block> LIME_LEAVES = registerBlock("lime_leaves",
            () -> new AgrumeLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), AgrumesVariant.LIME, ModItems.LIME));
    public static final DeferredBlock<Block> GRAPEFRUIT_LEAVES = registerBlock("grapefruit_leaves",
            () -> new AgrumeLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), AgrumesVariant.GRAPEFRUIT, ModItems.GRAPEFRUIT));
    public static final DeferredBlock<Block> CAVIAR_LEMON_LEAVES = registerBlock("caviar_lemon_leaves",
            () -> new AgrumeLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), AgrumesVariant.CAVIAR_LEMON, ModItems.CAVIAR_LEMON));
    public static final DeferredBlock<Block> BUDDHA_HAND_LEAVES = registerBlock("buddha_hand_leaves",
            () -> new AgrumeLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), AgrumesVariant.BUDDHA_HAND, ModItems.BUDDHA_HAND));
    public static final DeferredBlock<Block> BLOOD_ORANGE_LEAVES = registerBlock("blood_orange_leaves",
            () -> new AgrumeLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), AgrumesVariant.BLOOD_ORANGE, ModItems.BLOOD_ORANGE));

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
