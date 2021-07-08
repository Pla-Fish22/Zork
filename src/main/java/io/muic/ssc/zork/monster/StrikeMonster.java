package io.muic.ssc.zork.monster;

import java.util.List;

public class StrikeMonster extends Monster{

    private List<String> strikeNames = List.of("Necrophos", "Faceless Void", "Rek sai", "Razor");

    @Override
    public void initialize() {
        this.hp = random.nextInt(500 - 250) + 250;
        this.name = strikeNames.get(random.nextInt(strikeNames.size()));
        this.damage = random.nextInt(450 - 250) + 250;
        System.out.println(this.name);
    }
}
