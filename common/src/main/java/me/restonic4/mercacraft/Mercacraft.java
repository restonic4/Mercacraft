package me.restonic4.mercacraft;

import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.BlockEvent;
import dev.architectury.event.events.common.InteractionEvent;
import me.restonic4.mercacraft.block.BlockManager;
import me.restonic4.mercacraft.creative_tab.CreativeTabManager;
import me.restonic4.mercacraft.item.ItemManager;
import me.restonic4.mercacraft.sound.SoundManager;
import me.restonic4.restapi.block.BlockRegistry;
import me.restonic4.restapi.creative_tab.CreativeTabRegistry;
import me.restonic4.restapi.holder.Generic.RestLogger;
import me.restonic4.restapi.item.ItemRegistry;
import me.restonic4.restapi.sound.SoundRegistry;
import me.restonic4.restapi.util.Generic.MathHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class Mercacraft
{
	public static final String MOD_ID = "mercacraft";
	public static final RestLogger LOGGER = new RestLogger(MOD_ID);

	public static void init() {
		ItemRegistry.CreateRegistry(MOD_ID);
		CreativeTabRegistry.CreateRegistry(MOD_ID);
		BlockRegistry.CreateRegistry(MOD_ID);
		SoundRegistry.CreateRegistry(MOD_ID);

		ItemManager.register();
		CreativeTabManager.register();
		BlockManager.register();
		SoundManager.register();

		InteractionEvent.RIGHT_CLICK_BLOCK.register(
				(player, hand, pos, face) -> {
					Block block = player.level().getBlockState(pos).getBlock();

					if (block ==  BlockManager.JOSH_BLOCK.get().get()) {
						player.level().explode(null, pos.getX(), pos.getY(), pos.getZ(), 1, Level.ExplosionInteraction.TNT);

						for (int i = 0; i < 10; i++) {
							FallingBlockEntity entity = new FallingBlockEntity(player.level(), pos.getX(), pos.getY() + 1, pos.getZ(), block.defaultBlockState());
							entity.push(MathHelper.getRandomFloat(-5,5) / 5, MathHelper.getRandomFloat(5,10) / 5, MathHelper.getRandomFloat(-5,5) / 5);

							player.level().addFreshEntity(entity);
						}

						player.level().playSound(null, pos, SoundManager.josh.get().get(), SoundSource.VOICE, 1, 1);
					}

					return EventResult.pass();
				}
		);

		BlockEvent.FALLING_LAND.register(
				(level, pos, fallState, landOn, entity) -> {
					entity.level().playSound(null, pos, SoundManager.josh.get().get(), SoundSource.VOICE, 1, 1);
				}
		);
	}
}
