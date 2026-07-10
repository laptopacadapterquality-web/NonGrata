package xyz.agaev.nongrata;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.agaev.nongrata.bootstrap.Bootstrap;

public final class NonGrataPlugin extends JavaPlugin {

    private Bootstrap bootstrap;

    @Override
    public void onEnable() {

        saveDefaultConfig();

        bootstrap = new Bootstrap(this);
        bootstrap.enable();

        getLogger().info("NonGrata enabled.");

    }

    @Override
    public void onDisable() {

        if (bootstrap != null) {
            bootstrap.disable();
        }

        getLogger().info("NonGrata disabled.");

    }

}
