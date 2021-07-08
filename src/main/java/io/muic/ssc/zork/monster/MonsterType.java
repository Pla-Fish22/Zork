package io.muic.ssc.zork.monster;

public enum MonsterType {

    TANKYMONSTER(TankyMonster.class),
    STRIKEMONSTER(StrikeMonster.class);

    private Class monsterClass;

    MonsterType(Class monsterClass){
        this.monsterClass = monsterClass;
    }

    public Class getMonsterClass() {
        return monsterClass;
    }
}
