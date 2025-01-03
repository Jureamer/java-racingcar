package racingCar;

import racingCar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static InputScanner inputScanner = new InputScanner();
    private static ResultViewer resultViewer = new ResultViewer();
    private static RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    public static void main(String[] args) {

        int carCount = inputScanner.getCarCount();
        int racingCount = inputScanner.getRacingCount();
        List<RacingCar> racingCars = createRacingCars(carCount);
        startRacing(racingCars, racingCount);
    }

    private static void startRacing(List<RacingCar> racingCars, int racingCount) {
        for (int i = 0; i < racingCount; i++) {
            for (RacingCar racingCar : racingCars) {
                int randomNumber = randomNumberGenerator.getRandomNumber();
                if (randomNumber >= 4) {
                    racingCar.move();
                }
            }
            resultViewer.getCurrentPosition(racingCars);
            System.out.println();
        }
    }

    private static List<RacingCar> createRacingCars(int carCount) {
        List<RacingCar> racingCars = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            racingCars.add(new RacingCar());
        }
        return racingCars;
    }
}
