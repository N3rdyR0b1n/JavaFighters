package Abilities.custom.Cowboy;

import Abilities.AttackAbility;
import GameStuff.Ability;
import GameStuff.Arena;
import GameStuff.Creature;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;

public class TriggerFinger extends Ability {
    public TriggerFinger() {
        super("Trigger finger", 1, 0,0);
    }

    @Override
    public void perform(Arena world, Creature user, List<Creature> targets) throws InterruptedException {
        super.perform(world, user, targets);
        Thread.sleep(300);
        user.addExtraDamage(5);
        world.writeOutput(user + "'s damage has been increased by 5 !");
    }
    @Override
    protected ArrayList getInfo() {
        ArrayList<String> info = super.getInfo();
        info.add("Effects:");
        info.add("Increases Atk permanently by 5");
        return info;
    }
}
