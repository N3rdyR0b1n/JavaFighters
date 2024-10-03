package Creatures;

import Abilities.custom.ShootAttackAbility;
import GameStuff.Creature;

public class GunGuy extends Creature {
    private  String STAND = "cowboy.png";
    private static String SELECTED = "";
    private String pose = STAND;

    public GunGuy(String name) {
        super(name, 35, "gun/");
        attacks.add(new ShootAttackAbility());

    }

    @Override
    public String getImageSource() {
        return super.getImageSource() + pose;
    }

    public GunGuy(String name, int hp, String fileName) {
        super(name, hp, fileName);
    }
}
