package me.murilin;

import org.bukkit.plugin.java.JavaPlugin;

public interface MSModule{

    void load(MSEssentials msEssentials);
    void unload(MSEssentials msEssentials);
}
