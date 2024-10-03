package Creatures;


import GameStuff.Creature;

public class BrawlerGuy extends Creature {
    private  String STAND = "brawler.png";
    private static String SELECTED = "";
    private String pose = STAND;

    public BrawlerGuy(String name) {
        super(name, 65, "fist/");
    }

    @Override
    public String getImageSource() {
        return super.getImageSource() + pose;
    }


}
