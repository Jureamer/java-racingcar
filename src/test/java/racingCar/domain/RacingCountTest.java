package racingCar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCountTest {

    @Test
    @DisplayName("레이싱 횟수 생성 테스트")
    void createRacingCount() {
        RacingCount racingCount = new RacingCount(5);
        assertThat(racingCount.getNumber()).isEqualTo(5);
    }

    @Test
    @DisplayName("레이싱 횟수 제한 테스트")
    void limitRacingCount() {
        assertThatThrownBy(() -> new RacingCount(10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수는 " + RacingCount.LIMIT_RACING_COUNT + "회 이하로 입력해주세요.");
    }

    @Test
    @DisplayName("레이싱 횟수 감소 테스트")
    void decreaseCount() {
        RacingCount racingCount = new RacingCount(5);
        racingCount.decreateCount();
        assertThat(racingCount.getNumber()).isEqualTo(4);
    }

    @Test
    @DisplayName("레이싱 종료 확인 테스트")
    void isEnd() {
        RacingCount racingCount = new RacingCount(1);
        racingCount.decreateCount();
        assertThat(racingCount.isEnd()).isTrue();
    }
}
