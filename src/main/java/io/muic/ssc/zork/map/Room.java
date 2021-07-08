package io.muic.ssc.zork.map;

import io.muic.ssc.zork.monster.*;

import java.util.Random;

public class Room {

    private Monster monster;

    private Random random = new Random();

    public Room(){
        if(random.nextBoolean()){
           monster = MonsterFactory.createMonster(MonsterType.STRIKEMONSTER);
        }
           monster = MonsterFactory.createMonster(MonsterType.TANKYMONSTER);
    }

    public Monster getMonster() {
        return monster;
    }
    public boolean monsterisAlive(){return monster.isAlive();}
}
