package io.github.unongmilkumk.Scissors;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Scissors API Plugin Enabled");
    }
    @Override
    public void onDisable() {
        getLogger().info("Scissors API Plugin Disabled");
    }
}
