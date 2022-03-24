package world.ntdi.rm.Managers;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Miner {
    private Player p;
    private int amount;
    private Location start;
    private Long startTime;

    public Miner(Player p, int amount) {
        this.p = p;
        this.amount = amount;
        this.start = p.getLocation();
        this.startTime = System.currentTimeMillis();
    }

    public Player getP() {
        return p;
    }

    public int getAmount() {
        return amount;
    }

    public Location getStart() {
        return start;
    }

    public Long getStartTime() {
        return startTime;
    }
}
