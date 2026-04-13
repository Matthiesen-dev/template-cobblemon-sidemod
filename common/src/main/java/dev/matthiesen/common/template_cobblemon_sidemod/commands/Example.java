package dev.matthiesen.common.template_cobblemon_sidemod.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import dev.matthiesen.common.template_cobblemon_sidemod.CommonModExample;
import dev.matthiesen.common.template_cobblemon_sidemod.interfaces.ICommand;
import dev.matthiesen.common.template_cobblemon_sidemod.permissions.ModPermissions;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class Example implements ICommand {
    public Example() {}

    public void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
                Commands.literal("example")
                        .requires(src -> ModPermissions.checkPermission(
                                src,
                                CommonModExample.permissions.EXAMPLE_PERMISSION
                        ))
                        .executes(this::normal)
        );
    }

    private int normal(CommandContext<CommandSourceStack> ctx) {
        if (ctx.getSource().getPlayer() != null) {
            ServerPlayer player = ctx.getSource().getPlayer();
            player.displayClientMessage(Component.literal("Hey!"), false);
        }
        return 1;
    }
}