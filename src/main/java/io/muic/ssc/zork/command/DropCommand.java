package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.GameOutput;
import io.muic.ssc.zork.Item.Armor;
import io.muic.ssc.zork.Item.Item;
import io.muic.ssc.zork.Item.Potion;
import io.muic.ssc.zork.Item.Weapon;
import io.muic.ssc.zork.Player;
import io.muic.ssc.zork.map.GameMap;

import java.util.List;

public class DropCommand implements Command{
    @Override
    public int wordCount(List<String> statements) {
        return 0;
    }

    @Override
    public void commandExecute(Game game, GameOutput gameOutput, GameMap map, Player player, List<String> statements) {
        if(game.isPlay()) {
            String choice = makeSubject(statements.subList(1, statements.size()));
            gameOutput.println("droping " + choice);
            if(player.getWeaponHolster().containsKey(choice)){
                player.dropWeapon(choice);
            }
            if(player.getPotionBag().containsKey(choice)){
                player.dropPotion(choice);
            }
            if(player.isArmed()){
                player.dropArmor(choice);
            }

        }
    }

    @Override
    public String getCommand() {
        return "drop";
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
