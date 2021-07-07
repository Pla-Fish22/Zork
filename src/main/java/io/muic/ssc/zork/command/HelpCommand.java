package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;

public class HelpCommand implements Command{
    @Override
    public int wordCount() {
        return 0;
    }

    @Override
    public void commandExecute(Game game) {


    }

    @Override
    public String getCommand() {
        return null;
    }
}
