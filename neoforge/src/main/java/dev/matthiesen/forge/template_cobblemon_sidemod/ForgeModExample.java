package dev.matthiesen.forge.template_cobblemon_sidemod;

import dev.matthiesen.common.template_cobblemon_sidemod.Constants;
import dev.matthiesen.common.template_cobblemon_sidemod.ExampleCommandRegistry;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

@Mod(Constants.MOD_ID)
public class ForgeModExample {

    public ForgeModExample() {
        NeoForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onCommandRegistration(RegisterCommandsEvent event) {
        ExampleCommandRegistry.registerCommands(event.getDispatcher(), event.getBuildContext(), event.getCommandSelection());
    }
}
