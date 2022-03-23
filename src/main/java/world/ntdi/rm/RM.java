package world.ntdi.rm;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import world.ntdi.rm.Commands.CommandManager;

public final class RM extends JavaPlugin {

    static RM instance;
    public static String logo = ChatColor.BLUE + "REFLEX " + ChatColor.AQUA + "MINING";

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getLogger().info("RM is enabled!");

        getCommand("rm").setExecutor(new CommandManager());
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("RM is disabled!");
    }

    public static boolean hasPerm(CommandSender sender, String perm) {
        return sender.hasPermission("rm.*") || sender.hasPermission(perm);
    }

    public static RM getInstance() { return instance; }
}
