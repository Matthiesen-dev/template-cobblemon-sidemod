package dev.matthiesen.common.template_cobblemon_sidemod;

public class ExampleModCommon {

    public static void initialize() {
        Constants.createInfoLog("Initialized");
    }

    public static void onStartup() {
        Constants.createInfoLog("Server starting, Setting up");
    }

    public static void onShutdown() {
        Constants.createInfoLog("Server stopping, shutting down");
    }
}
