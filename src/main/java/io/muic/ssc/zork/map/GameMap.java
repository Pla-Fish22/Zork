package io.muic.ssc.zork.map;


public interface GameMap {


    String getMapName();

    Room enterRoom(String direction);

    GameMap getRoomMap();

    Room getDefault();


}
