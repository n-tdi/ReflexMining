package world.ntdi.rm.Commands.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import world.ntdi.rm.Commands.SubCommand;
import world.ntdi.rm.RM;

public class ExplodeCMD extends SubCommand {
    @Override
    public String getName() {
        return "explode";
    }

    @Override
    public String getDescription() {
        return "explode a player lol";
    }

    @Override
    public String getSyntax() {
        return "/rm explode <player>";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        if (RM.hasPerm(sender, "rm.explode")) {
            if (args.length > 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    sender.sendMessage("You successfully exploded " + target.getDisplayName());

                    target.playSound(target.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1, 1);
                    target.getWorld().playEffect(target.getLocation(), Effect.SMOKE, 1);
                    target.setHealth(0);
                } else { sender.sendMessage("Player not found"); }
            } else if (args.length == 1) { sender.sendMessage("/rm explode " + sender.getName()); }
        } else { sender.sendMessage("You don't have permission to use this command"); }
    }
}
