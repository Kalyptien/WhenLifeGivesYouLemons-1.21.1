package com.kalyptien.wlgyl.block.custom;

import com.kalyptien.wlgyl.util.AgrumesVariant;
import com.kalyptien.wlgyl.item.ModItems;
import net.minecraft.world.level.ItemLike;

public class LimeLeavesBlock extends  AgrumeLeavesBlock{

    public LimeLeavesBlock(Properties properties) {
        super(properties);
    }

    public ItemLike getAgrumeProperty() {
        return ModItems.LIME;
    }

    public AgrumesVariant getVariant(){
        return AgrumesVariant.LIME;
    }
}
