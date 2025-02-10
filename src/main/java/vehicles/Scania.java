package vehicles;

import java.awt.Color;

public class Scania extends CargoTruck {

    public Scania() {
        super(2, Color.BLUE, 540, "Scania");
    }

    public double speedFactor() {
        if (getCargoBedAngle() == 0) {
            return getEnginePower() * 0.01;
        } 
        else {
            return 0;
        }
    }

    public void lowerCargoBed(int degree){
        lowerCargoBed(degree);

    }
}