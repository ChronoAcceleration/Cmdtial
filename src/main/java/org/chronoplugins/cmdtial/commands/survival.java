package org.chronoplugins.cmdtial.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.chronoplugins.cmdtial.utility.Permissions;
import org.chronoplugins.cmdtial.utility.StringConstructor;
import org.jetbrains.annotations.NotNull;

public class survival implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be executed by a player.");
            return true;
        }

        Player player = (Player) sender;

        if (!Permissions.hasPermission("gms", player)) {
            StringConstructor.commandMessage(player, "You do not have permission to use this command!");
            return true;
        }

        if (args.length == 0) {
            setGameMode(player, GameMode.SURVIVAL);
        } else {
            Player target = player.getServer().getPlayer(args[0]);

            if (target == null) {
                StringConstructor.commandMessage(player, "Player not found!");
                return true;
            }

            setGameMode(target, GameMode.SURVIVAL);
            StringConstructor.commandMessage(player, "Set " + target.getName() + "'s gamemode!");
        }

        return true;
    }

    private void setGameMode(Player player, GameMode gameMode) {
        player.setGameMode(gameMode);
        String message = (player.equals(player)) ? "Successfully set your gamemode!" : "Set " + player.getName() + "'s gamemode!";
        StringConstructor.commandMessage(player, message);
    }
}
