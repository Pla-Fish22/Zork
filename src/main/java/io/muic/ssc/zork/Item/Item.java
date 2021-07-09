package io.muic.ssc.zork.Item;

import java.util.Random;

public class Item {

    protected String name;

    protected Random random = new Random();

    public void initialize() {
    }

    public String getName(){
        return name;
    }

}
