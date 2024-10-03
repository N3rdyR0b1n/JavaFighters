package main.Creatures;

import Creature;

public class BrawlerGuy extends Creature {
    private  String STAND = "brawler.png";
    private static String SELECTED = "";
    private String pose = STAND;

    public BrawlerGuy(String name) {
        super(name, 45, "fist/");
    }

    @Override
    public String getImageSource() {
        return super.getImageSource() + pose;
    }

}
