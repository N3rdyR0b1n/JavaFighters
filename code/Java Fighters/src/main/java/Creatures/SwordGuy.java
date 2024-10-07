package Creatures;


import GameStuff.Arena;
import GameStuff.Creature;

public class SwordGuy extends Creature {
    private static String STAND = "sword_guy.png";
    private static String SELECTED = "";
    private String pose = STAND;

    public SwordGuy(String name) {
        super(name, 45, "sword/");
    }

    @Override
    public String getImageSource() {
        return super.getImageSource() + pose;
    }


}
