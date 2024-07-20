package nttn.core;

import java.util.Random;

// public static enum COMPARE_MODES {
//     GREATER_THAN, 
//     LESS_THAN, 
//     EQUAL_TO
// }

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
    
    public static int round(double num) {
        return Math.round((float)num);
    }

    public static float abs (float num) {
        return Math.abs(num);
    }

    public static float sqrt (float num) {
        return (float)Math.sqrt(num);
    }

    // public static int fCompare(float a, COMPARE_MODES mode,  float b) {
    //     int c = Float.compare(a, b);
    //     switch(mode){
    //         case COMPARE_MODES.GREATER_THAN: 
    //         break;
    //         case COMPARE_MODES.LESS_THAN: 
    //         break;
    //         case COMPARE_MODES.EQUAL_TO: 
    //         break;
    //     }
    //     if(c > 0) {
    //
    //     }
    //     else if(c > 0) {
    //
    //     }
    //     if(c > 0) {
    //
    //     }
    // }
}
