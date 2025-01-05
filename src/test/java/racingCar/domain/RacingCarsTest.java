package racingCar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingCar.domain.strategy.RandomMoveStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class RacingCarsTest {
    private RacingCar car1;
    private RacingCar car2;
    private RacingCar car3;
    private RacingCars racingCars;
    private RandomMoveStrategy strategy = Mockito.mock(RandomMoveStrategy.class);
    @BeforeEach
    public void setUp() {
        car1 = new RacingCar(new CarName("pobi"));
        car2 = new RacingCar(new CarName("crong"));
        car3 = new RacingCar(new CarName("honux"));
        when(strategy.isMovable()).thenReturn(true);
        racingCars = new RacingCars(Arrays.asList(car1, car2, car3));
    }

    @Test
    @DisplayName("자동차 이동 테스트")
    public void testMove() {
        racingCars.move(strategy);
        assertThat(car1.getPosition()).isOne();
    }

    @Test
    @DisplayName("우승자 가져오기 테스트")
    public void testGetWinners() {
        car1.move(strategy);
        car2.move(strategy);
        car2.move(strategy);

        List<RacingCar> winners = racingCars.getWinners();

        assertThat(winners).hasSize(1);
        assertThat(winners.get(0)).isEqualTo(car2);
    }
}
