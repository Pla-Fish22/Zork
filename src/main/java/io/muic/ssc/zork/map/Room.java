package io.muic.ssc.zork.map;

import io.muic.ssc.zork.monster.Monster;
import io.muic.ssc.zork.monster.StrikeMonster;
import io.muic.ssc.zork.monster.TankyMonster;

import java.util.Random;

public class Room {
    private Monster monster;
    private Random random = new Random();

    public Room(){
        System.out.println("yeet");
        if(random.nextBoolean()){
            System.out.println("ya");
            monster = StrikeMonster
        }
        else{
            System.out.println("ye");
            monster = new StrikeMonster();
        }
        System.out.println(monster.getName() + monster.getDamage());
    }

    public Monster getMonster() {
        return monster;
    }
}
