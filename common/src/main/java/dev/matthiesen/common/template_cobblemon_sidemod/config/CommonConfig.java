package dev.matthiesen.common.template_cobblemon_sidemod.config;

import com.google.gson.annotations.SerializedName;
import dev.matthiesen.common.template_cobblemon_sidemod.Constants;

public class CommonConfig extends ConfigBase {
    @SerializedName("permissionlevels")
    public PermissionLevels permissionLevels = new PermissionLevels();

    public static class PermissionLevels {
        @SerializedName("command.example")
        public int COMMAND_EXAMPLE_PERMISSION_LEVEL =
                Constants.PERMISSION_LEVELS.CHEAT_COMMANDS_AND_COMMAND_BLOCKS.getLevel();

        @SerializedName("command.example-cool")
        public int COMMAND_EXAMPLE_COOL_PERMISSION_LEVEL =
                Constants.PERMISSION_LEVELS.CHEAT_COMMANDS_AND_COMMAND_BLOCKS.getLevel();
    }
}
