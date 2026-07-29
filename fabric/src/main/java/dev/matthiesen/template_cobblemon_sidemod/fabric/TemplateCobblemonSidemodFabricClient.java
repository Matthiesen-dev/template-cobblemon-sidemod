package dev.matthiesen.template_cobblemon_sidemod.fabric;

import dev.matthiesen.template_cobblemon_sidemod.common.TemplateCobblemonSidemodCommonClient;
import net.fabricmc.api.ClientModInitializer;

public class TemplateCobblemonSidemodFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        var instance = TemplateCobblemonSidemodCommonClient.INSTANCE;
        instance.initialize();
    }
}
