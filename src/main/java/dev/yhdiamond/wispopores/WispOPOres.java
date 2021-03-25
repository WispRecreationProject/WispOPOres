package dev.yhdiamond.wispopores;

import dev.yhdiamond.wispopores.bstats.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class WispOPOres extends JavaPlugin {
    public static boolean isStarted = false;
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new OreBreakListener(), this);
        Bukkit.getPluginManager().registerEvents(new AnvilListener(), this);
        getCommand("wispopores").setExecutor(new StartCommand());
        getCommand("wispopores").setTabCompleter(new CommandComplete());
        new Metrics(this, 10801);
    }


}
