package io.github.unongmilkumk.Scissors.player.modification;

import org.bukkit.entity.Player;

import java.time.Duration;
import java.util.Date;

public class ScissorsBanLite {
    private Player target;
    public ScissorsBanLite(Player target) {
        this.target = target;
    }

    public Player getTarget() {
        return target;
    }

    public void ban() {
        target.banPlayerFull("");
    }

    public void ban(String reason) {
        target.banPlayerFull(reason);
    }

    public void ban(Date dur) {
        target.banPlayerFull("",dur);
    }

    public void ban(String reason, Date duration) {
        target.banPlayerFull(reason, duration);
    }
}
