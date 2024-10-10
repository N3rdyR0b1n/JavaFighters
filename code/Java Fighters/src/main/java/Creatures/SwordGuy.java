package Creatures;


import GameStuff.Arena;
import GameStuff.Creature;
import Util.FileUtil;

import java.io.File;

public class SwordGuy extends Creature {
    private static String STAND = "sword_";
    private static String SELECTED = "sword_turn.png";
    private String pose = STAND;
    private int sprite=1;
    private boolean cntup = true;

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
        pose = STAND + 1 + FileUtil.IMGFORM;
    }
    @Override
    public void spriteUpdate(Arena arena) {
        super.spriteUpdate(arena);
        if (this.hasTurn) {

        }
        else {
            if (age % 3 == 0) {
                if (cntup) {
                    sprite++;
                    if (sprite > 4) {
                        cntup = false;
                    }
                }
                else {
                    sprite--;
                    if (sprite < 2) {
                        cntup =true;
                    }
                }
                pose = STAND + sprite + FileUtil.IMGFORM;
            }
        }
    }

}
