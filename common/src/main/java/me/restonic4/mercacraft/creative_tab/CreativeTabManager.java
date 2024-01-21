package me.restonic4.mercacraft.creative_tab;

import me.restonic4.restapi.creative_tab.CreativeTabRegistry;
import me.restonic4.restapi.holder.RestCreativeTab;

import static me.restonic4.mercacraft.Mercacraft.MOD_ID;
import static me.restonic4.mercacraft.Mercacraft.LOGGER;

public class CreativeTabManager {
    public static RestCreativeTab TAB = CreativeTabRegistry.CreateCreativeTab(MOD_ID, "mercacraft_tab", "uranium");

    public static void register() {
        CreativeTabRegistry.Register(MOD_ID);
        LOGGER.log("Creative tabs registered");
    }
}
