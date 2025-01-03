package racingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputScanner {
    public static final int LIMIT_CAR_COUNT = 9;
    private static final int LIMIT_RACING_COUNT = 9;
    private static final String CAR_NAME_DELIMITER = ",";
    Scanner scanner = new Scanner(System.in);
    public List<CarName> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        String[] carNamesArray = input.split(CAR_NAME_DELIMITER);
        List<CarName> carNames = new ArrayList<>();

        for (String name : carNamesArray) {
            carNames.add(new CarName(name));
        }

        checkProperCarCount(carNames.size());
        return carNames;
    }

    public int getCarCount() {
        System.out.println("자동차 대수는 몇 대인가요?");
        String input = scanner.nextLine();

        int number = checkCarCountNumeric(input);
        number = checkProperCarCount(number);
        return number;
    }

    public int getRacingCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = scanner.nextLine();

        int number = checkRacingCountNumeric(input);
        number = checkProperRacingCount(number);
        return number;

    }

    private int checkProperRacingCount(int number) {
        while (number > LIMIT_CAR_COUNT) {
            System.out.println("시도할 횟수는 " + LIMIT_RACING_COUNT + "회 이하로 입력해주세요.");
            number = scanner.nextInt();
        }
        return number;
    }

    private int checkProperCarCount(int number) {
        while (number > LIMIT_RACING_COUNT) {
            System.out.println("자동차 대수는 " + LIMIT_CAR_COUNT + "대 이하로 입력해주세요.");
            number = scanner.nextInt();
        }
        return number;
    }

    private int checkRacingCountNumeric(String input) {
        while (!isNumeric(input)) {
            System.out.println("횟수는 + " + LIMIT_RACING_COUNT + "회 이하의 숫자로 입력해주세요.");
            input = scanner.nextLine();
        }
        return Integer.parseInt(input);
    }

    private int checkCarCountNumeric(String input) {
        while (!isNumeric(input)) {
            System.out.println("자동차 대수는 + " + LIMIT_CAR_COUNT + "대 이하의 숫자로 입력해주세요.");
            input = scanner.nextLine();
        }
        return Integer.parseInt(input);
    }

    private static boolean isNumeric(String input) {
        return input != null && input.matches("\\d+");
    }
}
