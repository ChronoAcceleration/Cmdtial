package org.chronoplugins.cmdtial.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.chronoplugins.cmdtial.utility.Permissions;
import org.chronoplugins.cmdtial.utility.StringConstructor;
import org.jetbrains.annotations.NotNull;

public class spectator implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be executed by a player.");
            return true;
        }

        Player player = (Player) sender;

        if (!Permissions.hasPermission("gmsp", player)) {
            StringConstructor.commandMessage(player, "You do not have permission to use this command!", true);
            return true;
        }

        if (args.length == 0) {
            setSpectatorMode(player, player);
        } else {
            Player target = player.getServer().getPlayer(args[0]);

            if (target == null) {
                StringConstructor.commandMessage(player, "Player not found!", true);
                return true;
            }

            setSpectatorMode(player, target);
        }

        return true;
    }

    private void setSpectatorMode(Player sender, Player target) {
        target.setGameMode(GameMode.SPECTATOR);
        String message = (sender.equals(target)) ? "Successfully set your gamemode!" : "Set " + target.getName() + "'s gamemode!";
        StringConstructor.commandMessage(sender, message, true);
    }
}
