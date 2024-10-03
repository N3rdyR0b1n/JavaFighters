package main.Creatures;

import Creature;

public class GunGuy extends Creature {
    private  String STAND = "cowboy.png";
    private static String SELECTED = "";
    private String pose = STAND;

    public GunGuy(String name) {
        super(name, 45, "gun/");
    }

    @Override
    public String getImageSource() {
        return super.getImageSource() + pose;
    }

    public GunGuy(String name, int hp, String fileName) {
        super(name, hp, fileName);
    }
}
