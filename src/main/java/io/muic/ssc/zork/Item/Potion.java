package io.muic.ssc.zork.Item;

import java.util.List;

public class Potion extends Item{
    private int hpRestore;

    public void initialize(){
        setHpRestore();
        setName();
    }

    private void setHpRestore(){this.hpRestore = random.nextInt(300 - 100) + 100;}

    public int getHpRestore() {
        return hpRestore;
    }

    private void setName(){
        List<String> potionNames = List.of("Elixir", "Holy Water", "Potion");
        this.name = potionNames.get(random.nextInt(potionNames.size()));
    }
}
