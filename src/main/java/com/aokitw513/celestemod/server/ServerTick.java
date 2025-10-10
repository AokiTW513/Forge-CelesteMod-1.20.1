package com.aokitw513.celestemod.server;

import com.aokitw513.celestemod.CelesteMod;
import com.aokitw513.celestemod.Dash.DashCounterProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CelesteMod.MOD_ID, value = Dist.DEDICATED_SERVER)
public class ServerTick {
    private static boolean wasInAir = false;

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event)
    {
        if(event.phase != TickEvent.Phase.END)
        {
            return;
        }

        Player player = Minecraft.getInstance().player;
        if (player == null)
        {
            return;
        }

        if (player.onGround())
        {
            if (wasInAir)
            {
                player.getCapability(DashCounterProvider.playerDashCount).ifPresent(dash ->{
                        dash.resetDash();
                        player.sendSystemMessage(Component.literal("Reset Dash Count."));
                });
            }
            wasInAir = false;
        }
        else
        {
            wasInAir = true;
        }
    }
}
