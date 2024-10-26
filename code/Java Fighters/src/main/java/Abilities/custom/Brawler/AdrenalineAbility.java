package Abilities.custom.Brawler;

import GameStuff.Ability;
import GameStuff.Arena;
import GameStuff.Creature;
import Util.AbilityUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AdrenalineAbility extends Ability {
    public int duration;
    public AdrenalineAbility() {
        super("Adrenaline", 1, 0, 0);
        duration = 0;
    }

    @Override
    public void perform(Arena world, Creature user, List<Creature> targets) throws InterruptedException {
        super.perform(world, user, targets);
        duration += 3;
    }

    @Override
    public void Update(Arena arena, Creature user) throws InterruptedException {
        super.Update(arena, user);
        if (duration > 0) {
            duration--;
            int health = AbilityUtil.getRandom(1, 10);
            user.heal(health);
            user.addExtraDamage(2);
            arena.writeOutput(user + " received effects from " + name);
            arena.writeOutput(user + " healed " + health + "  hp");
            arena.writeOutput(user + "'s attack rose by 2");
        }
    }
    @Override
    protected ArrayList getInfo() {
        ArrayList<String> info = super.getInfo();
        info.add("Effects:");
        info.add("Heals 1-10 hp for 3 turns");
        info.add("Permanently increases atk by 2 for 3 turns");
        info.add("Using the ability again while active increases duration by 3 turns");
        return info;
    }
}
