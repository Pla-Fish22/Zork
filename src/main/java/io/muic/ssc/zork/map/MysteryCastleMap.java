package io.muic.ssc.zork.map;

import java.util.List;

public class MysteryCastleMap implements GameMap {

    private List<Room> rooms;

    public MysteryCastleMap() {
        Room mainHall, kitchen, hallWay, bedroom, garden, balcony, fountain, spookyRoom, trainingArea;

        mainHall = new Room("Main Hall");
        kitchen = new Room("Kitchen");
        hallWay = new Room("Hall Way");
        bedroom = new Room("Bedroom");
        garden = new Room("Garden");
        balcony = new Room("Balcony");
        fountain = new Room("Fountain");
        spookyRoom = new Room("Spooky Room");
        trainingArea = new Room("Training Area");

        mainHall.setExits("north", bedroom);
        mainHall.setExits("west", kitchen);
        mainHall.setExits("east", hallWay);
        mainHall.setExits("south", garden);

        bedroom.setExits("west", balcony);
        bedroom.setExits("east", spookyRoom);

        kitchen.setExits("north", balcony);
        kitchen.setExits("south", fountain);

        garden.setExits("west", fountain);
        garden.setExits("east", trainingArea);

        hallWay.setExits("north", spookyRoom);
        hallWay.setExits("south", trainingArea);

        rooms = List.of(mainHall, kitchen, hallWay, bedroom, garden, balcony, fountain, spookyRoom, trainingArea);

    }

    @Override
    public String getMapName() {
        return "mystery castle";
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
        return rooms.get(0);
    }


}
