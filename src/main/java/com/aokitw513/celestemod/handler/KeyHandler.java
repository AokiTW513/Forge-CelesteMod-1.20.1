package com.aokitw513.celestemod.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class KeyHandler
{
    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event)
    {
        Minecraft mc = Minecraft.getInstance();

        if (mc.player == null) return;

        if (mc.options.keyJump.isDown())
        {
            mc.player.sendSystemMessage(Component.literal("Omg! Bro just Jump!"));
        }
    }
}