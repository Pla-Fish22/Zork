package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.GameOutput;
import io.muic.ssc.zork.Player;
import io.muic.ssc.zork.map.Room;

public class InfoCommand implements Command{
    @Override
    public int wordCount() {
        return 0;
    }

    @Override
    public void commandExecute(Game game, GameOutput gameOutput, Room room, Player player, String secondStatement) {
        if(game.isPlay()){
            gameOutput.printRoomDetails(room);
        }
    }

    @Override
    public String getCommand() {
        return "info";
    }


}
