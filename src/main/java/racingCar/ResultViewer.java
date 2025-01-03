package racingCar;

import java.util.List;

public class ResultViewer {
    public void getCurrentPosition(List<RacingCar>racingCars) {
        for (RacingCar racingCar : racingCars) {
            int go = racingCar.getGo();
            System.out.print("-".repeat(go));
            System.out.println();
        }
    }
}
