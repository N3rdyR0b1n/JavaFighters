package Creatures;


import GameStuff.Arena;
import GameStuff.Creature;

public class BrawlerGuy extends Creature {
    private  String STAND = "brawler_";
    private static String SELECTED = "brawler_turn.png";
    private String pose = STAND + "1.png";
    private int sprite = 0;

    public BrawlerGuy(String name) {
        super(name, 65, "fist/");
    }

    @Override
    public String getImageSource() {
        return super.getImageSource() + pose ;
    }

    @Override
    public void onTurn(Arena arena) {
        super.onTurn(arena);
        pose = SELECTED;
    }
    public void endTurn(Arena arena) {
        super.endTurn(arena);
        pose = STAND + sprite + ".png";
    }

    @Override
    public void spriteUpdate(Arena arena) {
        super.spriteUpdate(arena);
        if (this.hasTurn) {

        }
        else {
            if (age % 5 == 0) {
                sprite++;
                if (sprite > 5) {
                    sprite = 1;
                }
                pose = STAND + sprite + ".png";
            }
        }
    }
}
