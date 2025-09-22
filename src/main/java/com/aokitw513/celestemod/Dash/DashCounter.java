package com.aokitw513.celestemod.Dash;

import net.minecraft.nbt.CompoundTag;

public class DashCounter{
    private int dashCount = 3;

    public int getDashCount() {
        return dashCount;
    }

    public void setDashCount(int count) {
        this.dashCount = count;
    }

    public void consumeDash() {
        if(dashCount > 0) dashCount--;
    }

    public void resetDash() {
        dashCount = 3;
        System.out.println("Reset Dash to" + dashCount + ".");
    }

    public void saveNBTData(CompoundTag nbt){
        nbt.putInt("dashCount", dashCount);
    }

    public void loadNBTData(CompoundTag nbt){
        dashCount = nbt.getInt("dashCount");
    }
}