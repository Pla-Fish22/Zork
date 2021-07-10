package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.GameOutput;
import io.muic.ssc.zork.Item.Weapon;
import io.muic.ssc.zork.Player;
import io.muic.ssc.zork.map.Room;
import io.muic.ssc.zork.monster.Monster;

import java.util.List;

public class AttackCommand implements Command{

    @Override
    public int wordCount(List<String> statements) {
        return 0;
    }

    @Override
    public void commandExecute(Game game, GameOutput gameOutput, Room room, Player player, List<String> statements) {
        if(game.isPlay()){
            if(room.monsterisAlive() && statements.contains("with")) {
                Monster monster = room.getMonster();
                String weaponName = makeSubject(statements.subList(2, statements.size()));
                Weapon weapon = player.getWeapon(weaponName);
                monster.recieveDamage(weapon.getDamage());
                player.recieveDamage(monster.getDamage());
                gameOutput.battlingStatus(player, monster, weapon);
                return;
            }
            if(room.monsterisAlive() && !statements.contains("with")){
                Monster monster = room.getMonster();
                monster.recieveDamage(player.getDamage());
                player.recieveDamage(monster.getDamage());
                gameOutput.battlingStatus(player, monster);
                return;
            }

        }
    }

    @Override
    public String getCommand() {
        return "attack";
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
