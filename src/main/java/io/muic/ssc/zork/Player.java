package io.muic.ssc.zork;

import io.muic.ssc.zork.Item.*;
import io.muic.ssc.zork.map.Room;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Player {

    private int currentHP, fullHP, damage, defense;
    private Map<String, Weapon> weaponHolster;
    private Map<String, Potion> potionBag;
    private Armor armor;
    private boolean isArmed;
    private Room currentRoom;

    public Player(){
        this.fullHP = 1650;
        this.currentHP = 1650;
        this.damage = 70;
        this.defense = 0;
        this.weaponHolster = new HashMap<>();
        this.potionBag = new HashMap<>();
        this.isArmed = false;
    }


    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
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

    public int getDefense() {
        return defense;
    }

    public Armor getArmor() {
        return armor;
    }

    public void takeWeapon(Weapon weapon){
        weaponHolster.put(weapon.getName(), weapon);
    }

    public void takePotion(Potion potion){ potionBag.put(potion.getName(), potion);}

    public Potion usePotion(String potionName){
        Potion potion = potionBag.get(potionName);
        potionBag.remove(potionName);
        this.currentHP = this.currentHP + potion.getHpRestore() < this.fullHP ? this.currentHP + potion.getHpRestore() :
                                                                  this.fullHP;
        return potion;
    }

    public void wearArmor(Armor armor){
        this.armor = armor;
        this.defense = armor.getDefense();
        this.isArmed = true;
    }

    public int getFinalDamage(int damage){
        return damage - this.defense > 0 ? damage - this.defense : 0 ;
    }

    public void recieveDamage(int damage){
        int finalDamage = getFinalDamage(damage);
        if(finalDamage > 0){
            this.currentHP -= finalDamage;
        }
    }

    public Weapon getWeapon(String weapon){
        return weaponHolster.get(weapon);
    }

    public Map<String, Weapon> getWeaponHolster() {
        return weaponHolster;
    }

    public void setWeaponHolster(Map<String, Weapon> weaponHolster) {
        this.weaponHolster = weaponHolster;
    }

    public Map<String, Potion> getPotionBag() {
        return potionBag;
    }

    public void setPotionBag(Map<String, Potion> potionBag) {
        this.potionBag = potionBag;
    }

    public String getWeaponsDetail(){
        StringBuilder weaponHolsterDetails = new StringBuilder();
        if(!weaponHolster.isEmpty()){
            weaponHolsterDetails.append("Weapons:\n");
            Set<String> weapons = weaponHolster.keySet();
            for(String weapon: weapons){
                weaponHolsterDetails.append("  ");
                weaponHolsterDetails.append(weapon);
                weaponHolsterDetails.append(" Damage: ");
                weaponHolsterDetails.append(weaponHolster.get(weapon).getDamage());
                weaponHolsterDetails.append("\n");
            }
        }
        return weaponHolsterDetails.toString();
    }

    public String getPotionsDetail(){
        StringBuilder potionBagDetails = new StringBuilder();
        if(!potionBag.isEmpty()){
            potionBagDetails.append("Potions:\n");
            Set<String> potions = potionBag.keySet();
            for(String potion: potions){
                potionBagDetails.append("  ");
                potionBagDetails.append(potion);
                potionBagDetails.append("\n        HPrestore: ");
                potionBagDetails.append(potionBag.get(potion).getHpRestore());
                potionBagDetails.append("\n");
            }
        }
        return potionBagDetails.toString();
    }

    public String getPlayerDetails(){
        StringBuilder playerDetails = new StringBuilder();
        playerDetails.append("Stat: ");
        playerDetails.append(getCurrentHP());
        playerDetails.append("/");
        playerDetails.append(getFullHP());
        playerDetails.append("\nDamage: ");
        playerDetails.append(getDamage());
        playerDetails.append("\nDefense: ");
        playerDetails.append(getDefense());
        if (isArmed) {
            playerDetails.append("\nArmor: ");
            playerDetails.append(getArmor().getName());
        }
        return playerDetails.toString();
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setArmed(boolean armed) {
        isArmed = armed;
    }

    public boolean isArmed() {
        return isArmed;
    }

    public void heal(){
        currentHP = currentHP + 50 < fullHP ? currentHP + 50 : fullHP;
    }
}

