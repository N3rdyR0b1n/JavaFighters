package Creatures;


import GameStuff.Arena;
import GameStuff.Creature;

public class BrawlerGuy extends Creature {
    private  String STAND = "brawler.png";
    private static String SELECTED = "brawler_turn.png";
    private String pose = STAND;

    public BrawlerGuy(String name) {
        super(name, 65, "fist/");
    }

    @Override
    public String getImageSource() {
        return super.getImageSource() + pose;
    }

    @Override
    public void onTurn(Arena arena) {
        super.onTurn(arena);
        pose = SELECTED;
    }
    public void endTurn(Arena arena) {
        super.endTurn(arena);
        pose = STAND;
    }



}
