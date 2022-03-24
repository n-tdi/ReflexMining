package world.ntdi.rm;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import world.ntdi.rm.Commands.CommandManager;
import world.ntdi.rm.Managers.GameLogic;
import world.ntdi.rm.Managers.Miner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;

public final class RM extends JavaPlugin {

    public static RM instance;

    public static GameLogic gameLogic;

    public static WeakHashMap<Player, Miner> miners = new WeakHashMap<>();

    public static String logo = ChatColor.BLUE + "REFLEX " + ChatColor.AQUA + "MINING";

    @Override
    public void onEnable() {
        instance = this;

        gameLogic = new GameLogic();

        getCommand("rm").setExecutor(new CommandManager());
        getServer().getPluginManager().registerEvents(new GameLogic(), this);
        Bukkit.getLogger().info("RM is enabled!");
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
