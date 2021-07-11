package io.muic.ssc.zork.map;

import java.util.List;

public class WizardSchoolMap implements GameMap {
    private List<Room> rooms;

    public WizardSchoolMap(){
        Room mainHall, classRoom1, teacherRoom, classRoom3, dungeon, garden, classRoom2, library, fountain;

        mainHall = new Room("Main Hall");
        classRoom1 = new Room("Classroom 1");
        teacherRoom = new Room("Teacher Room");
        classRoom3 = new Room("Classroom 3");
        dungeon = new Room("Dungeon");
        garden = new Room("Garden");
        classRoom2 = new Room("Classroom 2");
        library = new Room("Library");
        fountain = new Room("Fountain");

        mainHall.setExits("north", classRoom3);
        mainHall.setExits("west", classRoom1);
        mainHall.setExits("east", teacherRoom);
        mainHall.setExits("south", dungeon);

        classRoom3.setExits("west", garden);
        classRoom3.setExits("east", library);

        classRoom1.setExits("north", garden);
        classRoom1.setExits("south", classRoom2);

        dungeon.setExits("west", classRoom2);
        dungeon.setExits("east", fountain);

        teacherRoom.setExits("north", library);
        teacherRoom.setExits("south", fountain);

        rooms = List.of(mainHall, classRoom1, teacherRoom, classRoom3, dungeon, garden, classRoom2, library, fountain);
    }

    @Override
    public String getMapName() {
        return "wizard school";
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
