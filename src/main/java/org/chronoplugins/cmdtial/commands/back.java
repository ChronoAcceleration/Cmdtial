package org.chronoplugins.cmdtial.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.chronoplugins.cmdtial.utility.StringConstructor;
import org.chronoplugins.cmdtial.utility.TeleportationData;
import org.jetbrains.annotations.NotNull;

public class to implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        final String arg1 = strings[1];
        final Player player = (Player) commandSender;
        final Player target = player.getServer().getPlayer(arg1);

        if (target == null) {
            StringConstructor.commandMessage(player, "You need a player to teleport to!", true);
            return true;
        }

        TeleportationData.setData(player.getUniqueId(), String.valueOf(player.getLocation()), "self");
        player.teleport(target);
        player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1f, 0.9f);

        return true;
    }
}
