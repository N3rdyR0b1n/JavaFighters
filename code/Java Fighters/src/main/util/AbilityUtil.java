package Util;

import Creature;

import java.util.List;
import java.util.Random;

public class AbilityUtil {



    public static List<Creature> Damage(List<Creature> targets, int damage, int maxdamage, int chance) {
        Random random = new Random();
        for (int i = 0; i < targets.size(); i++) {
            Creature creature = targets.get(i);
            int r = random.nextInt(0, 100);

        }
        return targets;
    }


}
