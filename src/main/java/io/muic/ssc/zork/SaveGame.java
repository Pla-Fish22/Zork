package io.muic.ssc.zork;

import io.muic.ssc.zork.Player;
import io.muic.ssc.zork.map.GameMap;

import java.io.Serializable;


public class SaveGame implements Serializable {

    private GameMap map;
    private Player player;

    public SaveGame(GameMap map, Player player){
        this.map = map;
        this.player = player;
    }

    public Player getPlayer(){
        return player;
    }

    public GameMap getMap(){
        return map;
    }
}
