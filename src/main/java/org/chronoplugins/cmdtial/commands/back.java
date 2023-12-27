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

public class back implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        final Player player = (Player) commandSender;
        final String teleportPos = TeleportationData.getSelfData(player.getUniqueId());

        final boolean permissionCheck = Permissions.hasPermission("back", player);
        if (!permissionCheck) {
            StringConstructor.commandMessage(player, "You do not have permission to use this command!", true);
            return true;
        }

        if (teleportPos == null) {
            StringConstructor.commandMessage(player, "You don't have a original position to teleport to!", true);
            return true;
        }

        player.teleportAsync(StringConstructor.stringToLocation(teleportPos));
        player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1f, 0.9f);

        return true;
    }
}
