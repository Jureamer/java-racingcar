package racingCar;

import racingCar.domain.CarName;
import racingCar.domain.RacingGame;
import racingCar.domain.strategy.MoveStrategy;
import racingCar.domain.strategy.RandomMoveStrategy;
import racingCar.view.InputScanner;
import racingCar.view.ResultViewer;

import java.util.List;

public class RacingMain {
    private final static MoveStrategy moveStrategy = new RandomMoveStrategy();

    public static void main(String[] args) {
        List<CarName> carNames = InputScanner.getCarNames();
        int racingCount = InputScanner.getRacingCount();
        RacingGame racingGame = new RacingGame(carNames, racingCount);
        startRacing(racingGame);
        ResultViewer.printWinners(racingGame);
    }

    private static void startRacing(RacingGame racingGame) {
        System.out.println("실행 결과");

        while (!racingGame.isEnd()) {
            racingGame.move(moveStrategy);
            ResultViewer.printPositions(racingGame.getCurrentPositions());
        }
    }
}
