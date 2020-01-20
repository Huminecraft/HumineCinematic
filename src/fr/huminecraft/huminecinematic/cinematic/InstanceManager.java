package fr.huminecraft.huminecinematic.cinematic;

import fr.huminecraft.huminecinematic.cinematic.scenes.Scenes;
import org.bukkit.OfflinePlayer;

import java.util.ArrayList;
import java.util.List;

public class InstanceManager {

    private static final Scenes FIRST_SCENE = Scenes.WAKE_UP;

    private List<Instance> instances;

    public InstanceManager() {
        instances = new ArrayList<>();
    }

    public Instance registerPlayer(OfflinePlayer player) {
        Instance instance = null;
        if (player.isOnline()) {
            if (!haveInstance(player)) {
                instance = new Instance(player.getPlayer());
                instances.add(instance);
            } else {
                instance = getPlayerInstance(player);
            }
        }
        return instance;
    }

    public Instance getPlayerInstance(OfflinePlayer player) {
        for (Instance instance : instances) {
            if (instance.getPlayer().getUniqueId().equals(player.getUniqueId())) {
                return instance;
            }
        }
        return null;
    }

    public boolean haveInstance(OfflinePlayer player) {
        return getPlayerInstance(player) != null;
    }

    public List<Instance> getInstances() {
        return instances;
    }
}
