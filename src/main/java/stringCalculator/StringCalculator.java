package stringCalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int calculate(String s) {
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

    private static int checkMinus(int number) throws IllegalArgumentException{
        if (number < 0) {
            throw new IllegalArgumentException("마이너스는 입력할 수 없습니다." + number);
        }
        return number;
    }
    private static int getTotal(String s, String delimiter) throws IllegalArgumentException {
        try {
            return Arrays.stream(s.split(delimiter))
                    .mapToInt(Integer::parseInt)
                    .map(StringCalculator::checkMinus)
                    .sum();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
