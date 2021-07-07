package io.muic.ssc.zork;

import java.util.List;
import java.util.Scanner;

public class Game {

    private GameOutput gameOutput = new GameOutput();

    private CommandParser commandParser = new CommandParser();

    public void run(){
        while(true){
            Scanner inputReader = new Scanner(System.in);
            String input = inputReader.nextLine();
            List<String> splittedInput = commandParser.parse(input);
            gameOutput.println(input);
        }
    }

    public void exit(){
        gameOutput.println("Exiting game");
        System.exit(0);
    }
}
