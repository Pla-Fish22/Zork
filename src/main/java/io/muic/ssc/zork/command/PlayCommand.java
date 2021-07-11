package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.GameOutput;
import io.muic.ssc.zork.Player;
import io.muic.ssc.zork.map.GameMap;
import io.muic.ssc.zork.map.MapFactory;

import java.util.List;

public class PlayCommand implements Command{
    @Override
    public int wordCount(List<String> statements) {
        return 0;
    }

    @Override
    public void commandExecute(Game game, GameOutput gameOutput, GameMap map, Player player, List<String> statements) {
        if(!game.isPlay()){
            String mapName = makeSubject(statements.subList(1,statements.size()));
            map = MapFactory.get(mapName);
            if(map == null) {
                map = MapFactory.get("mystery castle");
                game.setMap(map);
            }
            game.setMap(map);
            player.setCurrentRoom(map.getDefault());
            game.switchPlay();
            gameOutput.printInGameCommands();
            gameOutput.printGameStart(map, player);
        }
        else{
            gameOutput.println("Game is already started");
        }
    }

    @Override
    public String getCommand() {
        return "play";
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
