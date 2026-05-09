package dev.matthiesen.common.template_cobblemon_sidemod.registry;

import dev.matthiesen.common.template_cobblemon_sidemod.ExampleModCommon;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class BlockEntityRegistry {
    public static void init() {}

//    public static final Supplier<BlockEntityType<PokestopEntity>> POKESTOP_BE =
//            register("pokestop", () -> buildType(PokestopEntity::new, BlockRegistry.POKESTOPS));

    private static Block[] resolveBlocks(Map<String, ? extends Supplier<? extends Block>> registeredBlocks) {
        return registeredBlocks.values()
                .stream()
                .map(Supplier::get)
                .toArray(Block[]::new);
    }

    private static <T extends BlockEntity> BlockEntityType<T> buildType(
            BiFunction<net.minecraft.core.BlockPos, net.minecraft.world.level.block.state.BlockState, T> entityFactory,
            Map<String, ? extends Supplier<? extends Block>> registeredBlocks
    ) {
        return BlockEntityType.Builder.of(entityFactory::apply, resolveBlocks(registeredBlocks)).build(null);
    }

    @SuppressWarnings("SameParameterValue")
    private static <T extends BlockEntity> Supplier<BlockEntityType<T>> register(String id, Supplier<BlockEntityType<T>> blockEntity) {
        return ExampleModCommon.COMMON_PLATFORM.registerBlockEntity(id, blockEntity);
    }
}
