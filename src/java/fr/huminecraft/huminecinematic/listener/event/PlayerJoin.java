package fr.huminecraft.huminecinematic.listener.event;

import fr.huminecraft.huminecinematic.HumineCinematic;
import fr.huminecraft.huminecinematic.cinematic.Instance;
import fr.huminecraft.huminecinematic.cinematic.InstanceManager;
import fr.huminecraft.huminecinematic.cinematic.scenes.Scenes;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public final void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        InstanceManager instanceManager = HumineCinematic.instances;

        Instance instance;
        if (!instanceManager.haveInstance(player)) {
            instance = instanceManager.registerPlayer(player);
            instance.setScenes(Scenes.WAKE_UP);
        } else {
            instance = instanceManager.registerPlayer(player);
        }
        instance.start();


    }

}
