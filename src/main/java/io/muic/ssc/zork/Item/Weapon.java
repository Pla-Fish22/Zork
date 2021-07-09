package io.muic.ssc.zork.Item;

import java.util.List;

public class Weapon extends Item{
    private int damage;


    public void initialize(){
        setDefense();
        setName();
    }

    private void setDefense(){this.damage = random.nextInt( 750 - 100) + 100;}
    private void setName(){
        List<String> weaponNames = List.of("Mjolnir" , "Desolator" , "Dagon", "Monkey King Bar");
        this.name = weaponNames.get(random.nextInt(weaponNames.size()));
    }

    public int getDamage() {
        return damage;
    }
}
