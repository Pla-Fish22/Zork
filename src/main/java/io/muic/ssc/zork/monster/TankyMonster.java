package io.muic.ssc.zork.monster;

import java.util.List;
import java.util.Random;

public class TankyMonster extends Monster{



    public void initialize() {
        super.initialize();
        List<String> tankyNames = List.of("Axe", "Sven", "Elder Titan", "Tidehunter");
        Random random = new Random();
        this.hp = random.nextInt(1000 - 650) + 650;
        this.name = tankyNames.get(random.nextInt(tankyNames.size()));
        this.damage = random.nextInt(270-120) + 120;
    }

}
