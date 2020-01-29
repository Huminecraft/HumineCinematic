package fr.huminecraft.huminecinematic.listener.event;

import fr.huminecraft.huminecinematic.HumineCinematic;
import fr.huminecraft.huminecinematic.cinematic.Instance;
import fr.huminecraft.huminecinematic.cinematic.InstanceManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeft implements Listener {

    @EventHandler
    public final void onPlayerLeft(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        InstanceManager instanceManager = HumineCinematic.instances;
        if (instanceManager.haveInstance(player)) {
            Instance instance = instanceManager.getPlayerInstance(player);
            instance.stop();
        }
    }

}
