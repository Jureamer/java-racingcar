package racingCar.view;

import racingCar.domain.RacingCar;
import racingCar.domain.RacingCars;

import java.util.List;
import java.util.stream.Collectors;

public class ResultViewer {
    public void getCurrentPosition(RacingCars racingCars) {
        for (RacingCar racingCar : racingCars) {
            int position = racingCar.getPosition();
            System.out.print(racingCar.getName() + " : ");
            System.out.print("-".repeat(position));
            System.out.println();
        }
    }

    public void printWinners(RacingCars racingCars) {
        String winnersMessage = createWinnersMessage(racingCars);
        System.out.println(winnersMessage);
    }

    private String createWinnersMessage(RacingCars racingCars) {
        List<RacingCar> winners = racingCars.getWinners();
        String winnerNames = winners.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(", "));
        return winnerNames + "가 우승했습니다.";
    }
}
