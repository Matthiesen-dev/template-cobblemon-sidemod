package dev.matthiesen.template_cobblemon_sidemod.fabric;

import dev.matthiesen.template_cobblemon_sidemod.common.TemplateCobblemonSidemodCommonClient;
import net.fabricmc.api.ClientModInitializer;

public final class TemplateCobblemonSidemodFabricClient implements ClientModInitializer {
    public static final TemplateCobblemonSidemodCommonClient INSTANCE = TemplateCobblemonSidemodCommonClient.INSTANCE;

    @Override
    public void onInitializeClient() {
        INSTANCE.initialize();
    }
}
