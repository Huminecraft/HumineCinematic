package fr.huminecraft.huminecinematic.listener;

import fr.huminecraft.huminecinematic.HumineCinematic;
import fr.huminecraft.huminecinematic.listener.event.PlayerJoin;
import fr.huminecraft.huminecinematic.listener.event.PlayerLeft;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class EventManager {

    private HumineCinematic humineCinematic;

    public EventManager(HumineCinematic humineCinematic) {
        this.humineCinematic = humineCinematic;
    }

    public void registerEvents() {
        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new PlayerJoin(), humineCinematic);
        pluginManager.registerEvents(new PlayerLeft(), humineCinematic);
    }

}
