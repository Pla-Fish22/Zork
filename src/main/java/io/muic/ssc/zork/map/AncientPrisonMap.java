package io.muic.ssc.zork.map;

import java.util.List;

public class AncientPrisonMap implements GameMap {

    private List<Room> rooms;

    public AncientPrisonMap(){
        Room prison1, prison3, damnedPrison, guardRoom, privatePrison, prison8, prison4, library, bathRoom;

        prison1 = new Room("Prison No.1");
        prison3 = new Room("Prison No.3");
        damnedPrison = new Room("Damned Prison");
        guardRoom = new Room("Guard's Room");
        privatePrison = new Room("Private Prison");
        prison8 = new Room("Prison No.8");
        prison4 = new Room("Prison No.4");
        library = new Room("Library");
        bathRoom = new Room("BathRoom");

        prison1.setExits("north", guardRoom);
        prison1.setExits("west", prison3);
        prison1.setExits("east", damnedPrison);
        prison1.setExits("south", privatePrison);

        guardRoom.setExits("west", prison8);
        guardRoom.setExits("east", library);

        prison3.setExits("north", prison8);
        prison3.setExits("south", prison4);

        privatePrison.setExits("west", prison4);
        privatePrison.setExits("east", bathRoom);

        damnedPrison.setExits("north", library);
        damnedPrison.setExits("south", bathRoom);

        rooms = List.of(prison1, prison3, damnedPrison, guardRoom, privatePrison, prison8, prison4, library, bathRoom);
    }

    @Override
    public String getMapName() {
        return "ancient prison";
    }

    @Override
    public void setRooms(List rooms) {
        this.rooms = rooms;
    }

    @Override
    public List getRooms() {
        return rooms;
    }


    @Override
    public Room getDefault() {
        return rooms.get(0);
    }

}
