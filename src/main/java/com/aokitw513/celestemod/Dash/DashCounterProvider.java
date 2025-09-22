package com.aokitw513.celestemod.Dash;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DashCounterProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static final ResourceLocation ID = new ResourceLocation("celestemod", "dash");

    public static Capability<DashCounter> playerDashCount = CapabilityManager.get(new CapabilityToken<DashCounter>() { });

    private DashCounter dashCounter = null;
    private final LazyOptional<DashCounter> optional = LazyOptional.of(this::createDashCounter);

    private DashCounter createDashCounter(){
        if(this.dashCounter == null)
        {
            this.dashCounter = new DashCounter();
        }

        return this.dashCounter;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == playerDashCount)
        {
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createDashCounter().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createDashCounter().loadNBTData(nbt);
    }
}
