package com.kalyptien.wlgyl.block.custom;

import com.kalyptien.wlgyl.item.ModItems;
import net.minecraft.world.level.ItemLike;

public class OrangeLeavesBlock extends  AgrumeLeavesBlock{

    public OrangeLeavesBlock(Properties properties) {
        super(properties);
    }

    public ItemLike getAgrumeProperty() {
        return ModItems.ORANGE;
    }
}
