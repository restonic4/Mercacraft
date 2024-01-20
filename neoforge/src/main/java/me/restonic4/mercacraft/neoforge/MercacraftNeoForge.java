package me.restonic4.mercacraft.neoforge;

import me.restonic4.mercacraft.Mercacraft;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Mercacraft.MOD_ID)
public class MercacraftNeoForge {
	public MercacraftNeoForge(IEventBus modEventBus) {
		Mercacraft.init();
	}
}
