package Abilities;

import GameStuff.Ability;
import GameStuff.Arena;
import GameStuff.Creature;

import java.util.List;

public class SpareAbility extends Ability {
    public SpareAbility() {
        super("Spare",1);
    }


    @Override
    public void perform(Arena world, Creature user, List<Creature> targets) throws InterruptedException {
        super.perform(world, user, targets);
        for (Creature creature : targets) {
            if (creature.getHpPercent() <= 30) {
                creature.damage(100000000);
                world.writeOutput(creature + " was spared");
            }
        }
    }
}
