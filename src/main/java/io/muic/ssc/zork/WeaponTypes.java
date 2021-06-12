package io.muic.ssc.zork;

public enum WeaponTypes {

    SWORD(Sword.class, 10),
    SPEAR(Spear.class, 12),
    BOW(Bow.class, 7);

    private Class weaponClass;
    private int damage;

    WeaponTypes(Class weaponClass, int damage){
        this.weaponClass = weaponClass;
        this.damage = damage;

    };

}
