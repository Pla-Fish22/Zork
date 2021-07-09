package io.muic.ssc.zork;

import io.muic.ssc.zork.map.Room;

public class GameOutput {

    public void println(String message){
        System.out.println(message);
    }



    public void printRoomDetails(Room room){
        println(room.getRoomDetails());
    }

}
