package StringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    @Test
    @DisplayName(",로 구분되어 계산 되는 지 확인")
    public void commaTest() {
        String s = "1,2,3";
        assertThat(calculate(s)).isEqualTo(6);
    }

    @Test
    @DisplayName(":으로 구분되어 계산 되는 지 확인")
    public void colonTest() {
        String s = "1:2:3";
        assertThat(calculate(s)).isEqualTo(6);
    }

    @Test
    @DisplayName(",와 :으로 구분되어 계산 되는 지 확인")
    public void commaAndColonTest() {
        String s = "1:2,3";
        assertThat(calculate(s)).isEqualTo(6);
    }

    @ParameterizedTest
    @DisplayName("빈값일 경우 0을 반환")
    @NullAndEmptySource
    public void emptyTest(String s) {
        assertThat(calculate(s)).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("한 자리의 문자열일 경우 해당 숫자를 반환")
    @ValueSource(strings = {"1", "9"})
    public void digitStringTest(String input) {
        assertThat(calculate(input)).isEqualTo(Integer.parseInt(input));
    }

    @Test
    @DisplayName("커스텀 구분자가 있을 경우 해당 구분자로 계산")
    public void customDelimiter() {
        String s = "//;\n1;2;3";
        assertThat(calculate(s)).isEqualTo(6);
    }

    @Test
    @DisplayName("음수가 있을 경우 예외가 발생")
    public void whenMinusGivenExceptionOccur() {
        String s = "-1,2:3";
        assertThatThrownBy(() -> calculate(s)).isInstanceOf(IllegalArgumentException.class);
    }


    private int checkMinus(int number) throws IllegalArgumentException{
        if (number < 0) {
            throw new IllegalArgumentException("마이너스는 입력할 수 없습니다.");
        }
        return number;
    }
    private int getTotal(String s, String delimiter) throws IllegalArgumentException {
        try {
            return Arrays.stream(s.split(delimiter))
                    .mapToInt(Integer::parseInt)
                    .map(this::checkMinus)
                    .sum();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("에러 발생", e);
        }
    }

    private int calculate(String s) {
        String DEFAULT_DELIMITER = ",|:";

        if (s == null || s.isEmpty()) {
            return 0;
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(s);
        if (m.find()) {
            String customDelimiter = Pattern.quote(m.group(1));
            String numbers = m.group(2);
            return getTotal(numbers, customDelimiter);
        }

        return getTotal(s, DEFAULT_DELIMITER);
    }
}



