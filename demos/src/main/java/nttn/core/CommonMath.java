package nttn.core;

import java.util.Random;

public final class CommonMath { 
    private static final Random random = new Random();

    public static int randIntRange(int min, int max) {
        if (min >= max)
            throw new IllegalArgumentException("max must be greater than min");

        return random.nextInt(max - min) + min;    
    }

    public static float randFloatRange(int min, int max) {
        if (min >= max)
            throw new IllegalArgumentException("max must be greater than min");

        return random.nextFloat() * (max - min) + min;
    }

    public static int round(float num) {
        return Math.round(num);
    }

    public static float abs (float num) {
        return Math.abs(num);
    }
}
