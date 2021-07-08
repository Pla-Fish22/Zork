package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.GameOutput;
import io.muic.ssc.zork.Player;
import io.muic.ssc.zork.map.Room;

public interface Command {


    int wordCount();

    void commandExecute(Game game, GameOutput gameOutput, Room room, Player player, String secondStatement);

    String getCommand();



}