package io.muic.ssc.zork;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import io.muic.ssc.zork.command.*;
import io.muic.ssc.zork.map.Room;

public class Game {

    private GameOutput gameOutput = new GameOutput();

    private CommandParser commandParser = new CommandParser();

    private Command command;

    private boolean play = false;

    public Room room;

    private Player player = new Player();

    public void run(){
        while(true){
            Scanner inputReader = new Scanner(System.in);
            String input = inputReader.nextLine().toLowerCase(Locale.ROOT);
            List<String> splittedInput = commandParser.parse(input);
            try {
                if(commandParser.hasSecondStatement(splittedInput)){
                    CommandFactory.get(splittedInput)
                            .commandExecute(this, gameOutput, room, player,splittedInput.get(1));
                }
                else{
                    CommandFactory.get(splittedInput)
                            .commandExecute(this, gameOutput, room, player,null);
                }
            } catch (NullPointerException nullPointerException) {
                gameOutput.println("No such Command");
            }
        }
    }

    public void exit(){
        gameOutput.println("Exiting game");
        System.exit(0);
    }

    public boolean isPlay(){
        return play;
    }

    public void switchPlay(){
        play = !play; //switching in one place
    }

}
