package io.muic.ssc.zork.Item;

import java.util.List;
import java.util.Random;

public class Armor extends Item{

    private int defense;


    public void initialize(){
        setDefense();
        setName();
    }

    private void setDefense(){this.defense = random.nextInt(500 - 150) + 150;}
    private void setName(){
        List<String> armorNames = List.of("Solar Crest" , "Blade Mail" , "Power Thread");
        this.name = armorNames.get(random.nextInt(armorNames.size()));
    }

    public int getDefense() {
        return defense;
    }
}
