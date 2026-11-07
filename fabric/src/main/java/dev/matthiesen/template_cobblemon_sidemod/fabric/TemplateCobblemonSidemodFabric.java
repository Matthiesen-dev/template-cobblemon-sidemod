package dev.matthiesen.template_cobblemon_sidemod.fabric;

import dev.matthiesen.template_cobblemon_sidemod.common.TemplateCobblemonSidemodCommon;
import net.fabricmc.api.ModInitializer;

public final class TemplateCobblemonSidemodFabric implements ModInitializer {
    public static final TemplateCobblemonSidemodCommon INSTANCE = TemplateCobblemonSidemodCommon.INSTANCE;

    @Override
    public void onInitialize() {
        INSTANCE.createInfoLog("Loading for Fabric Mod Loader");
        INSTANCE.initialize();
    }
}
