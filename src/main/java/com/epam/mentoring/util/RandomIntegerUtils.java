package com.epam.mentoring.util;

import java.util.SplittableRandom;

public class RandomIntegerUtils {
    public static int randomInteger (int bound) {
        return new SplittableRandom().nextInt(0, bound);
    }

    public static int randomIntegerWithoutZero (int bound) {
        return new SplittableRandom().nextInt(1, bound);
    }

}
