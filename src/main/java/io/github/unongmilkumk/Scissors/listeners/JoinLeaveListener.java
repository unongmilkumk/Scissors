package io.github.unongmilkumk.Scissors.listeners;

import io.github.unongmilkumk.Scissors.Main;
import io.github.unongmilkumk.Scissors.player.ScissorsUser;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Main.USERS.put(e.getPlayer().getUniqueId(), new ScissorsUser(e.getPlayer()));
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Main.USERS.remove(e.getPlayer().getUniqueId());
    }
}
