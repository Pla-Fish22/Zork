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

    public boolean isPlay = false;

    public Room room;

    public void run(){
        while(true){
            Scanner inputReader = new Scanner(System.in);
            String input = inputReader.nextLine().toLowerCase(Locale.ROOT);
            List<String> splittedInput = commandParser.parse(input);
            CommandFactory.get(input).commandExecute(this,gameOutput);
        }
    }

    public void exit(){
        gameOutput.println("Exiting game");
        System.exit(0);
    }

}
