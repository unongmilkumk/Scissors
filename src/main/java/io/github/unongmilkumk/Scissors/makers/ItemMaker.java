package io.github.unongmilkumk.Scissors.makers;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;

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

    public ItemMaker customModelData(int customModelData) {
        ItemMeta im = item.getItemMeta();
        im.setCustomModelData(customModelData);
        item.setItemMeta(im);
        return this;
    }

    public ItemMaker colorizeLeatherArmor(Color color) {
        if (item.getType() == Material.LEATHER_CHESTPLATE ||
                item.getType() == Material.LEATHER_LEGGINGS ||
                item.getType() == Material.LEATHER_BOOTS ||
                item.getType() == Material.LEATHER_HELMET) {
            LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
            meta.setColor(color);
            item.setItemMeta(meta);
        }
        return this;
    }

    public ItemMaker skullOwner(String playerName) {
        if (item.getType() == Material.PLAYER_HEAD) {
            SkullMeta meta = (SkullMeta) item.getItemMeta();
            meta.setOwner(playerName);
            item.setItemMeta(meta);
        }
        return this;
    }

    public ItemMaker potionEffects(PotionEffect... potionEffects) {
        if (item.getType() == Material.POTION) {
            PotionMeta meta = (PotionMeta) item.getItemMeta();
            for (PotionEffect effect : potionEffects) {
                meta.addCustomEffect(effect, true);
            }
            item.setItemMeta(meta);
        }
        return this;
    }

    /**
     * Warning : Glow make the item unenchantable
     */
    public ItemMaker glow() {
        ItemMeta im = item.getItemMeta();
        if (item.getType().equals(Material.FISHING_ROD)) im.addEnchant(Enchantment.LURE, 1, true);
        else im.addEnchant(Enchantment.SOUL_SPEED, 1, true);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(im);
        return this;
    }
}
