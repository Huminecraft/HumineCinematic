package fr.huminecraft.huminecinematic.listener.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public final void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
    }

}
