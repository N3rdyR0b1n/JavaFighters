package Creatures;

import Abilities.custom.Cowboy.QuickDrawAttackAbility;
import Abilities.custom.Cowboy.ShootAttackAbility;
import Abilities.custom.Cowboy.TriggerFinger;
import GameStuff.Arena;
import GameStuff.Creature;
import Util.FileUtil;

public class GunGuy extends Creature {
    private static String STAND = "cowboy_";
    private static String SELECTED = "cowboy_turn.png";
    private String pose = STAND + 1 + FileUtil.IMGFORM;
    private int sprite = 1;
    private int spriteloop = 0;
    public GunGuy(String name) {
        super(name, 35, "gun/");
        attacks.add(new ShootAttackAbility());
        attacks.add(new QuickDrawAttackAbility());
        attacks.add(new TriggerFinger());

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
        pose = STAND+1+FileUtil.IMGFORM;
    }

    @Override
    public void spriteUpdate(Arena arena) {
        super.spriteUpdate(arena);
        if (!alive()) {
            pose = DEAD;
            return;
        }
        if (this.hasTurn) {

        }
        else {
            if (age % 3 == 0) {
                if (spriteloop <= 0) {
                    if (spriteloop == 0) {
                        spriteloop--;
                        sprite = 1;
                    }
                    sprite++;
                    if (sprite > 6) {
                        spriteloop = 6;
                    }
                }
                else {
                    sprite++;
                    if (sprite > 9) {
                        sprite = 7;
                        spriteloop--;
                    }
                }
                pose = STAND + sprite + FileUtil.IMGFORM;
            }
        }

    }


}
