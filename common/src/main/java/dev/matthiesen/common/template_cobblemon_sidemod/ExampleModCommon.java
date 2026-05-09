package dev.matthiesen.common.template_cobblemon_sidemod;

import com.mojang.brigadier.CommandDispatcher;
import dev.matthiesen.common.template_cobblemon_sidemod.registry.CommandRegistry;
import dev.matthiesen.common.template_cobblemon_sidemod.platform.ConfigManager;
import dev.matthiesen.common.template_cobblemon_sidemod.config.CommonConfig;
import dev.matthiesen.common.template_cobblemon_sidemod.permissions.ModPermissions;
import dev.matthiesen.common.template_cobblemon_sidemod.platform.CommonPlatform;
import dev.matthiesen.common.template_cobblemon_sidemod.registry.*;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

import java.util.ServiceLoader;

public class ExampleModCommon {
    public static final ConfigManager<CommonConfig> COMMON_CONFIG_MANAGER =
            new ConfigManager<>(CommonConfig.class, "config");
    public static final CommonPlatform COMMON_PLATFORM =
            ServiceLoader.load(CommonPlatform.class).findFirst().orElseThrow();
    public static ModPermissions permissions;
    public static CommonConfig config;

    public static void initialize() {
        Constants.createInfoLog("Initialized");
        config = COMMON_CONFIG_MANAGER.loadConfig();
        permissions = new ModPermissions();
        SoundRegistry.init();
        StatsRegistry.init();
        BlockRegistry.init();
        BlockEntityRegistry.init();
        ItemRegistry.init();
        CriterionTriggerRegistry.init();
    }

    public static void onStartup() {
        Constants.createInfoLog("Server starting, Setting up");
    }

    public static void onShutdown() {
        Constants.createInfoLog("Server stopping, shutting down");
        COMMON_CONFIG_MANAGER.saveConfig();
    }

    public static void registerCommands(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext registry, Commands.CommandSelection context) {
        Constants.createInfoLog("Registering Commands");
        CommandRegistry.init(dispatcher, registry, context);
    }
}
