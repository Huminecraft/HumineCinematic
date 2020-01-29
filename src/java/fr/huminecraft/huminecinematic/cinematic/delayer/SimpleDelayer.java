package fr.huminecraft.huminecinematic.cinematic.delayer;

import fr.huminecraft.huminecinematic.HumineCinematic;
import org.bukkit.Bukkit;

import java.util.Objects;

public class SimpleDelayer extends Delayer {

    private int delay;

    public SimpleDelayer(int delay) {
        this.delay = delay;
    }

    public SimpleDelayer(Runnable runnable, int delay) {
        super(runnable);
        this.delay = delay;
    }

    @Override
    public void start() {
        task = Bukkit.getScheduler().scheduleSyncDelayedTask(
                Objects.requireNonNull(Bukkit.getPluginManager().getPlugin(HumineCinematic.PLUGIN_NAME)),
                runnable, delay);
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getDelay() {
        return delay;
    }
}
