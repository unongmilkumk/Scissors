package io.github.unongmilkumk.Scissors;

import io.github.unongmilkumk.Scissors.player.ScissorsUser;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Main extends JavaPlugin {
    public static final HashMap<UUID, ScissorsUser> USERS = new HashMap<>();
    @Override
    public void onEnable() {
        getLogger().info("Scissors API Plugin Enabled");
        for (Player p : Bukkit.getOnlinePlayers()) {
            USERS.put(p.getUniqueId(), new ScissorsUser(p));
        }
    }
    @Override
    public void onDisable() {
        getLogger().info("Scissors API Plugin Disabled");
    }

    public ScissorsUser getUser(String name) {
        for (ScissorsUser u : USERS.values()) {
            if (u.getPlayer().getName().equalsIgnoreCase(name)) {
                return u;
            }
        }
        return null;
    }

    public ScissorsUser getUser(Player p) {
        for (ScissorsUser u : USERS.values()) {
            if (u.getPlayer().getUniqueId().equals(p.getUniqueId())) {
                return u;
            }
        }
        return null;
    }
}
