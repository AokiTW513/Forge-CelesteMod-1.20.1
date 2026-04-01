package com.aokitw513.celestemod.client;

import com.aokitw513.celestemod.CelesteMod;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public final class ModKeyBinds
{
    public static final String KEY_CATEGORY = "key.category." + CelesteMod.MOD_ID;
    public static final String KEY_DASH = "key." + CelesteMod.MOD_ID + ".dash";
    public static final String KEY_DASHRESET = "key." + CelesteMod.MOD_ID + ".dashreset";

    public static KeyMapping dashKey = new KeyMapping(
            KEY_DASH,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_V,
            KEY_CATEGORY
    );

    public static KeyMapping dashResetKey = new KeyMapping(
            KEY_DASHRESET,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_R,
            KEY_CATEGORY
    );

    public static KeyMapping testKey = new KeyMapping(
            KEY_DASHRESET,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_G,
            KEY_CATEGORY
    );

    public static KeyMapping climbKey = new KeyMapping(
            KEY_DASHRESET,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_B,
            KEY_CATEGORY
    );
}
