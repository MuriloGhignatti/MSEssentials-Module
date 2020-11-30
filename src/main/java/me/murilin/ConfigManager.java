package me.murilin;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public abstract class ConfigManager {
    private File file;
    private FileConfiguration customFile;

    public ConfigManager(String fileName){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("EssentialsZR").getDataFolder(), fileName);

        if(!file.exists()){
            try {
                file.createNewFile();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        customFile = YamlConfiguration.loadConfiguration(file);
    }

    public FileConfiguration get(){
        return customFile;
    }

    public void save(){
        try{
            customFile.save(file);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void reload(){
        customFile = YamlConfiguration.loadConfiguration(file);
    }

    public abstract void generateDefaults();
}
