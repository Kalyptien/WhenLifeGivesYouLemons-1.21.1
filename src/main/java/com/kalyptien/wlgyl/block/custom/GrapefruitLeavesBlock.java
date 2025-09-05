package com.kalyptien.wlgyl.block.custom;

import com.kalyptien.wlgyl.item.ModItems;
import net.minecraft.world.level.ItemLike;

public class GrapefruitLeavesBlock extends  AgrumeLeavesBlock{

    public GrapefruitLeavesBlock(Properties properties) {
        super(properties);
    }

    public ItemLike getAgrumeProperty() {
        return ModItems.GRAPEFRUIT;
    }
}
