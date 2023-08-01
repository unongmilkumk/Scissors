package io.github.unongmilkumk.Scissors.makers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.List;

public class PlayerHeadMaker {
    public final ItemStack head;
    public PlayerHeadMaker(String name) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) head.getItemMeta();
        meta.setOwningPlayer(Bukkit.getOfflinePlayer(name));
        head.setItemMeta(meta);
        this.head = head;
    }
    public PlayerHeadMaker(ItemStack item) {
        this.head = item;
    }
    public PlayerHeadMaker name(String name) {
        ItemMeta im = head.getItemMeta();
        im.setDisplayName(name);
        head.setItemMeta(im);
        return this;
    }
    public PlayerHeadMaker lore(List<String> lore) {
        ItemMeta im = head.getItemMeta();
        im.setLore(lore);
        head.setItemMeta(im);
        return this;
    }
    public PlayerHeadMaker unbreakable(boolean unbreakable) {
        ItemMeta im = head.getItemMeta();
        im.setUnbreakable(unbreakable);
        head.setItemMeta(im);
        return this;
    }
}
