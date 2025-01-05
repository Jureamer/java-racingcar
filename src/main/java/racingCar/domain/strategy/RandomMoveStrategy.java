package racingCar.domain.strategy;

import racingCar.util.RandomNumberGenerator;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int RANDOM_BOUND = 10;
    private static final int MOVE_CONDITION = 4;

    @Override
    public boolean isMovable() {
        return RandomNumberGenerator.generateNumber(RANDOM_BOUND) >= MOVE_CONDITION;
    }
}
