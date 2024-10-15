package GameStuff;

import javax.swing.*;
import java.util.concurrent.CompletableFuture;

public class TurnThread extends Thread {
    Arena arena;
    JLabel roundLbl;
    public TurnThread(Arena arena, JLabel label) {
        this.arena = arena;
        this.roundLbl = label;
    }
    @Override
    public void run() {
        super.run();
        for (Creature creature : arena.getCreatures()) {
            try {
                creature.getSelectedAbility().perform(arena, creature, creature.getSelectedTargets());
                creature.clearSelectedAbility();
                creature.clearTargets();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        arena.nextRound();
        roundLbl.setText("Round : " + arena.getRound());
    }


}
