package vehicles;

import java.awt.Color;

public abstract class CargoTruck extends Truck {
    private int cargoBedAngle;
    private int minAngle;
    private int maxAngle;

    public CargoTruck(int nrDoors, Color color, double enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
    }

    
    public void lowerCargoBed(int degree) {
        if (cargoChecker() && cargoBedAngle - degree >= minAngle && degree > 0) {
            cargoBedAngle -= degree;
        }
    }

    public void raiseCargoBed(int degree) {
        if (cargoChecker() && getCargoBedAngle() + degree <= maxAngle && degree > 0) {
            cargoBedAngle += degree;
        }
    }

    
}
