package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.GameOutput;
import io.muic.ssc.zork.Player;
import io.muic.ssc.zork.map.Room;

public class ExitCommand implements Command {


    @Override
    public int wordCount() {
        return 0;
    }

    @Override
    public void commandExecute(Game game, GameOutput gameOutput, Room room, Player player, String secondStatement) {
        game.exit();
    }

    @Override
    public String getCommand() {
        return "exit";
    }
}
