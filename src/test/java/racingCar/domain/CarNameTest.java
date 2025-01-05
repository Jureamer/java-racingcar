package racingCar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @Test
    @DisplayName("자동차 이름 생성 테스트")
    void createCarName() {
        CarName carName = new CarName("car1");
        assertThat(carName.getName()).isEqualTo("car1");
    }

    @Test
    @DisplayName("자동차 이름 길이 제한 테스트")
    void limitCarNameLength() {
        assertThatThrownBy(() -> new CarName("longname"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 " + CarName.LIMIT_CAR_NAME_LENGTH + "자 이하만 가능합니다.");
    }
}
