package fr.huminecraft.huminecinematic;

import fr.huminecraft.huminecinematic.cinematic.InstanceManager;
import fr.huminecraft.huminecinematic.listener.EventManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class HumineCinematic extends JavaPlugin {

    public static final String PLUGIN_NAME = "HumineCinematic";

    public static InstanceManager instances;

    @Override
    public void onEnable() {
        super.onEnable();
        Bukkit.getLogger().info(PLUGIN_NAME + "is loaded !");

        saveResource("scene_1.json", true);

        EventManager eventManager = new EventManager(this);
        eventManager.registerEvents();

        instances = new InstanceManager();

    }

    @Override
    public void onDisable() {
        super.onDisable();
        Bukkit.getLogger().info(PLUGIN_NAME + "is unloaded !");
    }
}
