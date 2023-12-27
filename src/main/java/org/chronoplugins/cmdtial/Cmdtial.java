package org.chronoplugins.cmdtial;

import org.bstats.bukkit.Metrics;
import org.bukkit.Server;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.chronoplugins.cmdtial.commands.*;
import org.chronoplugins.cmdtial.tabcompletors.timeTabCompletor;
import org.chronoplugins.cmdtial.utility.StringConstructor;

import java.util.logging.Logger;

public final class Cmdtial extends JavaPlugin {

    private final Server server = getServer();
    private final Logger logger = server.getLogger();
    private final PluginManager pluginManager = server.getPluginManager();


    @Override
    public void onEnable() {
        // Plugin startup logic

        logger.info(StringConstructor.constructConsoleMessage("Attempting to load commands."));

        // Load Commands

        getCommand("gmc").setExecutor(new creative());
        getCommand("gms").setExecutor(new survival());
        getCommand("gmsp").setExecutor(new spectator());
        getCommand("bring").setExecutor(new bring());
        getCommand("return").setExecutor(new returnplr());
        getCommand("to").setExecutor(new to());
        getCommand("back").setExecutor(new back());
        getCommand("time").setExecutor(new time());

        // Load Tab Completors

        getCommand("time").setTabCompleter(new timeTabCompletor());

        // Load Metrics

        try {
            Metrics metrics = new Metrics(this, 20566);
        } catch (Exception e) {
            logger.warning("Failed to load metrics. :(");
        }

        // Finalize

        logger.info(StringConstructor.constructConsoleMessage("Commands loaded."));

    }

    @Override
    public void onDisable() {
        logger.info(StringConstructor.constructConsoleMessage("Goodbye, world!"));
    }

    public static Cmdtial getInstance() {
        return getPlugin(Cmdtial.class);
    }
}
