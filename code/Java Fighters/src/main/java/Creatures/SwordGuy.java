package Creatures;


import GameStuff.Arena;
import GameStuff.Creature;

public class SwordGuy extends Creature {
    private static String STAND = "sword_guy.png";
    private static String SELECTED = "sword_turn.png";
    private String pose = STAND;

    public SwordGuy(String name) {
        super(name, 45, "sword/");
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
    @Override
    public void endTurn(Arena arena) {
        super.endTurn(arena);
        pose = STAND;
    }

}
