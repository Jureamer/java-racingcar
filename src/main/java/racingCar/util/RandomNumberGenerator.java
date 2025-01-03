package racingCar.util;

import java.util.Random;

public class RandomNumberGenerator {

    public static final int BOUND = 10;
    Random random = new Random();

    public int getRandomNumber() {
        return random.nextInt(BOUND);
    }

}
