package fr.huminecraft.huminecinematic.cinematic.sound;

public class MusicPart {

    private String name;
    private int delay;
    private boolean loop;

    public MusicPart(String name, int delay, boolean loop) {
        this.name = name;
        this.delay = delay;
        this.loop = loop;
    }

    public int getDelay() {
        return delay;
    }

    public String getName() {
        return name;
    }

    public boolean isLoop() {
        return loop;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
