package io.muic.ssc.zork.map;

import io.muic.ssc.zork.Item.*;
import io.muic.ssc.zork.monster.*;

import java.util.HashMap;
import java.util.Random;
import java.util.Map;
import java.util.Set;

public class Room {

    private Monster monster;

    private Random random = new Random();

   private Map<String, Item> stringItemMap;

    public Room(){
        spawnMonster();
        this.stringItemMap = placeItems();
    }

    public Monster getMonster() {
        return monster;
    }

    public String getMonsterDetails(){
        StringBuilder monsterDetails = new StringBuilder();
        monsterDetails.append("Monster:\n");
        monsterDetails.append("     name: ");
        monsterDetails.append(monster.getName());
        monsterDetails.append("\n     HP: ");
        monsterDetails.append(monster.getCurrentHP());
        monsterDetails.append("/");
        monsterDetails.append(monster.getFullHP());
        monsterDetails.append("\n     Damage: ");
        monsterDetails.append(monster.getDamage());
        monsterDetails.append("\n");
        return monsterDetails.toString();
    }

    public String getItemsDetail(){
        StringBuilder itemsDetail = new StringBuilder();
        Set<String> itemNames = stringItemMap.keySet();
        itemsDetail.append("Items:\n");
        for(String itemName : itemNames){
            Item item = stringItemMap.get(itemName);
            itemsDetail.append("     name: ");
            if(item instanceof Potion){
                Potion potion = (Potion) item;
                itemsDetail.append(potion.getName());
                itemsDetail.append(" Type: Potion");
                itemsDetail.append(" HPrestore: ");
                itemsDetail.append(potion.getHpRestore());
            }
            if(item instanceof Weapon){
                Weapon weapon = (Weapon) item;
                itemsDetail.append(weapon.getName());
                itemsDetail.append(" Type: Weapon");
                itemsDetail.append(" Damage: ");
                itemsDetail.append(weapon.getDamage());
            }
            if(item instanceof Armor){
                Armor armor = (Armor) item;
                itemsDetail.append(armor.getName());
                itemsDetail.append(" Type: Armor");
                itemsDetail.append(" Defense: ");
                itemsDetail.append(armor.getDefense());
            }
            itemsDetail.append("\n");
        }
        return itemsDetail.toString();
    }

    public boolean monsterisAlive(){return monster.isAlive();}
    private void spawnMonster(){
        if(random.nextBoolean()){
            monster = MonsterFactory.createMonster(MonsterType.STRIKEMONSTER);
        }
        monster = MonsterFactory.createMonster(MonsterType.TANKYMONSTER);
    }
    private Map placeItems(){
        int numberOfItems = random.nextInt(4 - 1) + 5;
        Map<String, Item> stringItemMap = new HashMap<>();
        ItemType[] itemTypes = ItemType.values();
        for(int idx = 0; idx < numberOfItems; idx++){
            Item item = ItemFactory.createItem(itemTypes[random.nextInt(itemTypes.length)]);
            String itemName = item.getName();
            stringItemMap.put(itemName, item);
        }
        return stringItemMap;


    }
    public Item takeItem(String itemName){
        Item item = stringItemMap.get(itemName);
        stringItemMap.remove(itemName);
        return item;
    }
}
