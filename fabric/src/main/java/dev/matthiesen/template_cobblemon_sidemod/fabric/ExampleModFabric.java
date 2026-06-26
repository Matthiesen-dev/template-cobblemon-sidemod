package dev.matthiesen.template_cobblemon_sidemod.fabric;

import dev.matthiesen.template_cobblemon_sidemod.common.ExampleModCommon;
import net.fabricmc.api.ModInitializer;

public class ExampleModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        var instance = ExampleModCommon.INSTANCE;
        instance.createInfoLog("Loading for Fabric Mod Loader");
        instance.initialize();
    }
}
