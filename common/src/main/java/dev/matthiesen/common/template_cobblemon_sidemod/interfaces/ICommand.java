package dev.matthiesen.common.template_cobblemon_sidemod.interfaces;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;

public interface ICommand {
    void register(CommandDispatcher<CommandSourceStack> dispatcher);
}
