package dev.matthiesen.template_cobblemon_sidemod.common;

import dev.faststats.Token;
import dev.matthiesen.matthiesen_core.common.AbstractCommonMod;
import org.jetbrains.annotations.NotNull;

public final class TemplateCobblemonSidemodCommon extends AbstractCommonMod {
    public static final String MOD_ID = "template_cobblemon_sidemod";
    public static final String MOD_NAME = "Template Side-Mod";
    public static @Token final String METRICS_TOKEN = "";
    public static final TemplateCobblemonSidemodCommon INSTANCE = new TemplateCobblemonSidemodCommon();

    public TemplateCobblemonSidemodCommon() {
        super(MOD_ID, MOD_NAME);
    }

    @Override
    public @Token @NotNull String getMetricsToken() {
        return METRICS_TOKEN;
    }

    public void initialize() {
        super.initialize();

        createInfoLog("Initialized");
    }
}
