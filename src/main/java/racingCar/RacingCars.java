package racingCar;

import racingCar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCar> getWinners() {
        int max_go = -1;
        List<RacingCar> winners = new ArrayList<>();

        for (RacingCar racingCar : racingCars) {
            int go = racingCar.getGo();
            if (go > max_go) {
                max_go = go;
                winners.clear();
                winners.add(racingCar);
            } else if (racingCar.getGo() == max_go) {
                winners.add(racingCar);
            }
        }
        return winners;
    }

    public void move(RandomNumberGenerator randomNumberGenerator) {
        for (RacingCar racingCar : racingCars) {
            int randomNumber = randomNumberGenerator.getRandomNumber();
            if (randomNumber >= 4) {
                racingCar.move();
            }
        }
    }
}
