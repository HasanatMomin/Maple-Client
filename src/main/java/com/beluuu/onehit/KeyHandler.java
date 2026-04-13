package com.beluuu.onehit;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import org.lwjgl.glfw.GLFW;

@EventBusSubscriber(modid = "onehitmod", value = Dist.CLIENT)
public class KeyHandler {
    
    // 'O' কি টি সেট করা হলো (আপনি চাইলে পরিবর্তন করতে পারেন)
    public static final KeyMapping TOGGLE_KEY = new KeyMapping(
            "key.onehitmod.toggle",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_O,
            "category.onehitmod"
    );

    @SubscribeEvent
    public static void onKeyRegister(RegisterKeyMappingsEvent event) {
        event.register(TOGGLE_KEY);
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.Key event) {
        if (TOGGLE_KEY.consumeClick()) {
            OneHitMod.ONE_HIT_ENABLED = !OneHitMod.ONE_HIT_ENABLED;
        }
    }
}
