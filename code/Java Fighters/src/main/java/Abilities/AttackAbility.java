package Abilities;

import GameStuff.Ability;
import GameStuff.Arena;
import GameStuff.Creature;
import Util.AbilityUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AttackAbility extends Ability {
    int mindamage;
    int maxdamage;
    int accuracy;
    public AttackAbility(String name, int cooldown, int cooldownProgress, int mindamage, int maxdamage, int hitchance, int targets) {
        super(name, cooldown, cooldownProgress, targets);
        this.mindamage = mindamage;
        this.maxdamage = maxdamage;
        this.accuracy = hitchance;
    }

    @Override
    public void perform(Arena world, Creature user, List<Creature> targets) throws InterruptedException {
        super.perform(world, user, targets);
        int min = getMinDamage(user);
        int max = getMaxdamage(user) + 1;
        int chance = getHitChance(user);
        for (Creature creature : targets) {
            creature.attack(world, AbilityUtil.getRandom(min, max), chance);
        }
    }
    protected int getMinDamage(Creature creature) {
        return creature.damageMod(mindamage);
    }

    protected int getMaxdamage(Creature creature) {
        return creature.damageMod(maxdamage);
    }
    protected int getHitChance(Creature creature) {
        return accuracy;
    }

    @Override
    protected ArrayList getInfo() {
        ArrayList list = super.getInfo();
        list.add("Damage: " + mindamage + "-" + maxdamage);
        list.add("Accuracy: " + accuracy + "%");
        return list;
    }
}
