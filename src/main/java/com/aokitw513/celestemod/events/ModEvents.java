package com.aokitw513.celestemod.events;

import com.aokitw513.celestemod.CelesteMod;
import com.aokitw513.celestemod.Dash.DashCounterProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CelesteMod.MOD_ID)
public class ModEvents
{
    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event)
    {
        if (event.getObject() instanceof Player)
        {
            event.addCapability(DashCounterProvider.ID, new DashCounterProvider());
        }
    }
}
