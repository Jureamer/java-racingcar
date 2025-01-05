package racingCar.domain;

public class RacingCount {
    public static final int LIMIT_RACING_COUNT = 9;
    private int number;

    public RacingCount(int number) {
        checkProperRacingCount(number);
        this.number = number;
    }

    private static int checkProperRacingCount(int number) {
        if (number > LIMIT_RACING_COUNT) {
            throw new IllegalArgumentException("시도할 횟수는 " + LIMIT_RACING_COUNT + "회 이하로 입력해주세요.");
        }
        return number;
    }

    public boolean isEnd() {
        return number == 0;
    }

    public int getNumber() {
        return number;
    }

    public void decreateCount() {
        number--;
    }
}
