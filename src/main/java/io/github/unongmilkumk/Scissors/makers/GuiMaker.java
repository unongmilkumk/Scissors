package io.github.unongmilkumk.Scissors.makers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GuiMaker {
    public Inventory inventory;
    public GuiMaker(Player player) {
        inventory = player.getInventory();
    }
    public GuiMaker(String title) {
        inventory = Bukkit.createInventory(null, 54, title);
    }
    public GuiMaker(String title, int size) {
        inventory = Bukkit.createInventory(null, size, title);
    }
    public GuiMaker(String title, int height, int width) {
        inventory = Bukkit.createInventory(null, (height - 1) * 9 + (width - 1) , title);
    }
    public void set(int index, ItemStack item) {
        inventory.setItem(index, item);
    }
    public void set(int row, int column, ItemStack item) {
        inventory.setItem((row - 1) * 9 + (column - 1), item);
    }
    public ItemStack get(int index) {
        return inventory.getItem(index);
    }
    public ItemStack get(int row, int column) {
        return inventory.getItem((row - 1) * 9 + (column - 1));
    }
}
