package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.GameOutput;

public class ExitCommand implements Command {


    @Override
    public int wordCount() {
        return 0;
    }

    @Override
    public void commandExecute(Game game, GameOutput gameOutput) {
        game.exit();
    }

    @Override
    public String getCommand() {
        return "exit";
    }
}
