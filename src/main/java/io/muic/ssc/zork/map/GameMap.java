package io.muic.ssc.zork.map;


import java.util.List;

public interface GameMap {


    String getMapName();

    void setRooms(List rooms);

    List getRooms();

    Room getDefault();


}
