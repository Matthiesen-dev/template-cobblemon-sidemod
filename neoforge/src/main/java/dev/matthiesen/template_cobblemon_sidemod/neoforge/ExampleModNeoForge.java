package dev.matthiesen.template_cobblemon_sidemod.neoforge;

import dev.matthiesen.template_cobblemon_sidemod.common.ExampleModCommon;
import net.neoforged.fml.common.Mod;

@Mod(ExampleModCommon.MOD_ID)
public class ExampleModNeoForge {
    public ExampleModNeoForge() {
        var instance = ExampleModCommon.INSTANCE;
        instance.createInfoLog("Loading for NeoForge Mod Loader");
        instance.initialize();
    }
}
