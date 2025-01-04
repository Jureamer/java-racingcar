package racingCar.domain;

import racingCar.domain.strategy.RandomMoveStrategy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RacingCars implements Iterable<RacingCar> {
    private List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCar> getWinners() {
        int max_position = -1;
        List<RacingCar> winners = new ArrayList<>();

        for (RacingCar racingCar : racingCars) {
            int go = racingCar.getPosition();
            if (go > max_position) {
                max_position = go;
                winners.clear();
                winners.add(racingCar);
            } else if (racingCar.getPosition() == max_position) {
                winners.add(racingCar);
            }
        }
        return winners;
    }

    public void move(RandomMoveStrategy randomMoveStrategy) {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(randomMoveStrategy);
        }
    }

    @Override
    public Iterator<RacingCar> iterator() {
        return racingCars.iterator();
    }
}
