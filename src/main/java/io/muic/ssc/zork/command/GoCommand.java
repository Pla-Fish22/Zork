package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.GameOutput;
import io.muic.ssc.zork.Player;
import io.muic.ssc.zork.map.GameMap;
import io.muic.ssc.zork.map.Room;

import java.util.List;

public class GoCommand implements Command{
    @Override
    public int wordCount(List<String> statements) {
        return 0;
    }

    @Override
    public void commandExecute(Game game, GameOutput gameOutput, GameMap map, Player player, List<String> statements) {
        if(game.isPlay()){
            String exit = makeSubject(statements.subList(1, statements.size()));
            Room goRoom = player.getCurrentRoom().getExit(exit);
            player.setCurrentRoom(goRoom);
            gameOutput.println("Go to " + player.getCurrentRoom().getName());
            if(!player.getCurrentRoom().monsterisAlive()){
                player.getCurrentRoom().respawnMonster();
            }
            player.getCurrentRoom().replaceItem();
            player.heal();
        }
    }

    @Override
    public String getCommand() {
        return "go";
    }

    @Override
    public String makeSubject(List<String> statements) {
        StringBuilder choiceMaker = new StringBuilder();
        for(int idx = 0; idx < statements.size(); idx++){
            choiceMaker.append(statements.get(idx));
            if(idx < statements.size()-1){
                choiceMaker.append(" ");
            }
        }
        return choiceMaker.toString();
    }
}
