package dev.matthiesen.common.template_cobblemon_sidemod.registry;

import dev.matthiesen.common.template_cobblemon_sidemod.ExampleModCommon;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class ItemRegistry {
    public static void init() {}

    private static <T extends Item> Supplier<T> register(String id, Supplier<T> item) {
        return ExampleModCommon.COMMON_PLATFORM.registerItem(id, item);
    }
}
