package dev.matthiesen.template_cobblemon_sidemod.fabric;

import dev.matthiesen.template_cobblemon_sidemod.common.ExampleModCommonClient;
import net.fabricmc.api.ClientModInitializer;

public class ExampleModFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ExampleModCommonClient.initialize();
    }
}
