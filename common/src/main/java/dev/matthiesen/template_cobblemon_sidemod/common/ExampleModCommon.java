package dev.matthiesen.template_cobblemon_sidemod.common;

import dev.matthiesen.common.matthiesen_lib_api.MatthiesenLibApi;
import dev.matthiesen.common.matthiesen_lib_api.abstracts.AbstractCommonMod;
import dev.matthiesen.libs.faststats.Token;
import org.jetbrains.annotations.Nullable;

public class ExampleModCommon extends AbstractCommonMod {
    public static final String MOD_ID = "template_cobblemon_sidemod";
    public static final String MOD_NAME = "Template Side-Mod";
    public static @Token final String METRICS_TOKEN = "";

    public static final ExampleModCommon INSTANCE = new ExampleModCommon();

    public ExampleModCommon() {
        super(MOD_ID, MOD_NAME);
    }

    @Override
    public @Nullable @Token String getMetricsToken() {
        return METRICS_TOKEN;
    }

    @Override
    public Runnable reload() {
        return () -> {
            // TODO
            createInfoLog("Reloaded");
        };
    }

    public void initialize() {
        super.initialize();

       if (MatthiesenLibApi.isModLoaded("cobblemon")) {
            createInfoLog("Cobblemon is loaded, Hello there Cobblemon!");
       }

        createInfoLog("Initialized");
    }
}
