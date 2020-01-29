package fr.huminecraft.huminecinematic.cinematic.scenes;

import fr.huminecraft.huminecinematic.cinematic.Cinematic;
import org.bukkit.OfflinePlayer;

import java.lang.reflect.InvocationTargetException;

public enum Scenes {

    WAKE_UP(WakeUpCinematic.class);

    private Class<? extends Cinematic> c;

    private Scenes(Class<? extends Cinematic> c) {
        this.c = c;
    }

    public Cinematic generate(OfflinePlayer player) {
        Cinematic cinematic = null;
        try {
            cinematic = c.getConstructor().newInstance();
            cinematic.setPlayer(player);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return cinematic;
    }

    public Class<? extends Cinematic> getC() {
        return c;
    }
}
