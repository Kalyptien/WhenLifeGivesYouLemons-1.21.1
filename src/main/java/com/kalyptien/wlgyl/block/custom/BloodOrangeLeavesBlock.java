package com.kalyptien.wlgyl.block.custom;

import com.kalyptien.wlgyl.util.AgrumesVariant;
import com.kalyptien.wlgyl.item.ModItems;
import net.minecraft.world.level.ItemLike;

public class BloodOrangeLeavesBlock extends  AgrumeLeavesBlock{

    public BloodOrangeLeavesBlock(Properties properties) {
        super(properties);
    }

    public ItemLike getAgrumeProperty() {
        return ModItems.BLOOD_ORANGE;
    }

    public AgrumesVariant getVariant(){
        return AgrumesVariant.BLOOD_ORANGE;
    }
}
