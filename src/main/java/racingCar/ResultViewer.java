package racingCar;

import java.util.List;

public class ResultViewer {
    public void getCurrentPosition(RacingCars racingCars) {
        for (RacingCar racingCar : racingCars) {
            int go = racingCar.getGo();
            System.out.print(racingCar.getName() + " : ");
            System.out.print("-".repeat(go));
            System.out.println();
        }
    }
}
