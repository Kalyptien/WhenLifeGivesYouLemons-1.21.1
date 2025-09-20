package com.kalyptien.wlgyl.block.custom;

import com.kalyptien.wlgyl.entity.KiwiVariant;
import com.kalyptien.wlgyl.item.ModItems;
import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.ItemLike;

public class LemonLeavesBlock extends  AgrumeLeavesBlock{

    public LemonLeavesBlock(Properties properties) {
        super(properties);
    }

    public ItemLike getAgrumeProperty() {
        return ModItems.LEMON;
    }

    public KiwiVariant getVariant(){
        return KiwiVariant.LEMON;
    }
}
