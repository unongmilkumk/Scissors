package io.github.unongmilkumk.Scissors.makers;

import io.github.unongmilkumk.Scissors.Coordinate;
import net.kyori.adventure.text.BlockNBTComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class GuiMaker {
    public Inventory gui;
    public GuiMaker(Player player) {
        gui = player.getInventory();
    }
    public GuiMaker(String title) {
        gui = Bukkit.createInventory(null, 54, title);
    }
    public GuiMaker(String title, int size, boolean isSizeHeight) {
        gui = Bukkit.createInventory(null, isSizeHeight ? size * 9 : size, title);
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
    public void fillInventory(ItemStack item) {
        for (int i = 0; i < gui.getSize(); i++) {
            gui.setItem(i, item);
        }
    }
    public void copyInventory(Inventory source) {
        gui.setContents(source.getContents());
    }
    public void pasteInventory(Inventory destination) {
        destination.setContents(gui.getContents());
    }
    public void setItems(Map<Coordinate, ItemStack> items) {
        for (Map.Entry<Coordinate, ItemStack> entry : items.entrySet()) {
            int index = getIndexOf(entry.getKey());
            gui.setItem(index, entry.getValue());
        }
    }

    private int getIndexOf(Coordinate coordinate) {
        return (coordinate.getRow() - 1) * 9 + (coordinate.getColumn() - 1);
    }
}
