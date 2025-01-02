import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set 사이즈 확인")
    public void checkSetSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest()
    @DisplayName("특정 숫자가 포함되어있는 지 확인")
    @ValueSource(ints = {1, 2, 3})
    void contains(int n) {
        assertThat(numbers.contains(n)).isTrue();
    }

//     1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5
    @ParameterizedTest()
    @DisplayName("각 숫자별 포함 여부 체크")
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    void containsExpected(int n, boolean expected) {
        assertThat(numbers.contains(n)).isEqualTo(expected);
    }
}