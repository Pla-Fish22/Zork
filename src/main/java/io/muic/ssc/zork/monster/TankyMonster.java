package io.muic.ssc.zork.monster;

import java.util.List;
import java.util.Random;

public class TankyMonster extends Monster{



    public void initialize() {
        super.initialize();
        List<String> tankyNames = List.of("Axe", "Sven", "Elder Titan", "Tidehunter");
        Random random = new Random();
        this.fullHP = random.nextInt(1000 - 650) + 650;
        this.currentHP = this.fullHP;
        this.name = tankyNames.get(random.nextInt(tankyNames.size()));
        this.damage = random.nextInt(400 - 150) + 150;
    }

}
