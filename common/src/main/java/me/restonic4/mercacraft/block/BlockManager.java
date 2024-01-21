package me.restonic4.mercacraft.block;

import me.restonic4.mercacraft.creative_tab.CreativeTabManager;
import me.restonic4.restapi.block.BlockRegistry;
import me.restonic4.restapi.holder.RestBlock;
import me.restonic4.restapi.util.BiomeConditions;
import me.restonic4.restapi.util.CustomBlockProperties;
import me.restonic4.restapi.worldgen.ore.OreGenerator;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;

import static me.restonic4.mercacraft.Mercacraft.LOGGER;
import static me.restonic4.mercacraft.Mercacraft.MOD_ID;

public class BlockManager {
    public static final CustomBlockProperties URANIUM_BLOCK_PROPERTIES = new CustomBlockProperties().copy(Blocks.STONE).strength(2, 2).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops();
    public static final RestBlock URANIUM_BLOCK = BlockRegistry.CreateBlock(MOD_ID, "uranium_ore", URANIUM_BLOCK_PROPERTIES.build(), CreativeTabManager.TAB);

    public static final CustomBlockProperties JOSH_BLOCK_PROPERTIES = new CustomBlockProperties().copy(Blocks.BEDROCK).strength(-1, 3600000.0f).noLootTable().sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops();
    public static final RestBlock JOSH_BLOCK = BlockRegistry.CreateBlock(MOD_ID, "josh", JOSH_BLOCK_PROPERTIES.build(), CreativeTabManager.TAB);

    public static void register() {
        BlockRegistry.Register(MOD_ID);
        LOGGER.log("Blocks registered");

        OreGenerator.RegisterOreGeneration(
                MOD_ID,
                "uranium_ore",
                new BiomeConditions().isOverworld()
        );
    }
}
