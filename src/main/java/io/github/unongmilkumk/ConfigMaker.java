package io.github.unongmilkumk;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class ConfigMaker {
    String fileName;
    File file;
    public FileConfiguration config;
    public ConfigMaker(Plugin plugin, String fileName) {
        this.fileName = fileName;
        file = new File(plugin.getDataFolder(), fileName);
        if (file.exists()) {
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
        }
    }
}
