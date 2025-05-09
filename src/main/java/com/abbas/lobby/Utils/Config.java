package com.abbas.lobby.Utils;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.io.IOException;


public class Config {

    private static File file;
    private static FileConfiguration Config;


    public static void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("Lobby").getDataFolder(), "config.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
            }
        }
        Config = YamlConfiguration.loadConfiguration(file);
    }
    public static FileConfiguration getConfig(){
        return Config;
    }
    public static void save() {
        try {
            Config.save(file);
        } catch (IOException e) {
            System.out.println("Couldn't save file");
        }
    }
    public static void reload() {
        Config = YamlConfiguration.loadConfiguration(file);
    }
}
