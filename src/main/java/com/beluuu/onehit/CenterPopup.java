package com.beluuu.onehit;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderGuiLayerEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;

@EventBusSubscriber(modid = "onehitmod", value = Dist.CLIENT)
public class CenterPopup {

    @SubscribeEvent
    public void onRenderGui(RenderGuiLayerEvent.Post event) {
        // শুধুমাত্র হটবার লেয়ারের পর টেক্সট রেন্ডার করবে
        if (event.getName().equals(VanillaGuiLayers.HOTBAR)) {
            Minecraft mc = Minecraft.getInstance();
            Font font = mc.font;
            GuiGraphics graphics = event.getGuiGraphics();

            String status = "One-Hit: " + (OneHitMod.ONE_HIT_ENABLED ? "§aON" : "§cOFF");
            
            int x = graphics.guiWidth() / 2 - font.width(status) / 2;
            int y = graphics.guiHeight() / 2 + 20; // স্ক্রিনের মাঝের কিছুটা নিচে

            graphics.drawString(font, status, x, y, 0xFFFFFFFF, true);
        }
    }
}
