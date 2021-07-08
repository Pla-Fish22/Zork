package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.GameOutput;
import io.muic.ssc.zork.map.Room;

public class PlayCommand implements Command{
    @Override
    public int wordCount() {
        return 0;
    }

    @Override
    public void commandExecute(Game game, GameOutput gameOutput) {
        game.isPlay = true;
        game.room = new Room();
    }

    @Override
    public String getCommand() {
        return "play";
    }
}
