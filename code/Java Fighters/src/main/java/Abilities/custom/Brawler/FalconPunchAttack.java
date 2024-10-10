package Abilities.custom.Brawler;

import Abilities.AttackAbility;
import GameStuff.Ability;
import GameStuff.Arena;
import GameStuff.Creature;
import Util.AbilityUtil;

public class FalconPunchAttack extends AttackAbility {

    private Creature target = null;
    private int burningTicks = 0;
    public FalconPunchAttack() {
        super("Falcon Punch", 1, 0, 10, 15, 50, 1);
    }

    @Override
    public void Update(Arena arena, Creature user) {
        super.Update(arena, user);
        if (burningTicks > 0) {
            int damage = AbilityUtil.getRandom(1, 6);
            target.damage(damage);
            arena.writeOutput(target + " took " + damage + " fire damage.");
        }
    }
}
