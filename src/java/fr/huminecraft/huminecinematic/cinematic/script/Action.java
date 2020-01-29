package fr.huminecraft.huminecinematic.cinematic.script;

import org.bukkit.entity.Player;

public class Action {

    private String text;
    private String sound;
    private int delay;

    public Action(String text, String sound, int delay) {
        this.text = text;
        this.sound = sound;
        this.delay = delay;
    }

    public void play(Player player) {
        if (text != null)
            player.sendMessage(text);
        if (sound != null)
            player.playSound(player.getLocation(), sound, 5, 1);
    }

    public int getDelay() {
        return delay;
    }

    public String getSound() {
        return sound;
    }

    public String getText() {
        return text;
    }
}
