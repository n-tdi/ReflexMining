package world.ntdi.rm.Commands.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import world.ntdi.rm.Commands.SubCommand;
import world.ntdi.rm.RM;

public class StartCMD extends SubCommand {
    @Override
    public String getName() {
        return "start";
    }

    @Override
    public String getDescription() {
        return "start the game";
    }

    @Override
    public String getSyntax() {
        return "/rm start <player> [height]";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        if (sender instanceof Player p) {
            Bukkit.broadcastMessage(args.toString());
            if (args.length == 1) {
                if (Bukkit.getPlayer(args[0]) != null) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (!RM.miners.containsKey(target)) {
                        RM.gameLogic.startGame(target, 50);
                    }
                }
            } else if (args.length == 2) {
                if (Bukkit.getPlayer(args[0]) != null) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (!RM.miners.containsKey(target)) {
                        RM.gameLogic.startGame(target, Integer.parseInt(args[1]));
                    }
                }
            } else {
                sender.sendMessage("/rm start <player> [height]");
            }
        }
    }
}
