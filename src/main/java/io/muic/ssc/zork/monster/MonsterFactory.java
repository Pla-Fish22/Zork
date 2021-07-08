package io.muic.ssc.zork.monster;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class MonsterFactory {

    private static Map<MonsterType, Class> monsterTypeClassMap = new HashMap<>() {{
        MonsterType[] monsterTypes = MonsterType.values();
        for (int idx = 0; idx < monsterTypes.length; idx++) {
            put(monsterTypes[idx], monsterTypes[idx].getMonsterClass());
        }
    }};

    public static Monster createMonster(MonsterType monsterType) {
        Class monsterClass = monsterTypeClassMap.get(monsterType);
        return createMonster(monsterClass);
    }

    public static Monster createMonster(Class monsterClass) {
        if (monsterClass != null) {
            try {
                Monster monster = (Monster) monsterClass.getDeclaredConstructor().newInstance();
                monster.initialize();
                return monster;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        throw new IllegalArgumentException("Unknown monsterType");
    }

}
