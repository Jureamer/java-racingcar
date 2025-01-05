package racingCar.domain;

import racingCar.domain.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGame {
    private int racingCount;
    private RacingCars racingCars;

    public RacingGame(List<CarName> carNames, int racingCount) {
        this.racingCount = racingCount;
        this.racingCars = createRacingCars(carNames);
    }

    private RacingCars createRacingCars(List<CarName> carNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (CarName carName : carNames) {
            racingCars.add(new RacingCar(carName));
        }
        return new RacingCars(racingCars);
    }

    public boolean isEnd() {
        return racingCount == 0;
    }

    public void move(MoveStrategy moveStrategy) {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(moveStrategy);
        }

        racingCount--;
    }

    public Map<String, Integer> getCurrentPositions() {
        Map<String, Integer> currentPositions = new HashMap<>();

        for (RacingCar racingCar : racingCars) {
            currentPositions.put(racingCar.getName(), racingCar.getPosition());
        }
        return currentPositions;
    }

    public List<RacingCar> getWinners() {
        return racingCars.getWinners();
    }
}