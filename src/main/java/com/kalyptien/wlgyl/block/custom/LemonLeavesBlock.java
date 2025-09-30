package com.kalyptien.wlgyl.block.custom;

import com.kalyptien.wlgyl.util.AgrumesVariant;
import com.kalyptien.wlgyl.item.ModItems;
import net.minecraft.world.level.ItemLike;

public class LemonLeavesBlock extends  AgrumeLeavesBlock{

    public LemonLeavesBlock(Properties properties) {
        super(properties);
    }

    public ItemLike getAgrumeProperty() {
        return ModItems.LEMON;
    }

    public AgrumesVariant getVariant(){
        return AgrumesVariant.LEMON;
    }
}
