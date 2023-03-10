package org.datagen.generator;

import java.util.Random;

public class RandomUtils {
    private static final Random r = new Random();
    public static int radmonInts(int min,int max){

        if (min > max){
            throw new IllegalArgumentException("sosi hui");
        }
        return r.ints(min, max).findFirst().getAsInt();
    }
}
