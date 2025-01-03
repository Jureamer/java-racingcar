package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingCarTest {

    @ParameterizedTest
    @DisplayName("자동차 이동 테스트")
    @ValueSource(ints = {1, 9})
    public void testMove(int input) {
        RacingCar car = new RacingCar();
        for (int i = 0; i < input; i++) {
            car.move();
        }
        assertEquals(input, car.getGo());
    }

    @Test
    @DisplayName("자동차 초기 위치 테스트")
    public void testInitialGo() {
        RacingCar car = new RacingCar();
        assertEquals(0, car.getGo());
    }
}