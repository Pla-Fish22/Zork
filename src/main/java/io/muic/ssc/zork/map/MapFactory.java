package io.muic.ssc.zork.map;

import io.muic.ssc.zork.command.*;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.Map;

public class MapFactory {

        private static final List<Class<?>> REGISTERED_MAPS = Arrays.asList(MysteryCastleMap.class,
                WizardSchoolMap.class, AncientPrisonMap.class);

        private static final Map<String, GameMap> MAP_MAP = new HashMap<>();

        static {
            {
                for (Class<?> mapClass : REGISTERED_MAPS) {
                    try {
                        GameMap map = (GameMap) mapClass.getDeclaredConstructor().newInstance();
                        MAP_MAP.put(map.getMapName(), map);
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public static GameMap get(String map) {
            if(MAP_MAP.containsKey(map.toLowerCase(Locale.ROOT))){
                return MAP_MAP.get(map.toLowerCase(Locale.ROOT));
            }
            return null;
        }

    }
