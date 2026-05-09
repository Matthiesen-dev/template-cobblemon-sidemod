package dev.matthiesen.common.template_cobblemon_sidemod.registry;

import dev.matthiesen.common.template_cobblemon_sidemod.ExampleModCommon;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class BlockRegistry {
    public static void init() {}

    // Registration
    private static <T extends Block> Supplier<T> register(String id, Supplier<T> block) {
        return ExampleModCommon.COMMON_PLATFORM.registerBlock(id, block);
    }
}
