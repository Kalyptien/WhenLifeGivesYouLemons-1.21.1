package com.kalyptien.wlgyl.screen.custom;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import com.kalyptien.wlgyl.util.FruitsVariant;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;

public class BrewingBarrelScreen extends AbstractContainerScreen<BrewingBarrelMenu> {
    private static final ResourceLocation GUI_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID,"textures/gui/brewing_barrel/brewing_barrel_gui.png");
    private static final ResourceLocation PROGRESS_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID,"textures/gui/brewing_barrel/progress_bar.png");
    private static final ResourceLocation BUBBLE_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID,"textures/gui/brewing_barrel/bubble_progress.png");
    private ResourceLocation LIQUID_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID,"textures/gui/brewing_barrel/liquids/water_bucket.png");

    public BrewingBarrelScreen(BrewingBarrelMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(GUI_TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        updateLimonade();
        renderLimonade(guiGraphics, x, y);
        renderProgressArrow(guiGraphics, x, y);
        renderProgressBubble(guiGraphics, x, y);
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            guiGraphics.blit(PROGRESS_TEXTURE,x + 40, y + 41, 0, 0, menu.getScaledArrowProgress(), 4, 17, 4);
        }
    }

    private void renderProgressBubble(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            guiGraphics.blit(BUBBLE_TEXTURE,x + 62, y + 36, 0, 0, menu.getScaledBubbleProgress(), 15, 23, 15);
        }
    }

    private void renderLimonade(GuiGraphics guiGraphics, int x, int y) {
        guiGraphics.blit(LIQUID_TEXTURE,x + 62, y + 17 + (52 - menu.getCraftProgress()), 0, (52 - menu.getCraftProgress()), 52, menu.getCraftProgress(), 52, 52);
    }

    private void updateLimonade(){
        this.LIQUID_TEXTURE = ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID,"textures/gui/brewing_barrel/liquids/" + menu.getCurrentLemonadeTypeName()  + ".png");
    }

    @Override
    protected void renderTooltip(GuiGraphics guiGraphics, int x, int y) {
        super.renderTooltip(guiGraphics,x,y);

        int xBase = (width - imageWidth) / 2;
        int yBase = (height - imageHeight) / 2;

        if (this.menu.getCarried().isEmpty() && ((62 + xBase) < x && x < (114 + xBase)) && ((17 + yBase) < y && y < (69 + yBase)) ) {
            ItemStack itemstack = new ItemStack(FruitsVariant.getLemonadeFromId(menu.getCurrentVariantId(), menu.getCurrentEffectId()) , 1);
            guiGraphics.renderTooltip(this.font, this.getTooltipFromContainerItem(itemstack), itemstack.getTooltipImage(), itemstack, x, y);
        }
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }
}
