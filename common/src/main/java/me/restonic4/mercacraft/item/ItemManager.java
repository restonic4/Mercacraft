package me.restonic4.mercacraft.item;

import dev.architectury.event.CompoundEventResult;
import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.InteractionEvent;
import dev.architectury.event.events.common.LifecycleEvent;
import me.restonic4.mercacraft.creative_tab.CreativeTabManager;
import me.restonic4.restapi.holder.RestItem;
import me.restonic4.restapi.item.ItemRegistry;
import me.restonic4.restapi.util.CustomItemProperties;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static me.restonic4.mercacraft.Mercacraft.MOD_ID;
import static me.restonic4.mercacraft.Mercacraft.LOGGER;

public class ItemManager {
    public static RestItem uranium = ItemRegistry.CreateCustom(
            MOD_ID,
            "uranium",
            () -> new Item(
                    new CustomItemProperties()
                            .tab(CreativeTabManager.TAB)
                            .food(2,1, ItemRegistry.CreateExistingEffect(MobEffects.WITHER, (20*5),10), 1)
                            .build()
            )
    );

    public static RestItem pizza = ItemRegistry.CreateCustom(
            MOD_ID,
            "pizza",
            () -> new Item(
                    new CustomItemProperties()
                            .tab(CreativeTabManager.TAB)
                            .build()
            )
    );

    public static RestItem lentejas = ItemRegistry.CreateCustom(
            MOD_ID,
            "lentejas",
            () -> new Item(
                    new CustomItemProperties()
                            .tab(CreativeTabManager.TAB)
                            .food(20,4, ItemRegistry.CreateExistingEffect(MobEffects.REGENERATION, (20*60*5),10), 1)
                            .build()
            )
    );

    public static RestItem water_fresquita = ItemRegistry.CreateCustom(
            MOD_ID,
            "water_fresquita",
            () -> new Item(
                    new CustomItemProperties()
                            .tab(CreativeTabManager.TAB)
                            .food(20,4, ItemRegistry.CreateExistingEffect(MobEffects.LEVITATION, (20*5),10), 1)
                            .build()
            )
    );

    public static RestItem paella = ItemRegistry.CreateCustom(
            MOD_ID,
            "paella",
            () -> new Item(
                    new CustomItemProperties()
                            .tab(CreativeTabManager.TAB)
                            .food(20,4, null, 0)
                            .build()
            )
    );

    public static void register() {
        ItemRegistry.Register(MOD_ID);
        LOGGER.log("Items registered");

        InteractionEvent.RIGHT_CLICK_ITEM.register(
                (player, hand) -> {
                    ItemStack itemStack = player.getItemInHand(hand);

                    if (itemStack.getItem() == pizza.get().get()) {
                        Level level = player.level();

                        level.explode(null, player.getX(), player.getY(), player.getZ(), 50, Level.ExplosionInteraction.TNT);
                    }

                    return CompoundEventResult.pass();
                }
        );
    }
}
