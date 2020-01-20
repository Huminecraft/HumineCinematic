package fr.huminecraft.huminecinematic.cinematic.delayer;

import java.util.ArrayList;
import java.util.List;

public class DelayerManager {

    private List<Delayer> delayers;

    public DelayerManager() {
        this.delayers = new ArrayList<>();
    }

    public void runTask(Delayer delayer) {
        delayers.add(delayer);
        delayer.start();
    }

    public void clear() {
        for (int i = 0 ; i < delayers.size() ; i++) {
            delayers.get(i).stop();
            delayers.remove(i);
            i--;
        }
    }

    public List<Delayer> getDelayers() {
        return delayers;
    }
}
