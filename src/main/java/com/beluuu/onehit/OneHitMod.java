package com.beluuu.onehit;

import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

@Mod("onehitmod")
public class OneHitMod {

    public static boolean ONE_HIT_ENABLED = false;

    public OneHitMod() {
        // মেইন ইভেন্ট বাস রেজিস্টার
        NeoForge.EVENT_BUS.register(this);
        // কি-বোর্ড এবং স্ক্রিন রেন্ডারার রেজিস্টার
        NeoForge.EVENT_BUS.register(new KeyHandler());
        NeoForge.EVENT_BUS.register(new CenterPopup());
    }

    @SubscribeEvent
    public void onIncomingDamage(LivingIncomingDamageEvent event) {
        if (!ONE_HIT_ENABLED) return;

        // যদি ড্যামেজ দানকারী একজন প্লেয়ার হয়
        if (event.getSource().getEntity() instanceof Player) {
            // এক আঘাতেই মৃত্যুর জন্য বিশাল ড্যামেজ সেট করা
            event.setAmount(99999.0F);
        }
    }
}
