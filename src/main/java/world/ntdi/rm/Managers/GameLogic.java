package world.ntdi.rm.Managers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import world.ntdi.rm.RM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GameLogic implements Listener {
    public static List<ItemStack> items = new ArrayList<>();
    public static List<Material> blocks = Arrays.asList(Material.STONE, Material.DIRT, Material.OAK_PLANKS);

    public void startGame(Player p, int amount) {

        ItemStack pickaxe = new ItemStack(Material.WOODEN_PICKAXE); ItemStack axe = new ItemStack(Material.WOODEN_AXE); ItemStack shovel = new ItemStack(Material.WOODEN_SHOVEL); ItemMeta pickaxeItemMeta = pickaxe.getItemMeta(); pickaxeItemMeta.setUnbreakable(true); pickaxe.setItemMeta(pickaxeItemMeta); ItemMeta axeItemMeta = axe.getItemMeta(); axeItemMeta.setUnbreakable(true); axe.setItemMeta(axeItemMeta); ItemMeta shovelItemMeta = shovel.getItemMeta(); shovelItemMeta.setUnbreakable(true); shovel.setItemMeta(shovelItemMeta); items.add(pickaxe); items.add(axe); items.add(shovel);

        Miner miner = new Miner(p, amount);
        RM.miners.put(p, miner);

        for (int i = 4; i < amount + 4; i++) {
            double height = miner.getStart().getY() + i;
            Location loc = new Location(miner.getStart().getWorld(), miner.getStart().getX(), height, miner.getStart().getZ());
            loc.getBlock().setType(randomBlock());

        }
        p.getInventory().clear();
        for (ItemStack item : items) {
            p.getInventory().addItem(item);
        }
        p.teleport(new Location(miner.getStart().getWorld(), miner.getStart().getX(), miner.getStart().getY() + 4 + amount, miner.getStart().getZ(), 0, 90));
        
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if (RM.miners.containsKey(e.getPlayer())) {
            Miner miner = RM.miners.get(e.getPlayer());
            int dist = (int) e.getPlayer().getLocation().distance(miner.getStart());
            if (dist < 4) {
                long finishTime = System.currentTimeMillis();
                long time = finishTime - miner.getStartTime();
                int timeInSeconds = (int) (time / 1000);
                e.getPlayer().sendMessage("You finished in " + timeInSeconds + "ms with a height of " + miner.getAmount());
                RM.miners.remove(e.getPlayer());
                e.getPlayer().getInventory().clear();
            }
        }
    }

    public Material randomBlock() {
        Random rand = new Random();
        return blocks.get(rand.nextInt(blocks.size()));
    }
}
