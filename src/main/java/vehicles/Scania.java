package vehicles;

import java.awt.Color;

public class Scania extends Truck {
    private int cargoBedAngle;

    public Scania() {
        super(2, Color.BLUE, 540, "Scania");
        this.cargoBedAngle = 0;
    }

    public int getCargoBedAngle() {
        return cargoBedAngle;
    }

    public double speedFactor() {
        if (cargoBedAngle == 0) {
            return this.getEnginePower() * 0.01;
        } else {
            return 0;
        }
    }
}