package Creatures;

import Abilities.custom.ShootAttackAbility;
import GameStuff.Arena;
import GameStuff.Creature;

public class GunGuy extends Creature {
    private static String STAND = "cowboy.png";
    private static String SELECTED = "cowboy_turn.png";
    private String pose = STAND;

    public GunGuy(String name) {
        super(name, 35, "gun/");
        attacks.add(new ShootAttackAbility());

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
