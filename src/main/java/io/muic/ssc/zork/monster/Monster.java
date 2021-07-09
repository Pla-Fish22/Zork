package io.muic.ssc.zork.monster;

import io.muic.ssc.zork.Player;

public class Monster {

    //protected Room room;
    //Full hp of monster
    protected int fullHP;
    //current hp of monster
    protected int currentHP;
    //damage of monster
    protected int damage;
    //name of monster
    protected String name;
    //is alive
    protected boolean alive;

    public void initialize(){
        this.setAlive(true);
    }

    public String getName(){
        return this.name;
    }

    public int getFullHP(){
        return this.fullHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getDamage(){
        return this.damage;
    }

    public void recieveDamage(int damageRecieve){
        this.currentHP -= damageRecieve;
        if(this.currentHP < 0){
            this.setDead();
            return;
        }
    }

    private void setDead() {
        alive = false;
    }
    private void setAlive(boolean alive){this.alive = alive;}
    public boolean isAlive(){
        return this.alive;
    }

}

