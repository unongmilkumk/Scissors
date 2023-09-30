package io.github.unongmilkumk.Scissors.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ScissorsUser {
    private Player p;
    public ScissorsUser(Player p) {
        this.p = p;
    }

    public Player getPlayer() {
        return p;
    }
}
