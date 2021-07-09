package io.muic.ssc.zork.Item;

public enum ItemType {

    ARMOR(Armor.class),
    POTION(Potion.class),
    WEAPON(Weapon.class);

    private Class itemClass;

    ItemType(Class itemClass) {
        this.itemClass = itemClass;
    }

    public Class getItemClass() {
        return itemClass;
    }
}
