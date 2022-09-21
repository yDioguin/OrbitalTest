package pt.dioguin.orbitaltest.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pt.dioguin.orbitaltest.Main;

public class fire implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length != 1){
            sender.sendMessage(Main.getMessages().getString("FireSyntaxError").replace("&", "§"));
            return true;
        }

        Player target = Bukkit.getPlayerExact(args[0]);

        if (target == null || !target.isOnline()){
            sender.sendMessage(Main.getMessages().getString("PlayerNotOnline").replace("&", "§"));
            return true;
        }

        target.setFireTicks(60);
        sender.sendMessage(Main.getMessages().getString("FireSuccess").replace("&", "§").replace("{player}", target.getName()));

        return false;
    }
}
