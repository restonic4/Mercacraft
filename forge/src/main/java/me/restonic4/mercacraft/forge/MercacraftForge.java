package me.restonic4.mercacraft.forge;

import dev.architectury.platform.forge.EventBuses;
import me.restonic4.mercacraft.Mercacraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Mercacraft.MOD_ID)
public class MercacraftForge {
    public MercacraftForge() {
		// Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(Mercacraft.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        Mercacraft.init();
    }
}