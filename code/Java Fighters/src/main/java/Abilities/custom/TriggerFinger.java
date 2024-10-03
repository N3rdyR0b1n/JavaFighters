package Abilities.custom;

import Abilities.AttackAbility;
import GameStuff.Ability;
import GameStuff.Arena;
import GameStuff.Creature;

import java.util.List;

public class TriggerFinger extends Ability {
    public TriggerFinger() {
        super("Trigger finger", 1, 1,0);
    }

    @Override
    public void perform(Arena world, Creature user, List<Creature> targets) {
        super.perform(world, user, targets);

    }
}
