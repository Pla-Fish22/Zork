package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.GameOutput;

public class InfoCommand implements Command{
    @Override
    public int wordCount() {
        return 0;
    }

    @Override
    public void commandExecute(Game game, GameOutput gameOutput) {
        if(game.isPlay){
            gameOutput.println("Info: " + game.room.getMonster().getName() + "\n");
        }
    }

    @Override
    public String getCommand() {
        return "info";
    }
}
