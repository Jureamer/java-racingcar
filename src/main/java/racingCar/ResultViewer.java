package racingCar;

import java.util.List;
import java.util.stream.Collectors;

public class ResultViewer {
    public void getCurrentPosition(RacingCars racingCars) {
        List<String> carNames = racingCars.getCarNames();
        List<Integer> carGoes = racingCars.getSteps();
        for (int i = 0; i < racingCars.size(); i++) {
            System.out.print(carNames.get(i) + " : ");
            System.out.print("-".repeat(carGoes.get(i)));
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
