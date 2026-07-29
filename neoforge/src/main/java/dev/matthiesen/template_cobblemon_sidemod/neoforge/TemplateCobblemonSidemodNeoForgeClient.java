package dev.matthiesen.template_cobblemon_sidemod.neoforge;

import dev.matthiesen.template_cobblemon_sidemod.common.TemplateCobblemonSidemodCommon;
import dev.matthiesen.template_cobblemon_sidemod.common.TemplateCobblemonSidemodCommonClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(value = TemplateCobblemonSidemodCommon.MOD_ID, dist = Dist.CLIENT)
public class TemplateCobblemonSidemodNeoForgeClient {
    public static final TemplateCobblemonSidemodCommonClient INSTANCE = TemplateCobblemonSidemodCommonClient.INSTANCE;

    public TemplateCobblemonSidemodNeoForgeClient(IEventBus modBus) {
        modBus.addListener(this::clientSetup);
    }

    public void clientSetup(FMLClientSetupEvent event) {
        INSTANCE.initialize();
    }
}
