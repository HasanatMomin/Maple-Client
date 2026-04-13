package com.beluuu.onehit;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

/**
 * স্ক্রিনের মাঝখানে দেখাবে "One-Hit: ON" বা "OFF"
 * যা player আবার I চাপা পর্যন্ত থাকবে
 */
public class CenterPopup {

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Text event) {
        Minecraft mc = Minecraft.getInstance();
        Font font = mc.font;
        int screenWidth = mc.getWindow().getScaledWidth();
        int screenHeight = mc.getWindow().getScaledHeight();

        if (OneHitMod.ONE_HIT_ENABLED) {
            String status = "One-Hit: ON";
            int textWidth = font.getWidth(status);
            font.draw(event.getMatrixStack(), status, (screenWidth - textWidth) / 2, screenHeight / 2, 0xFFFF0000);
        } else {
            String status = "One-Hit: OFF";
            int textWidth = font.getWidth(status);
            font.draw(event.getMatrixStack(), status, (screenWidth - textWidth) / 2, screenHeight / 2, 0xFFAAAAAA);
        }
    }
}