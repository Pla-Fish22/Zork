package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.GameOutput;
import io.muic.ssc.zork.Player;
import io.muic.ssc.zork.map.Room;

import java.util.List;

public class ExitCommand implements Command {


    @Override
    public int wordCount(List<String> statements) {
        return 0;
    }

    @Override
    public void commandExecute(Game game, GameOutput gameOutput, Room room, Player player, List<String> statements) {
        game.exit();
    }

    @Override
    public String getCommand() {
        return "exit";
    }

    @Override
    public String makeSubject(List<String> statements) {
        return null;
    }
}
