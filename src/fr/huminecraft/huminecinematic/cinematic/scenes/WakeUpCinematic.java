package fr.huminecraft.huminecinematic.cinematic.scenes;

import fr.huminecraft.huminecinematic.cinematic.Cinematic;
import fr.huminecraft.huminecinematic.cinematic.sound.MusicPart;

public class WakeUpCinematic extends Cinematic {

    @Override
    public void start() {
        music.setParts(new MusicPart("minecraft:custom.space_intro", 20 * 20, false),
                new MusicPart("minecraft:custom.space_1", 20 * 16, true),
                new MusicPart("minecraft:custom.space_2", 20 * 16, true));
        music.play();
    }

}
