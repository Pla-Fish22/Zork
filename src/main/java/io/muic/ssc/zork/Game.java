package io.muic.ssc.zork;

import java.util.*;

import io.muic.ssc.zork.command.*;
import io.muic.ssc.zork.map.GameMap;

public class Game {

    private GameOutput gameOutput = new GameOutput();

    private CommandParser commandParser = new CommandParser();

    private Command command;

    private boolean play = false;

    private Player player = new Player();

    private GameMap map;

    private Map<String, SaveGame> saveGameHashMap;

    public void run(){
        gameOutput.printWelcome();
        saveGameHashMap = new HashMap<>();
        while(true){
            Scanner inputReader = new Scanner(System.in);
            String input = inputReader.nextLine();
            List<String> splittedInput = commandParser.parse(input);
            try {
                CommandFactory.get(splittedInput)
                              .commandExecute(this, gameOutput, map, player,splittedInput);
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

    public void saveGame(String saveName){
        SaveGame save = new SaveGame(map, player);
        saveGameHashMap.put(saveName, save);
    }

    public void loadGame(String savename){
        player = saveGameHashMap.get(savename).getPlayer();
        map = saveGameHashMap.get(savename).getMap();
        gameOutput.printGameStart(map, player);
    }

    public void setMap(GameMap map){
        this.map = map;
    }

}
