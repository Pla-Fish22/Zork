package io.muic.ssc.zork;

import java.util.List;

public class CommandParser {

    /*
        commands like attack with {weapon} needs to be split in to three while others can be in two words
        sol: check which type of command the input commands fall into
     */


    public List<String> parse(String inputLine){
        List<String> strings = List.of(inputLine.split(" ")); // split into Array and forced into list
        return strings;
    }

}
