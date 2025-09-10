package com.kalyptien.wlgyl.screen.custom;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class BrewingBarrelScreen extends AbstractContainerScreen<BrewingBarrelMenu> {
    private static final ResourceLocation GUI_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID,"textures/gui/brewing_barrel_gui.png");
    private static final ResourceLocation BUBBLES_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID,"textures/gui/bubbles.png");

    private ResourceLocation LIMONADES_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID,"textures/gui/water.png");

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
        renderProgressArrow(guiGraphics, x, y);
        renderLimonade(guiGraphics, x, y);
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            guiGraphics.blit(BUBBLES_TEXTURE,x + 119, y + 32, 0, 0, 12, menu.getScaledArrowProgress(), 12, 29);
        }
    }

    private void renderLimonade(GuiGraphics guiGraphics, int x, int y) {
        guiGraphics.blit(LIMONADES_TEXTURE,x + 62, y + 19, 0, 0, 52, menu.getLimonadeProgress(), 52, 52);
    }

    private void updateLimonade(){
        this.LIMONADES_TEXTURE = ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID,"textures/gui/lemonades/" + menu.getCurrentLimonade()  + ".png");
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }
}
