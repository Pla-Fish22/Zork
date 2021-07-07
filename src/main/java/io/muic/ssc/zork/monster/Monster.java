package io.muic.ssc.zork.monster;

import java.util.List;
import java.util.Random;

public class Monster {

    //protected Room room;
    //hp of monster
    protected int hp;
    //damage of monster
    protected int damage;
    //name of monster
    protected String name;
    //is attacked
    private boolean isAttacked;
    //is alive
    protected boolean isAlive;

    protected Random random = new Random();

    public void initialize(){
        this.isAlive = true;
        this.isAttacked = false;
    }

    public String getName(){
        return this.name;
    }

    public int getHp(){
        return this.hp;
    }

    public int getDamage(){
        return this.damage;
    }

    public void setDead() {
        isAlive = false;
    }
    public void setAttacked(boolean isAttacked){
        this.isAttacked = isAttacked;
    }
    public void attackPlayer(){
        if(this.isAttacked == true){
            //attack back to player

        }
    }

}

