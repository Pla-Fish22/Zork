package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.GameOutput;
import io.muic.ssc.zork.Player;
import io.muic.ssc.zork.map.GameMap;

import java.util.List;

public class SaveCommand implements Command{
    @Override
    public int wordCount(List<String> statements) {
        return 0;
    }

    @Override
    public void commandExecute(Game game, GameOutput gameOutput, GameMap map, Player player, List<String> statements) {
        if(game.isPlay()){
            gameOutput.println("Saving...");
            String saveName = makeSubject(statements.subList(1, statements.size()));
            game.saveGame(saveName);
            gameOutput.println("Done");
        }
    }

    @Override
    public String getCommand() {
        return "save";
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
