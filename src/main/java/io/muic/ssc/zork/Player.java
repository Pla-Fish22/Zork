package io.muic.ssc.zork;

import io.muic.ssc.zork.map.Map;
import io.muic.ssc.zork.map.Room;
import io.muic.ssc.zork.monster.Monster;

public class Player {

    private int hp, damage, defense;

    public Player(){
        this.hp = 1650;
        this.damage = 150;
        this.defense = 100;
    }

    public int getDamage() {
        return damage;
    }
}
