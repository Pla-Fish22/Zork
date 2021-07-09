package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.GameOutput;
import io.muic.ssc.zork.Player;
import io.muic.ssc.zork.map.Room;

public class PlayCommand implements Command{
    @Override
    public int wordCount() {
        return 0;
    }

    @Override
    public void commandExecute(Game game, GameOutput gameOutput, Room room, Player player, String secondStatement) {
        if(!game.isPlay()){
            game.switchPlay();
            game.room = new Room();
            gameOutput.printInGameCommands();
        }
        else{
            gameOutput.println("Game is already started");
        }
    }

    @Override
    public String getCommand() {
        return "play";
    }
}
