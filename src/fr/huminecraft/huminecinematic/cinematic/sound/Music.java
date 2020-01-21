package fr.huminecraft.huminecinematic.cinematic.sound;

import fr.huminecraft.huminecinematic.cinematic.delayer.Delayer;
import fr.huminecraft.huminecinematic.cinematic.delayer.DelayerManager;
import fr.huminecraft.huminecinematic.cinematic.delayer.RepeatingDelayer;

import org.bukkit.entity.Player;

public class Music {

    private DelayerManager delayerManager;
    private Delayer delayer;

    private MusicPart[] parts;
    private Player player;
    private int index;
    private boolean next;

    public Music(DelayerManager delayerManager) {
        this.delayerManager = delayerManager;
        index = 0;
        next = false;
    }

    public void play() {
        MusicPart part = parts[index];
        delayer = new RepeatingDelayer(() -> {
            if (next) {
                stop();
                play();
                return;
            }

            player.playSound(player.getLocation(), part.getName(), 5, 1);

            if (!part.isLoop()) {
                 next();
            }

         }, 0, part.getDelay());
        delayerManager.runTask(delayer);
    }

    public void next() {
        index++;
        next = true;
    }

    public void stop() {
        delayer.stop();
        next = false;
    }

    public void setParts(MusicPart...parts) {
        this.parts = parts;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
