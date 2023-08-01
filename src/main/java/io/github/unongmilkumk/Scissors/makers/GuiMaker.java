package io.github.unongmilkumk.Scissors.makers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GuiMaker {
    public Inventory gui;
    public GuiMaker(Player player) {
        gui = player.getInventory();
    }
    public GuiMaker(String title) {
        gui = Bukkit.createInventory(null, 54, title);
    }
    public GuiMaker(String title, int size) {
        gui = Bukkit.createInventory(null, size, title);
    }
    public GuiMaker(String title, int height, int width) {
        gui = Bukkit.createInventory(null, (height - 1) * 9 + (width - 1) , title);
    }
    public void set(int index, ItemStack item) {
        gui.setItem(index, item);
    }
    public void set(int row, int column, ItemStack item) {
        gui.setItem((row - 1) * 9 + (column - 1), item);
    }
    public ItemStack get(int index) {
        return gui.getItem(index);
    }
    public ItemStack get(int row, int column) {
        return gui.getItem((row - 1) * 9 + (column - 1));
    }
}
