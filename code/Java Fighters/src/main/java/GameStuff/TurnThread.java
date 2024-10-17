package GameStuff;

import javax.swing.*;
import java.util.List;
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
                if (!creature.alive()) {
                    continue;
                }
                creature.getSelectedAbility().perform(arena, creature, creature.getSelectedTargets());
                creature.clearSelectedAbility();
                creature.clearTargets();
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        arena.nextRound();
        roundLbl.setText("Round : " + arena.getRound());
        Player player1 = arena.getPlayer(1);
        if (playerLost(player1)) {
            win(arena, arena.getPlayer(2));
        }
        else if (playerLost(arena.getPlayer(2))){
            win(arena, arena.getPlayer(1));
        }

    }

    private void win(Arena arena, Player person) {

        arena.writeOutput("--- --- --- --- --- --- --- --- --- --- ---");
        arena.writeOutput("--- --- --- ---             --- --- --- ---");
        arena.writeOutput("--- --- --- --- "+person+ "WON!!! --- --- --- ---");
        arena.writeOutput("--- --- --- ---             --- --- --- ---");
        arena.writeOutput("--- --- --- --- --- --- --- --- --- --- ---");
    }
    private boolean playerLost(Player player) {
        List<Creature> creatureList = player.getTeam();
        for (Creature creature : creatureList) {
            if (creature.alive()) return false;
        }
        return true;
    }
}
