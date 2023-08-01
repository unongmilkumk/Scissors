package io.github.unongmilkumk.Scissors.makers;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemMaker {
    public final ItemStack item;
    public ItemMaker(Material material) {
        this.item = new ItemStack(material);
    }
    public ItemMaker(ItemStack item) {
        this.item = item;
    }
    public ItemMaker name(String name) {
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(name);
        item.setItemMeta(im);
        return this;
    }
    public ItemMaker lore(List<String> lore) {
        ItemMeta im = item.getItemMeta();
        im.setLore(lore);
        item.setItemMeta(im);
        return this;
    }
    public ItemMaker unbreakable(boolean unbreakable) {
        ItemMeta im = item.getItemMeta();
        im.setUnbreakable(unbreakable);
        item.setItemMeta(im);
        return this;
    }
}
