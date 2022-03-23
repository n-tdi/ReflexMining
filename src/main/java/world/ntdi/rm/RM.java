package world.ntdi.rm;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class RM extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("RM is enabled!");

    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("RM is disabled!");
    }
}
