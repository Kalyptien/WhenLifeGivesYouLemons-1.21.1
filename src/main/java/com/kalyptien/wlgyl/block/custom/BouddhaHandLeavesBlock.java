package com.kalyptien.wlgyl.block.custom;

import com.kalyptien.wlgyl.item.ModItems;
import net.minecraft.world.level.ItemLike;

public class BouddhaHandLeavesBlock extends  AgrumeLeavesBlock{

    public BouddhaHandLeavesBlock(Properties properties) {
        super(properties);
    }

    public ItemLike getAgrumeProperty() {
        return ModItems.BOUDDHA_HAND;
    }
}
