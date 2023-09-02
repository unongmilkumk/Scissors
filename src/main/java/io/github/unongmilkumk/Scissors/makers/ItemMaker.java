package io.github.unongmilkumk.Scissors.makers;

import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemMaker {
    @Getter
    private final ItemStack item;
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
    public ItemMaker enchantment(Enchantment enchantment, int level) {
        item.addEnchantment(enchantment, level);
        return this;
    }
    public ItemMaker itemFlag(ItemFlag... itemFlags) {
        ItemMeta im = item.getItemMeta();
        im.addItemFlags(itemFlags);
        item.setItemMeta(im);
        return this;
    }

    public ItemMaker damage(short damage) {
        item.setDurability(damage);
        return this;
    }
}
