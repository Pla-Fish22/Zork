package io.muic.ssc.zork.Item;

import java.util.List;

public class Potion extends Item{
    private int hpRestore;


    public void initialize(){
        setHpRestore();
        this.name = "Potion";
    }

    private void setHpRestore(){this.hpRestore = random.nextInt(300 - 100) + 100;}

    public int getHpRestore() {
        return hpRestore;
    }
}
