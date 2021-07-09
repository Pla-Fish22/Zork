package io.muic.ssc.zork;

import io.muic.ssc.zork.map.Room;

public class GameOutput {

    private StringBuilder stringBuilder;

    public void println(String message){
        System.out.println(message);
    }
    public void printWelcome(){
        stringBuilder = new StringBuilder();
        stringBuilder.append("\n" +
                "__________            __    \n" +
                "\\____    /___________|  | __\n" +
                "  /     //  _ \\_  __ \\  |/ /\n" +
                " /     /(  <_> )  | \\/    < \n" +
                "/_______ \\____/|__|  |__|_ \\\n" +
                "        \\/                \\/\n");
        stringBuilder.append("Welcome To Zork!\n");
        println(stringBuilder.toString());
    }
    public void printNotInGameCommands(){
        stringBuilder = new StringBuilder();
        stringBuilder.append("These are the commands:\n");
        stringBuilder.append("      -help: print all commands\n");
        stringBuilder.append("      -play {map-name}: play new game, without the map-name the game will start with default map\n");
        stringBuilder.append("      -load {saved-point-name}: load game state from saved-point-name\n");
        stringBuilder.append("      -exit: exit the whole game all Process will be loss (We ain't saving for you)\n");
        println(stringBuilder.toString());
    }
    public void printInGameCommands(){
        stringBuilder = new StringBuilder();
        stringBuilder.append("These are the commands:\n");
        stringBuilder.append("      -help: print all commands\n");
        stringBuilder.append("      -info: provide information of you and the room you are in\n");
        stringBuilder.append("      -drop: drop the item of your choice\n");
        stringBuilder.append("      -attack with: attack the monster in the current room with weapon of your choice if you dont have weapon then you be using fist\n");
        stringBuilder.append("      -go {direction}: move to the room in specific direction\n");
        stringBuilder.append("      -save {saved-point-name}: save current game state\n");
        stringBuilder.append("      -quit: quit the game your unsaved progress will be loss\n");
        println(stringBuilder.toString());
    }
    public void printRoomDetails(Room room){
        println(room.getItemsDetail());
        if(room.monsterisAlive()){
            println(room.getMonsterDetails());
        }
    }

}
