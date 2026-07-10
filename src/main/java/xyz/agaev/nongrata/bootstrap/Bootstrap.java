package xyz.agaev.nongrata.bootstrap;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.agaev.nongrata.command.NonGrataCommand;

public class Bootstrap {

    private final JavaPlugin plugin;

    public Bootstrap(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void enable() {

        registerCommands();
        registerListeners();

    }

    public void disable() {

    }

    private void registerCommands() {

        if (plugin.getCommand("nongrata") != null) {
            plugin.getCommand("nongrata")
                    .setExecutor(new NonGrataCommand());
        }

    }

    private void registerListeners() {

        // Будут зарегистрированы в следующих коммитах

    }

}
