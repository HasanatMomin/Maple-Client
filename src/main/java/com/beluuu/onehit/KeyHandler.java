package com.beluuu.onehit;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import org.lwjgl.glfw.GLFW;

@EventBusSubscriber(modid = "onehitmod", value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class KeyHandler {

    // NeoForge 1.21.x এর জন্য সঠিক কনস্ট্রাক্টর
    public static final KeyMapping TOGGLE_KEY = new KeyMapping(
            "key.onehitmod.toggle",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_O, // 'O' বাটন দিয়ে অন/অফ হবে
            "key.categories.misc"
    );

    @SubscribeEvent
    public static void onRegisterKeys(RegisterKeyMappingsEvent event) {
        event.register(TOGGLE_KEY);
    }

    // গেম চলাকালীন ইনপুট চেক করার জন্য
    @EventBusSubscriber(modid = "onehitmod", value = Dist.CLIENT, bus = EventBusSubscriber.Bus.GAME)
    public static class InputHandler {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            while (TOGGLE_KEY.consumeClick()) {
                OneHitMod.ONE_HIT_ENABLED = !OneHitMod.ONE_HIT_ENABLED;
            }
        }
    }
}
