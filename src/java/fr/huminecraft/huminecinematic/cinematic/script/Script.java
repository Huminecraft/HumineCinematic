package fr.huminecraft.huminecinematic.cinematic.script;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import fr.huminecraft.huminecinematic.HumineCinematic;
import fr.huminecraft.huminecinematic.cinematic.delayer.DelayerManager;
import fr.huminecraft.huminecinematic.cinematic.delayer.SimpleDelayer;
import org.bukkit.entity.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Script {

    private String name;
    private String content;

    private List<Action> actionList;
    private DelayerManager delayerManager;
    private Player player;

    public Script(String name, Player player, DelayerManager delayerManager) {
        this.name = name;
        this.player = player;
        this.content = "";
        this.delayerManager = delayerManager;
        this.actionList = new ArrayList<>();
        try (
                FileInputStream fis = new FileInputStream(new File("plugins/" + HumineCinematic.PLUGIN_NAME + "/" + name));
                BufferedInputStream bis = new BufferedInputStream(fis);
                Scanner scanner = new Scanner(bis)
        ) {
            while (scanner.hasNext())
                content += scanner.nextLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        init();
    }

    private void init() {
        JsonObject script = new JsonParser().parse(content).getAsJsonObject();
        JsonArray actions = script.getAsJsonArray("script").getAsJsonArray();
        for (int i = 0 ; i < actions.size() ; i++) {
            JsonObject action = actions.get(i).getAsJsonObject();

            String text = action.get("text") == null ? null : action.get("text").getAsString();
            String sound = action.get("sound") == null ? null : action.get("sound").getAsString();
            int delay = action.get("delay") == null ? 0 : action.get("delay").getAsInt();

            actionList.add(new Action(text, sound, delay));
        }
    }

    public void play() {
        for (Action action : actionList) {
            delayerManager.runTask(new SimpleDelayer(() -> {
                action.play(player);
            }, action.getDelay()));
        }
    }

    public String getName() {
        return name;
    }

    public Player getPlayer() {
        return player;
    }

    public DelayerManager getDelayerManager() {
        return delayerManager;
    }
}
