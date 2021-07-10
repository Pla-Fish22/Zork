package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.GameOutput;
import io.muic.ssc.zork.Item.Armor;
import io.muic.ssc.zork.Item.Item;
import io.muic.ssc.zork.Item.Potion;
import io.muic.ssc.zork.Item.Weapon;
import io.muic.ssc.zork.Player;
import io.muic.ssc.zork.map.Room;

import java.util.List;
import java.util.Scanner;

public class TakeCommand implements Command{
    @Override
    public int wordCount(List<String> statements) {
        return statements.size();
    }

    @Override
    public void commandExecute(Game game, GameOutput gameOutput, Room room, Player player, List<String> statements) {
        String choice = makeSubject(statements.subList(1,statements.size()));
        gameOutput.println("taking " +  choice);
        Item item = room.takeItem(choice);
        if(item instanceof Armor){
            Armor armor = (Armor) item;
            player.wearArmor(armor);
        }
        if(item instanceof Weapon){
            Weapon weapon = (Weapon) item;
            player.takeWeapon(weapon);
        }
        if(item instanceof Potion){
            Potion potion = (Potion) item;
            player.takePotion(potion);
        }
    }

    @Override
    public String getCommand() {
        return "take";
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
