package pt.dioguin.orbitaltest;

import org.bukkit.plugin.java.JavaPlugin;
import pt.dioguin.orbitaltest.commands.explode;
import pt.dioguin.orbitaltest.commands.fire;
import pt.dioguin.orbitaltest.commands.lightning;
import pt.dioguin.orbitaltest.utils.Configuration;

public final class Main extends JavaPlugin {

    private static Configuration messages;

    @Override
    public void onEnable() {
        messages = new Configuration(this, "messages.yml");
        messages.saveDefaultConfig();

        getCommand("explode").setExecutor(new explode());
        getCommand("fire").setExecutor(new fire());
        getCommand("lightning").setExecutor(new lightning());

        System.out.println("teste");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Configuration getMessages() {
        return messages;
    }
}
