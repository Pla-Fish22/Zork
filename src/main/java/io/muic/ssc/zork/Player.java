package io.muic.ssc.zork;

import io.muic.ssc.zork.Item.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Player {

    private int currentHP, fullHP, damage, defense;
    private Map<String, Weapon> weaponHolster;
    private Map<String, Potion> potionBag;
    private Armor armor;
    private boolean isArmed;

    public Player(){
        this.fullHP = 1650;
        this.currentHP = 1650;
        this.damage = 70;
        this.defense = 0;
        this.weaponHolster = new HashMap<>();
        this.potionBag = new HashMap<>();
        this.isArmed = false;
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

    public void usePotion(String potionName){
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
}
