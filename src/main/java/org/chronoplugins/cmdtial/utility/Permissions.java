package org.chronoplugins.cmdtial.utility;

import org.bukkit.entity.Player;

public class Permissions {
    public static boolean hasPermission(String permission, Player player) {
        final String constructedPrefix = "cmdtial." + permission;

        if (player.hasPermission(constructedPrefix) || player.isOp()) {
            return true;
        } else {
            return false;
        }
    }
}
