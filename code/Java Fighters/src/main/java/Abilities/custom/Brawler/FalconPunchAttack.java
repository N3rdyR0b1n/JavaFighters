package Abilities.custom.Brawler;

import Abilities.AttackAbility;
import GameStuff.Ability;
import GameStuff.Arena;
import GameStuff.Creature;
import Util.AbilityUtil;

import java.util.ArrayList;
import java.util.List;

public class FalconPunchAttack extends AttackAbility {

    private List<Creature> target = new ArrayList<>();
    private int burningTicks = 0;
    public FalconPunchAttack() {
        super("Falcon Punch", 3, 0, 10, 15, 50, 1);
    }

    @Override
    public void perform(Arena world, Creature user, List<Creature> targets) throws InterruptedException {
        cooldownProgress = cooldown + 1;
        world.writeOutput(user + " used " + name);
        int min = getMinDamage(user);
        int max = getMaxdamage(user) + 1;
        int chance = getHitChance(user);
        for (Creature creature : targets) {
            if (creature.attack(world, AbilityUtil.getRandom(min, max), chance)) {
                target.add(creature);
            }
        }
        if (!targets.isEmpty()) {
            burningTicks+=3;
        }
    }

    @Override
    public void Update(Arena arena, Creature user) throws InterruptedException {
        super.Update(arena, user);
        if (burningTicks > 0) {
            for (Creature creature : target) {
                int damage = AbilityUtil.getRandom(1, 6);
                creature.damage(damage);
                Thread.sleep(500);
                arena.writeOutput(creature + " took " + damage + " fire damage.");
            }
            burningTicks--;
        }
        else if (!target.isEmpty()) {
            target.clear();
        }
    }

    @Override
    public String getDescription() {
        StringBuffer sb = new StringBuffer(super.getDescription());
        sb.append("\nDescription: <insert ability description here>");
        return sb.toString();
    }
}
