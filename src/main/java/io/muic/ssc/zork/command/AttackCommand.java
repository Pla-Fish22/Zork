package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.GameOutput;
import io.muic.ssc.zork.Player;
import io.muic.ssc.zork.map.Room;
import io.muic.ssc.zork.monster.Monster;

public class AttackCommand implements Command{

    @Override
    public int wordCount() {
        return 0;
    }

    @Override
    public void commandExecute(Game game, GameOutput gameOutput, Room room, Player player, String secondStatement) {
        if(game.isPlay()){
            if(room.monsterisAlive() && secondStatement != null) {
                Monster monster = room.getMonster();
                gameOutput.println("attacking " + monster.getName() +" with");
                monster.recieveDamage(player.getDamage());
            }
            if(room.monsterisAlive() && secondStatement == null){
                Monster monster = room.getMonster();
                monster.recieveDamage(player.getDamage());
                player.recieveDamage(monster.getDamage());
                gameOutput.println("Attacking " + monster.getName()
                                                +" with your fist, doing "
                                                + player.getDamage()
                                                + " Damage \n" + monster.getName() +  " HP: "
                                                + monster.getCurrentHP() + "/" + monster.getFullHP()
                                                + "\n" + monster.getName() + " attack back doing "
                                                + monster.getDamage() + " Damage"
                                                + "\nHP: " + player.getCurrentHP() + "/" + player.getFullHP());
            }

        }
    }

    @Override
    public String getCommand() {
        return "attack";
    }
}
