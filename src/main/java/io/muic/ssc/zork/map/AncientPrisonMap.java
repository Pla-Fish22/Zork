package io.muic.ssc.zork.map;

public class AncientPrisonMap implements GameMap {

    @Override
    public String getMapName() {
        return "ancient prison";
    }

    @Override
    public Room enterRoom(String direction) {
        return null;
    }

    @Override
    public GameMap getRoomMap() {
        return null;
    }

    @Override
    public Room getDefault() {
        return null;
    }

}
