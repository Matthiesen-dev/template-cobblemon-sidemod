package dev.matthiesen.common.template_cobblemon_sidemod.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import dev.matthiesen.common.template_cobblemon_sidemod.ExampleModCommon;
import dev.matthiesen.common.template_cobblemon_sidemod.interfaces.ICommand;
import dev.matthiesen.common.template_cobblemon_sidemod.permissions.ModPermissions;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class Example implements ICommand {
    public Example() {}

    public void register(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext registry, Commands.CommandSelection context) {
        dispatcher.register(
                Commands.literal("example")
                        .requires(src -> ModPermissions.checkPermission(
                                src,
                                ExampleModCommon.permissions.EXAMPLE_PERMISSION
                        ))
                        .executes(this::normal)
        );
    }

    private int normal(CommandContext<CommandSourceStack> ctx) {
        ServerPlayer player = ctx.getSource().getPlayer();

        if (player != null) {
            player.displayClientMessage(Component.literal("Hey!"), false);

            if (ModPermissions.checkPlayerPermission(player, ExampleModCommon.permissions.EXAMPLE_COOL_PERMISSION)) {
                player.displayClientMessage(Component.literal("Your even cooler!"), false);
            }
        }

        return 1;
    }
}