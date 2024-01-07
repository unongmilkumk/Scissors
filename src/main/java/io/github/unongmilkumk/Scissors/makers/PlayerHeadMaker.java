package io.github.unongmilkumk.Scissors.makers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.List;

public class PlayerHeadMaker {
    public final ItemStack head;

    public PlayerHeadMaker(String name) {
        this.head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) head.getItemMeta();
        meta.setOwningPlayer(Bukkit.getOfflinePlayer(name));
        head.setItemMeta(meta);
    }

    public PlayerHeadMaker(ItemStack item) {
        this.head = item.clone();
    }

    public PlayerHeadMaker name(String name) {
        return updateMeta(im -> im.setDisplayName(name));
    }

    public PlayerHeadMaker lore(List<String> lore) {
        return updateMeta(im -> im.setLore(lore));
    }

    public PlayerHeadMaker unbreakable(boolean unbreakable) {
        return updateMeta(im -> im.setUnbreakable(unbreakable));
    }

    public PlayerHeadMaker enchantment(Enchantment enchantment, int level) {
        head.addEnchantment(enchantment, level);
        return this;
    }

    public PlayerHeadMaker itemFlag(ItemFlag... itemFlags) {
        return updateMeta(im -> im.addItemFlags(itemFlags));
    }

    public ItemStack build() {
        return head.clone();
    }

    private PlayerHeadMaker updateMeta(MetaUpdater updater) {
        ItemMeta im = head.getItemMeta();
        updater.update(im);
        head.setItemMeta(im);
        return this;
    }

    private interface MetaUpdater {
        void update(ItemMeta meta);
    }
}
