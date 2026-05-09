package dev.matthiesen.fabric.template_cobblemon_sidemod;

import dev.matthiesen.common.template_cobblemon_sidemod.ExampleModCommon;
import dev.matthiesen.common.template_cobblemon_sidemod.Constants;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;

public class ExampleModFabric implements ModInitializer {
    public static MinecraftServer MC_SERVER;

    @Override
    public void onInitialize() {
        Constants.createInfoLog("Loading for Fabric Mod Loader");
        ExampleModCommon.initialize();
        CommandRegistrationCallback.EVENT.register(ExampleModCommon::registerCommands);
        ServerLifecycleEvents.SERVER_STARTING.register(server -> {
            MC_SERVER = server;
            ExampleModCommon.onStartup();
        });
        ServerLifecycleEvents.SERVER_STOPPING.register(server -> {
            MC_SERVER = null;
            ExampleModCommon.onShutdown();
        });
    }
}
