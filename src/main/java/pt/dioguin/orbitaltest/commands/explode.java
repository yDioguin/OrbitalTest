package pt.dioguin.orbitaltest.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pt.dioguin.orbitaltest.Main;

public class explode implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length != 1){
            sender.sendMessage(Main.getMessages().getString("ExplodeSyntaxError").replace("&", "§"));
            return true;
        }

        Player target = Bukkit.getPlayerExact(args[0]);

        if (target == null || !target.isOnline()){
            sender.sendMessage(Main.getMessages().getString("PlayerNotOnline").replace("&", "§"));
            return true;
        }

        target.getLocation().getWorld().createExplosion(target.getLocation(), 8);
        sender.sendMessage(Main.getMessages().getString("ExplodeSuccess").replace("&", "§").replace("{player}", target.getName()));

        return false;
    }
}
