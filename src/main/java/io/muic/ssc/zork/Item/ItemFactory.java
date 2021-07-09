package io.muic.ssc.zork.Item;

import io.muic.ssc.zork.monster.Monster;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ItemFactory {

    private static Map<ItemType, Class> itemTypeClassMap = new HashMap<>() {{
        ItemType[] itemTypes = ItemType.values();
        for (int idx = 0; idx < itemTypes.length; idx++) {
            put(itemTypes[idx], itemTypes[idx].getItemClass());
        }
    }};

    public static Item createItem(ItemType itemType) {
        Class itemClass = itemTypeClassMap.get(itemType);
        return createItem(itemClass);
    }

    public static Item createItem(Class itemClass) {
        if (itemClass != null) {
            try {
                Item item = (Item) itemClass.getDeclaredConstructor().newInstance();
                item.initialize();
                return item;
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
