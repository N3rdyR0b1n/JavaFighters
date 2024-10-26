package Util;

import GameStuff.Creature;

import java.util.List;
import java.util.Random;

public class AbilityUtil {


    public static int getRandom(int min, int max) {
        return min + (int) (Math.random() * (max - min));
    }



}
