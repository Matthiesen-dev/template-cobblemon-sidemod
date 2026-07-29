package dev.matthiesen.template_cobblemon_sidemod.fabric;

import dev.matthiesen.template_cobblemon_sidemod.common.TemplateCobblemonSidemodCommon;
import net.fabricmc.api.ModInitializer;

public class TemplateCobblemonSidemodFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        var instance = TemplateCobblemonSidemodCommon.INSTANCE;
        instance.createInfoLog("Loading for Fabric Mod Loader");
        instance.initialize();
    }
}
