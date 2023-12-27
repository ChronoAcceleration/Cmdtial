package org.chronoplugins.cmdtial.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.chronoplugins.cmdtial.utility.StringConstructor;
import org.jetbrains.annotations.NotNull;

public class survival implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player) commandSender;
        final String fArg = strings[0];
        Player target = player.getServer().getPlayer(fArg);

        if (target == null) {
            player.setGameMode(GameMode.SURVIVAL);
            StringConstructor.commandMessage(player, "Successfully set your gamemode!", true);
            return true;
        } else {
            target.setGameMode(GameMode.SURVIVAL);
            StringConstructor.commandMessage(player, "Set " + target.getName() + "'s gamemode!", true);
            return true;
        }
    }
}
