package dev.matthiesen.template_cobblemon_sidemod.neoforge;

import dev.matthiesen.template_cobblemon_sidemod.common.ExampleModCommon;
import dev.matthiesen.template_cobblemon_sidemod.common.ExampleModCommonClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(value = ExampleModCommon.MOD_ID, dist = Dist.CLIENT)
public class ExampleModNeoForgeClient {
    public ExampleModNeoForgeClient(IEventBus modBus) {
        modBus.addListener(this::clientSetup);
    }

    public void clientSetup(FMLClientSetupEvent event) {
        ExampleModCommonClient.initialize();
    }
}
