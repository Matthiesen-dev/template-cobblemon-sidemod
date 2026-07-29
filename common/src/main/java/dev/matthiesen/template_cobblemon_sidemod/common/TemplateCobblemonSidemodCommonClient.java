package dev.matthiesen.template_cobblemon_sidemod.common;

import dev.matthiesen.matthiesen_core.common.AbstractCommonClientMod;

public final class TemplateCobblemonSidemodCommonClient extends AbstractCommonClientMod {
    public static final TemplateCobblemonSidemodCommonClient INSTANCE = new TemplateCobblemonSidemodCommonClient();

    public TemplateCobblemonSidemodCommonClient() {
        super(TemplateCobblemonSidemodCommon.INSTANCE);
    }

    public void initialize() {
        createInfoLog("Loading client-side for " + TemplateCobblemonSidemodCommon.MOD_NAME);
    }
}
