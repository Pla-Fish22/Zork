package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.GameOutput;
import io.muic.ssc.zork.Player;
import io.muic.ssc.zork.map.GameMap;

import java.util.List;

public interface Command {


    int wordCount(List<String> statements);

    void commandExecute(Game game, GameOutput gameOutput, GameMap map, Player player, List<String> statements);

    String getCommand();

    String makeSubject(List<String> statements);



}