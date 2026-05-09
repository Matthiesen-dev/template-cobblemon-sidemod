package dev.matthiesen.common.template_cobblemon_sidemod.registry;

import dev.matthiesen.common.template_cobblemon_sidemod.ExampleModCommon;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public class SoundRegistry {
    public static void init() {}

    @SuppressWarnings("SameParameterValue")
    private static <T extends SoundEvent> Supplier<T> register(String id, Supplier<T> sound) {
        return ExampleModCommon.COMMON_PLATFORM.registerSound(id, sound);
    }
}
