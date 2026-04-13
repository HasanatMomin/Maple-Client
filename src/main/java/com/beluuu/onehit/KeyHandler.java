package com.beluuu.onehit;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import org.lwjgl.glfw.GLFW;

@EventBusSubscriber(modid = "onehitmod", value = Dist.CLIENT)
public class KeyHandler {

    public static final KeyMapping TOGGLE_KEY = new KeyMapping(
            "key.onehit.toggle",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_I,
            KeyMapping.Category.MISC
    );

    @SubscribeEvent
    public static void onRegisterKeys(RegisterKeyMappingsEvent event) {
        event.register(TOGGLE_KEY);
    }

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {
        if (Minecraft.getInstance().player == null) return;

        while (TOGGLE_KEY.consumeClick()) {
            OneHitMod.ONE_HIT_ENABLED = !OneHitMod.ONE_HIT_ENABLED;
        }
    }
}
