package racingCar.domain;

import racingCar.domain.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RacingGame {
    private RacingCount racingCount;
    private RacingCars racingCars;

    public RacingGame(List<CarName> carNames, RacingCount racingCount) {
        this.racingCount = racingCount;
        this.racingCars = createRacingCars(carNames);
    }

    private RacingCars createRacingCars(List<CarName> carNames) {
        List<RacingCar> racingCars = new ArrayList<>();

        carNames.stream()
                .map(RacingCar::new)
                .forEach(racingCars::add);

        return new RacingCars(racingCars);
    }

    public boolean isEnd() {
        return racingCount.isEnd();
    }

    public void move(MoveStrategy moveStrategy) {
        racingCars.move(moveStrategy);
        racingCount.decreateCount();
    }

    public Map<String, Integer> getCurrentPositions() {
        return racingCars.getCurrentPositions();
    }

    public List<RacingCar> getWinners() {
        return racingCars.getWinners();
    }
}