package com.aokitw513.celestemod.client;

import com.aokitw513.celestemod.CelesteMod;
import com.aokitw513.celestemod.Dash.DashCounterProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CelesteMod.MOD_ID, value = Dist.CLIENT)
public class ClientTick
{
    private static boolean wasInAir = false;

    private static boolean facingWall = false;

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event)
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
                player.getCapability(DashCounterProvider.playerDashCount).ifPresent(dash ->
                {
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