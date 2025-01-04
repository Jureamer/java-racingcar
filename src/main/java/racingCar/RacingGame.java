package racingCar;

import racingCar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static InputScanner inputScanner = new InputScanner();
    private static ResultViewer resultViewer = new ResultViewer();
    private static RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public static void main(String[] args) {
        List<CarName> carNames = inputScanner.getCarNames();
        int racingCount = inputScanner.getRacingCount();
        RacingCars racingCars = createRacingCars(carNames);
        startRacing(racingCars, racingCount);
        resultViewer.printWinners(racingCars);
    }

    private static void startRacing(RacingCars racingCars, int racingCount) {
        System.out.println("실행 결과");
        for (int i = 0; i < racingCount; i++) {
            racingCars.move(randomNumberGenerator);
            resultViewer.getCurrentPosition(racingCars);
            System.out.println();
        }
    }

    private static RacingCars createRacingCars(List<CarName> carNames) {
        List<RacingCar> racingCars = new ArrayList<>();

        for (CarName carName : carNames) {
            racingCars.add(new RacingCar(carName));
        }
        return new RacingCars(racingCars);
    }
}
