package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.GameOutput;
import io.muic.ssc.zork.Player;
import io.muic.ssc.zork.map.GameMap;

import java.util.List;

public class QuitCommand implements Command{
    @Override
    public int wordCount(List<String> statements) {
        return 0;
    }

    @Override
    public void commandExecute(Game game, GameOutput gameOutput, GameMap map, Player player, List<String> statements) {
        if(game.isPlay()){
            game.switchPlay();
            gameOutput.println("Quiting Zork...");
        }
    }

    @Override
    public String getCommand() {
        return "quit";
    }

    @Override
    public String makeSubject(List<String> statements) {
        return null;
    }
}
