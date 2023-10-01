package io.github.unongmilkumk.Scissors.player;

import io.github.unongmilkumk.Scissors.player.modification.ScissorsBanLite;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class ScissorsUser {
    private Player p;
    public ScissorsUser(Player p) {
        this.p = p;
    }

    public Player getPlayer() {
        return p;
    }

    public double getCurrentDirectionSpeed(Location from, Location to) {
        double xDiff = Math.abs(from.getX() - to.getX());
        double zDiff = Math.abs(from.getZ() - to.getZ());

        return Math.max(xDiff, zDiff);
    }

    public ScissorsBanLite getCustomzieBan() {
        return new ScissorsBanLite(p);
    }
}
