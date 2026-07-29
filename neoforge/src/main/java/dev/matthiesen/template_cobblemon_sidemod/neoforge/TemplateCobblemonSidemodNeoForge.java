package dev.matthiesen.template_cobblemon_sidemod.neoforge;

import dev.matthiesen.template_cobblemon_sidemod.common.TemplateCobblemonSidemodCommon;
import net.neoforged.fml.common.Mod;

@Mod(TemplateCobblemonSidemodCommon.MOD_ID)
public class TemplateCobblemonSidemodNeoForge {
    public static final TemplateCobblemonSidemodCommon INSTANCE = TemplateCobblemonSidemodCommon.INSTANCE;

    public TemplateCobblemonSidemodNeoForge() {
        INSTANCE.createInfoLog("Loading for NeoForge Mod Loader");
        INSTANCE.initialize();
    }
}
