package racingCar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @Test
    @DisplayName("기본 위치 생성 테스트")
    void createDefaultPosition() {
        Position position = new Position();
        assertThat(position.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("초기값을 가진 위치 생성 테스트")
    void createPositionWithInitialValue() {
        Position position = new Position(5);
        assertThat(position.getPosition()).isEqualTo(5);
    }

    @Test
    @DisplayName("위치 이동 테스트")
    void movePosition() {
        Position position = new Position();
        position.move();
        assertThat(position.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("음수 위치 예외 처리 테스트")
    void throwExceptionWhenPositionIsNegative() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("위치는 0 이상의 값이어야 합니다.");
    }

    @Test
    @DisplayName("equals 메소드 테스트")
    void testEquals() {
        Position position1 = new Position(3);
        Position position2 = new Position(3);
        assertThat(position1).isEqualTo(position2);
    }

    @Test
    @DisplayName("hashCode 메소드 테스트")
    void testHashCode() {
        Position position1 = new Position(3);
        Position position2 = new Position(3);
        assertThat(position1.hashCode()).isEqualTo(position2.hashCode());
    }
}
