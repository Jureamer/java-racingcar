package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("StringCalculator 테스트")
public class StringCalculatorTest {

    @ParameterizedTest
    @DisplayName("구분자로 값을 합산")
    @ValueSource(strings = {"1,2,3", "1:2:3", "1:2,3"})
    public void calculatesSumForDifferentDelimiters(String input) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(6);
    }

    @ParameterizedTest
    @DisplayName("빈값일 경우 0을 반환")
    @NullAndEmptySource
    public void returnsZeroForEmptyOrNull(String input) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("한 자리 문자열 계산")
    @ValueSource(strings = {"1", "9"})
    public void returnsSingleDigitValue(String input) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(Integer.parseInt(input));
    }

    @Test
    @DisplayName("커스텀 구분자를 사용한 값 합산")
    public void calculatesSumForCustomDelimiter() {
        String s = "//;\n1;2;3";
        assertThat(StringCalculator.calculate(s)).isEqualTo(6);
    }

    @Test
    @DisplayName("음수가 포함된 경우 예외 발생")
    public void throwsExceptionForNegativeNumbers() {
        String s = "-1,2:3";
        assertThatThrownBy(() -> StringCalculator.calculate(s)).isInstanceOf(IllegalArgumentException.class);
    }
}



