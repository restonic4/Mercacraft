package me.restonic4.mercacraft.fabric;

import me.restonic4.mercacraft.Mercacraft;
import net.fabricmc.api.ModInitializer;

public class MercacraftFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Mercacraft.init();
    }
}