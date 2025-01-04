package racingCar.domain.strategy;

@FunctionalInterface
public interface MoveStrategy {
    boolean isMovable();
}
