package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;

public interface Command {

    int wordCount();

    void commandExecute(Game game);

    String getCommand();



}