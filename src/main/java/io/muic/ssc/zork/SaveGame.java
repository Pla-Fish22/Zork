package io.muic.ssc.zork;

import io.muic.ssc.zork.Player;
import io.muic.ssc.zork.map.GameMap;
import io.muic.ssc.zork.map.MapFactory;

import java.io.Serializable;


public class SaveGame implements Serializable {

    private GameMap map;
    private Player player;

    public SaveGame(GameMap map, Player player){
        this.player = new Player();
        this.player.setCurrentRoom(player.getCurrentRoom());
        this.player.setCurrentHP(player.getCurrentHP());
        if(player.isArmed()) {
            this.player.wearArmor(player.getArmor());
        }
        this.player.setWeaponHolster(player.getWeaponHolster());
        this.player.setPotionBag(player.getPotionBag());
        this.player.setArmed(player.isArmed());

        this.map =MapFactory.get(map.getMapName());
        this.map.setRooms(map.getRooms());

    }


    public Player getPlayer(){
        return player;
    }

    public GameMap getMap(){
        return map;
    }
}
