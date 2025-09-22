package com.kalyptien.wlgyl.block.custom;

import com.kalyptien.wlgyl.entity.KiwiVariant;
import com.kalyptien.wlgyl.item.ModItems;
import net.minecraft.world.level.ItemLike;

public class BloodOrangeLeavesBlock extends  AgrumeLeavesBlock{

    public BloodOrangeLeavesBlock(Properties properties) {
        super(properties);
    }

    public ItemLike getAgrumeProperty() {
        return ModItems.BLOOD_ORANGE;
    }

    public KiwiVariant getVariant(){
        return KiwiVariant.BLOOD_ORANGE;
    }
}
