package racingCar.domain;

public class CarName {
    public static final int LIMIT_CAR_NAME_LENGTH = 5;
    private String carName;

    public CarName(String carName) {
        if (carName.length() > LIMIT_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + LIMIT_CAR_NAME_LENGTH + "자 이하만 가능합니다.");
        }
        this.carName = carName.trim();
    }

    public String getName() {
        return carName;
    }
}
