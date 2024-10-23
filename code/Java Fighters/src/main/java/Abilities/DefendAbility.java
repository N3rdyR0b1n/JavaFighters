package Abilities;

import GameStuff.Ability;
import GameStuff.Arena;
import GameStuff.Creature;

import java.util.List;

public class DefendAbility extends Ability {
    public DefendAbility() {
        super("Defend", 0);
    }
    int duration = 0;

    @Override
    public void Update(Arena arena, Creature user) throws InterruptedException {
        super.Update(arena, user);
        duration--;
        if (duration == 0) {
            user.modifyArmor(-10);
        }
    }

    @Override
    public void perform(Arena world, Creature user, List<Creature> targets) throws InterruptedException {
        super.perform(world, user, targets);
        duration = 2;
        user.modifyArmor(10);
        world.writeOutput(user+ "'s defense rose by 10");
    }
}
