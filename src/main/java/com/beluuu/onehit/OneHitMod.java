package com.beluuu.onehit;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

@Mod("onehitmod")
public class OneHitMod {

    public static boolean ONE_HIT_ENABLED = false;

    public OneHitMod() {
        // NeoForge এর ইভেন্ট বাস ব্যবহার করুন
        NeoForge.EVENT_BUS.register(this);
        // আপনার অন্য ক্লাসগুলোকেও একইভাবে রেজিস্টার করতে হবে
        // NeoForge.EVENT_BUS.register(new KeyHandler());
    }

    @SubscribeEvent
    public void onAttack(LivingIncomingDamageEvent event) {
        if (!ONE_HIT_ENABLED) return;

        // চেক করা হচ্ছে ড্যামেজ প্লেয়ার থেকে আসছে কি না
        if (event.getSource().getEntity() instanceof Player) {
            event.setAmount(99999.0F); // এক আঘাতেই কেল্লাফতে
        }
    }
}
