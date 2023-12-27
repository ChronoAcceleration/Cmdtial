package org.chronoplugins.cmdtial.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.chronoplugins.cmdtial.utility.Permissions;
import org.chronoplugins.cmdtial.utility.StringConstructor;
import org.jetbrains.annotations.NotNull;

public class time implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        final Player player = (Player) sender;
        final boolean permissionCheck = Permissions.hasPermission("time", player);

        if (!permissionCheck) {
            StringConstructor.commandMessage(player, "You do not have permission to use this command!", true);
            return true;
        }

        if (args.length == 0) {
            StringConstructor.commandMessage(player, "You need to specify a time!", true);
            return true;
        }

        String time = args[0];

        if (time.equalsIgnoreCase("day") || time.equalsIgnoreCase("night")) {
            long timeValue = time.equalsIgnoreCase("day") ? 0 : 13000; // 0 for day, 13000 for night
            player.getWorld().setTime(timeValue);
            StringConstructor.commandMessage(player, "Successfully set the time!", true);
        } else {
            StringConstructor.commandMessage(player, "You need to specify a valid time (day/night)!", true);
        }

        return true;
    }
}