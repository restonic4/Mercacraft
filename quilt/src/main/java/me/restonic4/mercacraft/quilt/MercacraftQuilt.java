package me.restonic4.mercacraft.quilt;

import me.restonic4.mercacraft.Mercacraft;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class MercacraftQuilt implements ModInitializer {
    @Override
    public void onInitialize(ModContainer mod) {
        Mercacraft.init();
    }
}