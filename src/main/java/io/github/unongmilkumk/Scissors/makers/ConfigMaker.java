package io.github.unongmilkumk.Scissors.makers;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class ConfigMaker {
    public final String fileName;
    public File file;
    private final Plugin plugin;
    public FileConfiguration config;

    public ConfigMaker(Plugin plugin, String fileName) {
        this.plugin = plugin;
        this.fileName = fileName;
        File dataFolder = plugin.getDataFolder();
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }

        file = new File(dataFolder, fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        config = YamlConfiguration.loadConfiguration(file);
    }

    public boolean has(String source) {
        return config.contains(source);
    }

    public Object get(String source) {
        return config.get(source);
    }

    public void set(String source, Object thing) {
        config.set(source, thing);
    }

    public void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
            // You might want to log the error or notify the plugin developer
        }
    }

    public void reload() {
        config = YamlConfiguration.loadConfiguration(file);
    }
}
