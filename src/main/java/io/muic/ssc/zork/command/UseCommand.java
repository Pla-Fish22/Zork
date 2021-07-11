package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.GameOutput;
import io.muic.ssc.zork.Item.Potion;
import io.muic.ssc.zork.Player;
import io.muic.ssc.zork.map.GameMap;

import java.util.List;

public class UseCommand implements Command{
    @Override
    public int wordCount(List<String> statements) {
        return 0;
    }

    @Override
    public void commandExecute(Game game, GameOutput gameOutput, GameMap map, Player player, List<String> statements) {
        if(game.isPlay()){
            String potionName = makeSubject(statements.subList(1, statements.size()));
            Potion potion = player.usePotion(potionName);
            gameOutput.printUsingItem(player, potion);
        }
    }

    @Override
    public String getCommand() {
        return "use";
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
