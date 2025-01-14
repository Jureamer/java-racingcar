package racingCar.domain;

import racingCar.domain.strategy.MoveStrategy;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingCars implements Iterable<RacingCar> {
    private List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCar> getWinners() {
        int largestPosition = racingCars.stream()
                .map(RacingCar::getPosition)
                .max(Integer::compareTo)
                .orElseThrow();

        return racingCars.stream()
                .filter(racingCar -> racingCar.getPosition() == largestPosition)
                .collect(Collectors.toList());
    }

    public void move(MoveStrategy randomMoveStrategy) {
        racingCars.forEach(racingCar -> racingCar.move(randomMoveStrategy));
    }

    @Override
    public Iterator<RacingCar> iterator() {
        return racingCars.iterator();
    }

    public Map<String, Integer> getCurrentPositions() {
        return racingCars.stream()
            .collect(Collectors.toMap(RacingCar::getName, RacingCar::getPosition));
    }

}
