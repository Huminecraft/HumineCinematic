package fr.huminecraft.huminecinematic.cinematic;

import fr.huminecraft.huminecinematic.cinematic.delayer.DelayerManager;
import org.bukkit.OfflinePlayer;

public abstract class Cinematic {

    protected DelayerManager delayerManager;
    protected OfflinePlayer player;
    protected Instance instance;

    public Cinematic() {
        this.delayerManager = new DelayerManager();
    }

    public abstract void start();

    public void stop() {
        delayerManager.clear();
    }

    public OfflinePlayer getPlayer() {
        return player;
    }

    public void setPlayer(OfflinePlayer player) {
        this.player = player;
    }

    public void setInstance(Instance instance) {
        this.instance = instance;
    }

    public Instance getInstance() {
        return instance;
    }
}
