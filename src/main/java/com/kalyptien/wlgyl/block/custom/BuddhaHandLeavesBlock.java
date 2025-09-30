package com.kalyptien.wlgyl.block.custom;

import com.kalyptien.wlgyl.util.AgrumesVariant;
import com.kalyptien.wlgyl.item.ModItems;
import net.minecraft.world.level.ItemLike;

public class BuddhaHandLeavesBlock extends  AgrumeLeavesBlock{

    public BuddhaHandLeavesBlock(Properties properties) {
        super(properties);
    }

    public ItemLike getAgrumeProperty() {
        return ModItems.BUDDHA_HAND;
    }

    public AgrumesVariant getVariant(){
        return AgrumesVariant.CAVIAR_LEMON;
    }
}
