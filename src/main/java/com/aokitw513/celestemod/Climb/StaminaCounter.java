package com.aokitw513.celestemod.Climb;

public class StaminaCounter {
    public float staminaCount = 100; //體力上限為100

    public void resetStamina()
    {
        staminaCount = 100;
        System.out.println("Reset Stamina.");
    }
}
