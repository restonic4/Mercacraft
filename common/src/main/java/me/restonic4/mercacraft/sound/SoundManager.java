package me.restonic4.mercacraft.sound;

import me.restonic4.restapi.holder.RestSound;
import me.restonic4.restapi.sound.SoundRegistry;

import static me.restonic4.mercacraft.Mercacraft.MOD_ID;

public class SoundManager {
    public static final RestSound josh = SoundRegistry.RegisterSound(MOD_ID, "josh");

    public static void register() {
        SoundRegistry.Register(MOD_ID);
    }
}
