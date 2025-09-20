package com.kalyptien.wlgyl.block.custom;

import com.kalyptien.wlgyl.entity.KiwiVariant;
import com.kalyptien.wlgyl.item.ModItems;
import net.minecraft.world.level.ItemLike;

public class LimeLeavesBlock extends  AgrumeLeavesBlock{

    public LimeLeavesBlock(Properties properties) {
        super(properties);
    }

    public ItemLike getAgrumeProperty() {
        return ModItems.LIME;
    }

    public KiwiVariant getVariant(){
        return KiwiVariant.LIME;
    }
}
