package racingCar.view;

import racingCar.domain.RacingGame;
import racingCar.domain.RacingCar;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultViewer {
    public static void printWinners(RacingGame racingGame) {
        String winnersMessage = createWinnersMessage(racingGame.getWinners());
        System.out.println(winnersMessage);
    }

    private static String createWinnersMessage(List<RacingCar> winners) {
        String winnerNames = winners.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(", "));
        return winnerNames + "가 우승했습니다.";
    }

    public static void printPositions(Map<String, Integer> currentPositions) {
        for (String name : currentPositions.keySet()) {
            int position = currentPositions.get(name);
            System.out.print(name + " : ");
            System.out.print("-".repeat(position));
            System.out.println();
        }
        System.out.println();
    }
}
