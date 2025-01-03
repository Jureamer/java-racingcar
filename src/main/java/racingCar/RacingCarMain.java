package racingCar;

public class RacingCarMain {
    public static void main(String[] args) {
        InputScanner inputScanner = new InputScanner();
        int carCount = inputScanner.getCarCount();
        System.out.println("자동차 대수는 " + carCount + "대 입니다.");
        int racingCount = inputScanner.getRacingCount();
        System.out.println("시도할 횟수는 " + racingCount + "회 입니다.");


    }
}
