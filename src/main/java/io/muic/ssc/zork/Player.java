package io.muic.ssc.zork;

import io.muic.ssc.zork.map.Map;
import io.muic.ssc.zork.map.Room;
import io.muic.ssc.zork.monster.Monster;

public class Player {

    private int currentHP, fullHP, damage, defense;

    public Player(){
        this.fullHP = 1650;
        this.currentHP = 1650;
        this.damage = 70;
        this.defense = 0;
    }


    public int getDamage() {
        return damage;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getFullHP() {
        return fullHP;
    }

    public void recieveDamage(int damage){
        int finalDamage = damage - this.defense;
        this.currentHP -= finalDamage;
    }
}
