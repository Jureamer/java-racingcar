package racingCar.domain;

public class CarName {
    public static final int LIMIT_CAR_NAME_LENGTH = 5;
    private String CAR_NAME;

    public CarName(String CAR_NAME) {
        if (CAR_NAME.length() > LIMIT_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + LIMIT_CAR_NAME_LENGTH + "자 이하만 가능합니다.");
        }
        this.CAR_NAME = CAR_NAME.trim();
    }

    public String getName() {
        return CAR_NAME;
    }
}
