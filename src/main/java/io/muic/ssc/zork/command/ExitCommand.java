package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;

public class ExitCommand implements Command {


    @Override
    public int wordCount() {
        return 0;
    }

    @Override
    public void commandExecute(Game game) {
        game.exit();
    }

    @Override
    public String getCommand() {
        return "exit";
    }
}
