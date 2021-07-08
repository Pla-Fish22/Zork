package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.GameOutput;

public interface Command {


    int wordCount();

    void commandExecute(Game game, GameOutput gameOutput);

    String getCommand();



}