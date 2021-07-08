package io.muic.ssc.zork.monster;

import java.util.List;

public class TankyMonster extends Monster{

    private List<String> tankyNames = List.of("Axe", "Sven", "Elder Titan", "Tidehunter");

    @Override
    public void initialize() {
        this.hp = random.nextInt(1000 - 650) + 650;
        this.name = tankyNames.get(random.nextInt(tankyNames.size()));
        this.damage = random.nextInt(270-120) + 120;
        System.out.println(this.name);
    }

}
