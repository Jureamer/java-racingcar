package racingCar.domain;

import racingCar.domain.strategy.MoveStrategy;

public class RacingCar {
    private Position position;
    private CarName carName;

    public RacingCar(CarName carName) {
        this.carName = carName;
        this.position = new Position();
    }

    public RacingCar(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            position.move();
        };
    }

    public void move() {
        position.move();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return carName.getName();
    }
}
