package com.aokitw513.celestemod.items;

import com.aokitw513.celestemod.CelesteMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CelesteMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CELESTE_TAB = CREATIVE_MODE_TABS.register("celeste_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CelesteTestItem.get()))
                    .title(Component.translatable("creativetab.celeste_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.CelesteTestItem.get());
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
