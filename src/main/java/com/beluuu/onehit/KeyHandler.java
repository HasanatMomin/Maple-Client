package com.beluuu.onehit;

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

    // ৩টি প্যারামিটার: নাম, কী-কোড, এবং ক্যাটাগরি (String হিসেবে)
    // অনেক সময় String ক্যাটাগরি সরাসরি কাজ করে যদি সঠিক কন্সট্রাক্টর থাকে
    public static final KeyMapping TOGGLE_KEY = new KeyMapping(
            "key.onehit.toggle", 
            GLFW.GLFW_KEY_I, 
            "key.categories.misc"
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
