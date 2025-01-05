package racingCar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.domain.CarName;
import racingCar.domain.RacingCar;
import racingCar.domain.RacingGame;
import racingCar.domain.strategy.MoveStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RacingGameTest {

    private List<CarName> carNames;
    private MoveStrategy moveStrategy;

    @BeforeEach
    public void setUp() {
        carNames = Arrays.asList(new CarName("pobi"), new CarName("crong"), new CarName("honux"));
        moveStrategy = mock(MoveStrategy.class);
    }

    @Test
    @DisplayName("게임 종료 여부 테스트")
    public void testIsEnd() {
        RacingGame racingGame = new RacingGame(carNames, 1);
        assertThat(racingGame.isEnd()).isFalse();
        racingGame.move(moveStrategy);
        assertThat(racingGame.isEnd()).isTrue();
    }

    @Test
    @DisplayName("자동차 이동 테스트")
    public void testMove() {
        when(moveStrategy.isMovable()).thenReturn(true);
        RacingGame racingGame = new RacingGame(carNames, 1);
        racingGame.move(moveStrategy);

        Map<String, Integer> positions = racingGame.getCurrentPositions();

        for (String name : positions.keySet()) {
            assertThat(positions.get(name)).isOne();
        }
    }

    @Test
    @DisplayName("현재 위치 가져오기 테스트")
    public void testGetCurrentPositions() {
        RacingGame racingGame = new RacingGame(carNames, 1);
        Map<String, Integer> positions = racingGame.getCurrentPositions();

        assertThat(positions).hasSize(3);
        for (String name : positions.keySet()) {
            assertThat(positions.get(name)).isZero();
        }
    }

    @Test
    @DisplayName("우승자 가져오기 테스트")
    public void testGetWinners() {
        when(moveStrategy.isMovable()).thenReturn(true);
        RacingGame racingGame = new RacingGame(carNames, 1);
        racingGame.move(moveStrategy);

        List<RacingCar> winners = racingGame.getWinners();
        assertThat(winners).hasSize(3);
    }
}