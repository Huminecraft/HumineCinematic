package fr.huminecraft.huminecinematic.cinematic;

import fr.huminecraft.huminecinematic.cinematic.delayer.DelayerManager;
import fr.huminecraft.huminecinematic.cinematic.sound.Music;
import org.bukkit.OfflinePlayer;

public abstract class Cinematic {

    protected DelayerManager delayerManager;
    protected OfflinePlayer player;
    protected Instance instance;
    protected Music music;

    public Cinematic() {
        this.delayerManager = new DelayerManager();
        this.music = new Music(delayerManager);
    }

    public abstract void start();

    public void stop() {
        music.stop();
        delayerManager.clear();
    }

    public OfflinePlayer getPlayer() {
        return player;
    }

    public void setPlayer(OfflinePlayer player) {
        this.player = player;
        music.setPlayer(player.getPlayer());
    }

    public void setInstance(Instance instance) {
        this.instance = instance;
    }

    public Instance getInstance() {
        return instance;
    }
}
