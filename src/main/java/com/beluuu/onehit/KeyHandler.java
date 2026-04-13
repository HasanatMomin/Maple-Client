package com.beluuu.onehit;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.glfw.GLFW;

/**
 * Key binding: Press I to toggle One-Hit ON/OFF
 */
public class KeyHandler {

    public static KeyMapping toggleKey = new KeyMapping(
        "key.onehit.toggle",
        KeyConflictContext.IN_GAME,
        KeyModifier.NONE,
        GLFW.GLFW_KEY_I,
        "key.categories.onehit"
    );

    public KeyHandler() {
        ClientRegistry.registerKeyBinding(toggleKey);
    }

    @SubscribeEvent
    public void onKey(InputEvent.KeyInputEvent event) {
        if (toggleKey.consumeClick()) {
            OneHitMod.ONE_HIT_ENABLED = !OneHitMod.ONE_HIT_ENABLED;
        }
    }
}