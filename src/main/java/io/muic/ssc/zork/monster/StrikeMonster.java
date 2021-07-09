package io.muic.ssc.zork.monster;

import java.util.List;
import java.util.Random;

public class StrikeMonster extends Monster{




    public void initialize() {
        super.initialize();
        List<String> strikeNames = List.of("Necrophos", "Faceless Void", "Rek sai", "Razor");
        Random random = new Random();
        this.hp = random.nextInt(500 - 250) + 250;
        this.name = strikeNames.get(random.nextInt(strikeNames.size()));
        this.damage = random.nextInt(450 - 250) + 250;
    }
}
