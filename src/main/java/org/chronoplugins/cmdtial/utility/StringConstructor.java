package org.chronoplugins.cmdtial.utility;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Logger {
    private static final String prefix = ChatColor.BLUE + "[Cmdtial]: " + ChatColor.RESET;

    public static String constructPrefix(String message) {
        return prefix + message;
    }

    public static void commandMessage(Player player, String message) {
        player.sendMessage(prefix + message);
    }

}
