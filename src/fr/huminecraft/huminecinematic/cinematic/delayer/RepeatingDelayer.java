package fr.huminecraft.huminecinematic.cinematic.delayer;

import fr.huminecraft.huminecinematic.HumineCinematic;
import org.bukkit.Bukkit;

import java.util.Objects;

public class RepeatingDelayer extends Delayer {

    private int before, interval;

    public RepeatingDelayer(int before, int interval) {
        this.before = before;
        this.interval = interval;
    }

    public RepeatingDelayer(Runnable runnable, int before, int interval) {
        super(runnable);
        this.before = before;
        this.interval = interval;
    }

    @Override
    public void start() {
        task = Bukkit.getScheduler().scheduleSyncRepeatingTask(
                Objects.requireNonNull(Bukkit.getPluginManager().getPlugin(HumineCinematic.PLUGIN_NAME)), runnable,
                before, interval);
    }

    public int getBefore() {
        return before;
    }

    public int getInterval() {
        return interval;
    }
}
