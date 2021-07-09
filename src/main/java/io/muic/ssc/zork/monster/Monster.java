package io.muic.ssc.zork.monster;

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
    protected boolean alive;

    public void initialize(){
        this.isAttacked = false;
        this.setAlive(true);
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

    public void recieveDamage(int damageRecieve){
        this.hp -= damageRecieve;
        this.setAttacked(true);
        if(this.hp < 0){
            this.setDead();
        }
    }

    private void setDead() {
        alive = false;
    }
    private void setAlive(boolean alive){this.alive = alive;}
    public boolean isAlive(){
        return this.alive;
    }

    private void setAttacked(boolean isAttacked){
        this.isAttacked = isAttacked;
    }
    public void attackPlayer(){
        if(this.isAttacked == true){
            //attack back to player

        }
    }

}

