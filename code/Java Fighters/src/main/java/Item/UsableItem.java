package Item;

import GameStuff.Ability;
import GameStuff.Arena;
import GameStuff.Creature;
import Util.AbilityUtil;

import java.util.List;

public class UsableItem extends Ability implements Cloneable{
    private final String consumptionMessage;
    private final int minHealing;
    private final int maxHealing;
    public UsableItem(String name, String consumptionMessage, int minHealing, int maxHealing) {
        super(name, 0);
        this.consumptionMessage = consumptionMessage;
        this.minHealing = minHealing;
        this.maxHealing = maxHealing;
    }

    @Override
    public void perform(Arena arena, Creature user, List<Creature> targets) throws InterruptedException {
        super.perform(arena, user, targets);
        arena.writeOutput(user.toString() + " " + consumptionMessage + " " + name);
        Thread.sleep(500);
        int healing = AbilityUtil.getRandom(minHealing, maxHealing);
        user.heal(healing);
        arena.writeOutput(user + " healed " + healing + " Hp");
        if (user.hasMaxHealth()) {
            Thread.sleep(300);
            arena.writeOutput(user + " fully restored");
        }
    }
}
