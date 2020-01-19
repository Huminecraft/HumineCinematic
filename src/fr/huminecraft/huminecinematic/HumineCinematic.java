package fr.huminecraft.huminecinematic;

import fr.huminecraft.huminecinematic.listener.EventManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class HumineCinematic extends JavaPlugin {

    public static final String PLUGIN_NAME = "HumineCinematic";

    @Override
    public void onEnable() {
        super.onEnable();
        Bukkit.getLogger().info(PLUGIN_NAME + "is loaded !");
        EventManager eventManager = new EventManager(this);
        eventManager.registerEvents();
    }

    @Override
    public void onDisable() {
        super.onDisable();
        Bukkit.getLogger().info(PLUGIN_NAME + "is unloaded !");
    }
}
