package Util;

import GameStuff.Creature;

import java.util.List;
import java.util.Random;

public class AbilityUtil {

    private static final Random random = new Random();

    public static int getRandom(int min, int max) {
        return min + random.nextInt(max-min + 1);
    }



}
