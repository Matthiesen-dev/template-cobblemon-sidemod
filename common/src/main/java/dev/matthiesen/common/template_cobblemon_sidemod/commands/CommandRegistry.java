package dev.matthiesen.common.template_cobblemon_sidemod.commands;

import com.mojang.brigadier.CommandDispatcher;
import dev.matthiesen.common.template_cobblemon_sidemod.interfaces.ICommand;
import net.minecraft.commands.CommandSourceStack;

import java.util.List;

public class CommandRegistry {
    public static final List<ICommand> COMMANDS = List.of(
            new Example()
    );

    public static void init(CommandDispatcher<CommandSourceStack> dispatcher) {
        for (ICommand command : COMMANDS) {
            command.register(dispatcher);
        }
    }
}
