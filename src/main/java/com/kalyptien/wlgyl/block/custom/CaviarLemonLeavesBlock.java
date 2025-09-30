package com.kalyptien.wlgyl.block.custom;

import com.kalyptien.wlgyl.util.AgrumesVariant;
import com.kalyptien.wlgyl.item.ModItems;
import net.minecraft.world.level.ItemLike;

public class CaviarLemonLeavesBlock extends  AgrumeLeavesBlock{

    public CaviarLemonLeavesBlock(Properties properties) {
        super(properties);
    }

    public ItemLike getAgrumeProperty() {
        return ModItems.CAVIAR_LEMON;
    }

    public AgrumesVariant getVariant(){
        return AgrumesVariant.CAVIAR_LEMON;
    }
}
