package io.muic.ssc.zork;

public class Commands {

    private String command;

    public void checkCommand(String commandline){
        switch (commandline){

            case "info":
                //print player's stats and room in.
            case "take":
                //pick items in current room
            case "drop":
                //drop item of choice
            case "attack with":
                //attack a monster in room
            case "go":
                //move player to the room
            case "help":
                //print all commands
            case "quit":
                //end the current game and return to command prompt to let user choose the map or load from saved point again.
            case "play":
                //play new game
            case "load":
                //load game state (start the game)
            case "save":
                //save game state
            case "exit":
                //exit whole game (start the game)
        }
    }
}