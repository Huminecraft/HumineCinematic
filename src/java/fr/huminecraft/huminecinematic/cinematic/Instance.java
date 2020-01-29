package fr.huminecraft.huminecinematic.cinematic;

import fr.huminecraft.huminecinematic.cinematic.scenes.Scenes;
import org.bukkit.OfflinePlayer;

public class Instance {

    private OfflinePlayer player;
    private Scenes scenes;
    private Cinematic cinematic;

    public Instance(OfflinePlayer player) {
        this.player = player;
    }

    public void start() {
        cinematic = scenes.generate(player);
        cinematic.setInstance(this);
        cinematic.start();
    }

    public void stop() {
        if (cinematic != null) {
            cinematic.stop();
        }
    }

    public void setScenes(Scenes scenes) {
        stop();
        this.scenes = scenes;
    }

    public Scenes getScenes() {
        return scenes;
    }

    public OfflinePlayer getPlayer() {
        return player;
    }

}
