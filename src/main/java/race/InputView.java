package race;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner scanner;
    private final String CAR_NAME_SPLIT_REGEX = "\\s*,\\s*";
    private final int MIN_CAR_COUNT = 1;
    private final int MAX_CAR_COUNT = 5;
    private final int MIN_RACE_COUNT = 1;
    private final int MAX_RACE_COUNT = 9;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public InputView() {
        this(new Scanner(System.in));
    }

    public List<String> receiveCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNamesString = scanner.nextLine();
        return Arrays.stream(carNamesString.split(","))
                .map(String::trim)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        list -> {
                            validateCarNamesCount(list);
                            return List.copyOf(list);
                        }));


    }

    private void validateCarNamesCount(List<String> carNames) {
        if (carNames.size() < MIN_CAR_COUNT || carNames.size() > MAX_CAR_COUNT) {
            throw new IllegalArgumentException("경주 할 자동차 이름을 1~5대 사이로 입력 해 주시기 바랍니다.");
        }
    }

    public int receiveRaceCount() {
        System.out.println("시도할 회수는 몇 회인가요?");

        while (true) {
            try {
                return getValidRaceCount();
            } catch (InputMismatchException e) {
                System.out.println("1 ~ 9 사이의 유효한 숫자를 입력 해주세요.");
                scanner.next();
            }
        }
    }

    private int getValidRaceCount() {
        int raceCount = scanner.nextInt();
        validateRaceCount(raceCount);
        return raceCount;
    }

    private void validateRaceCount(int raceCount) {
        if (raceCount < MIN_RACE_COUNT || raceCount > MAX_RACE_COUNT) {
            throw new IllegalArgumentException("1 ~ 9 사이의 양수를 입력해주세요.");
        }
    }

    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
