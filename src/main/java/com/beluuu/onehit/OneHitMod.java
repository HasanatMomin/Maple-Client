package com.beluuu.onehit;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;

/**
 * NeoForge 1.21.11 One-Hit Everything Mod
 * Player একবার আঘাত করলে সব Entity মারা যাবে
 */
@Mod("onehitmod")
public class OneHitMod {

    public static boolean ONE_HIT_ENABLED = false; // Toggle ON/OFF

    public OneHitMod() {
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new KeyHandler());
        MinecraftForge.EVENT_BUS.register(new CenterPopup());
    }

    @SubscribeEvent
    public void onAttack(AttackEntityEvent event) {
        if (ONE_HIT_ENABLED && event.getTarget() instanceof LivingEntity living) {
            PlayerEntity player = event.getPlayer();
            living.hurt(player.damageSources().playerAttack(player), Float.MAX_VALUE);
        }
    }
}