package racingCar.util;

import java.util.Random;

public class RandomNumberGenerator {
    private static final Random random = new Random();

    public static int generateNumber(int bound) {
        return random.nextInt(bound);
    }

}
