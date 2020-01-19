package fr.huminecraft.huminecinematic.listener;

import fr.huminecraft.huminecinematic.HumineCinematic;
import fr.huminecraft.huminecinematic.listener.event.PlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

public class EventManager {

    private final Listener[] listeners = {
        new PlayerJoin()
    };

    private HumineCinematic humineCinematic;

    public EventManager(HumineCinematic humineCinematic) {
        this.humineCinematic = humineCinematic;
    }

    public void registerEvents() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        for (Listener listener : listeners) {
            pluginManager.registerEvents(listener, humineCinematic);
        }
    }

}
