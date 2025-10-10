package com.aokitw513.celestemod.server;

import com.aokitw513.celestemod.CelesteMod;
import com.aokitw513.celestemod.Dash.DashCounter;
import com.aokitw513.celestemod.Dash.DashCounterProvider;
import com.aokitw513.celestemod.client.ModKeyBinds;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ServerEvent {
    private static DashCounter dashCounter = new DashCounter();
    private static final double distance = 20; // 移動距離

    @Mod.EventBusSubscriber(modid = CelesteMod.MOD_ID, value = Dist.DEDICATED_SERVER)
    public static class ServerForgeEvents
    {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event)
        {
            Player player = Minecraft.getInstance().player;
            if (player == null) {
                return;
            }

            //Press Dash
            if(ModKeyBinds.dashKey.consumeClick())
            {
                player.getCapability(DashCounterProvider.playerDashCount).ifPresent(dash -> {
                    if (dash.getDashCount() > 0) {
                        dash.consumeDash(); // 減 1

                        Vec3 forward = player.getLookAngle().scale(distance);
                        player.move(MoverType.SELF, forward);

                        player.sendSystemMessage(Component.literal(
                                "OMG u Dashed :O Dash Left: " + dash.getDashCount()
                        ));
                    } else {
                        player.sendSystemMessage(Component.literal("No Dash left."));
                    }
                });
            }

            //Press Dash Reset
            if(ModKeyBinds.dashResetKey.consumeClick())
            {
                player.getCapability(DashCounterProvider.playerDashCount).ifPresent(dash ->{
                    dash.resetDash();
                    player.sendSystemMessage(Component.literal("Reset Dash Count."));
                });
            }
        }
    }

    @Mod.EventBusSubscriber(modid = CelesteMod.MOD_ID, value = Dist.DEDICATED_SERVER, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ServerModBusEvents
    {
        //Register完後會在設定裡面出現可以設定的按鍵
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event)
        {
            event.register(ModKeyBinds.dashKey);
            event.register(ModKeyBinds.dashResetKey);
        }
    }
}
