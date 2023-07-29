package com.scissors;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        new CommandMaker("scissors", "scissors").setCommand((sender, args) -> {
            sender.sendMessage("scissors");
            if (sender instanceof Player player) {
                player.getInventory().addItem(new ItemMaker(Material.DIAMOND_SWORD).name("마검").lore(List.of("마검이다")).unbreakable(true).item);
            }
        }).setAlias(List.of("sci", "가위", "ㄱㅇ")).register();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
