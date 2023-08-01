package io.github.unongmilkumk.Scissors.makers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.List;

public class PlayerHeadMaker {
    public final ItemStack item;
    public PlayerHeadMaker(String name) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) head.getItemMeta();
        meta.setOwningPlayer(Bukkit.getOfflinePlayer(name));
        head.setItemMeta(meta);
        this.item = head;
    }
    public PlayerHeadMaker(ItemStack item) {
        this.item = item;
    }
    public PlayerHeadMaker name(String name) {
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(name);
        item.setItemMeta(im);
        return this;
    }
    public PlayerHeadMaker lore(List<String> lore) {
        ItemMeta im = item.getItemMeta();
        im.setLore(lore);
        item.setItemMeta(im);
        return this;
    }
    public PlayerHeadMaker unbreakable(boolean unbreakable) {
        ItemMeta im = item.getItemMeta();
        im.setUnbreakable(unbreakable);
        item.setItemMeta(im);
        return this;
    }
}
