package fr.huminecraft.huminecinematic.cinematic.delayer;

import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Delayer {

    protected int task;
    protected Runnable runnable;
    protected List<Delayer> dependsOn;

    public Delayer() {
        this(null);
    }

    public Delayer(Runnable runnable) {
        this.runnable = runnable;
        dependsOn = new ArrayList<>();
    }

    public abstract void start();

    public void stop() {
        Bukkit.getScheduler().cancelTask(task);
        dependsOn.forEach(Delayer::start);
    }

    public void dependsOn(Delayer...dependsOn) {
        this.dependsOn.addAll(Arrays.asList(dependsOn));
    }

    public void setRunnable(Runnable runnable) {
        this.runnable = runnable;
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public int getTask() {
        return task;
    }
}
