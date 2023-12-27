package org.chronoplugins.cmdtial.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.chronoplugins.cmdtial.utility.Permissions;
import org.chronoplugins.cmdtial.utility.StringConstructor;
import org.chronoplugins.cmdtial.utility.TeleportationData;
import org.jetbrains.annotations.NotNull;

public class bring implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be executed by a player.");
            return true;
        }

        Player player = (Player) sender;

        if (!Permissions.hasPermission("bring", player)) {
            StringConstructor.commandMessage(player, "You do not have permission to use this command!", true);
            return true;
        }

        if (args.length == 0) {
            StringConstructor.commandMessage(player, "You need a player to bring!", true);
            return true;
        }

        Player target = player.getServer().getPlayer(args[0]);

        if (target == null) {
            StringConstructor.commandMessage(player, "Player not found!", true);
            return true;
        }

        TeleportationData.setData(player.getUniqueId(), StringConstructor.locationToString(target.getLocation()), "player");
        target.teleportAsync(player.getLocation());
        target.playSound(target.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1f, 0.9f);

        return true;
    }
}
