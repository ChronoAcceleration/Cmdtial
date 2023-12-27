package org.chronoplugins.cmdtial.utility;

import org.bukkit.*;
import org.bukkit.entity.Player;

public class StringConstructor {
    private static final String prefix = ChatColor.BLUE + "[Cmdtial]: " + ChatColor.RESET;
    private static final String serverPrefix = "[Cmdtial]: ";

    public static String constructPrefix(String message) {
        return prefix + message;
    }

    public static void commandMessage(Player player, String message) {
        player.sendMessage(prefix + message);
    }

    public static String constructConsoleMessage(String message) {
        return serverPrefix + message;
    }

    static public String locationToString(final Location l) {
        if (l == null) {
            return "";
        }
        return l.getWorld().getName() + ":" + l.getBlockX() + ":" + l.getBlockY() + ":" + l.getBlockZ();
    }

    static public Location stringToLocation(final String s) {
        if (s == null || s.trim() == "") {
            return null;
        }
        final String[] parts = s.split(":");
        if (parts.length == 4) {
            final World w = Bukkit.getServer().getWorld(parts[0]);
            final int x = Integer.parseInt(parts[1]);
            final int y = Integer.parseInt(parts[2]);
            final int z = Integer.parseInt(parts[3]);
            return new Location(w, x, y, z);
        }
        return null;
    }
}
