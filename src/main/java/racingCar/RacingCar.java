package racingCar;

public class RacingCar {
    private int go = 0;
    private CarName carName;
    public RacingCar(CarName carName) {
        this.carName = carName;
    }

    public void move() {
        go++;
    }

    public int getGo() {
        return go;
    }

    public String getName() {
        return carName.getName();
    }
}
