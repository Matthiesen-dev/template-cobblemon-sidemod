package dev.matthiesen.fabric.template_cobblemon_sidemod;

import dev.matthiesen.common.template_cobblemon_sidemod.ExampleCommandRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

public class FabricModExample implements ModInitializer {

    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register(ExampleCommandRegistry::registerCommands);
    }

}
