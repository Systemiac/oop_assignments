package model.vehicles;

import java.awt.Color;

public abstract class CargoTruck extends TruckPrototype {

    public CargoTruck(int nrDoors, Color color, double enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
    }
 
    // methods
    public void raiseCargoBed(int degree) {
        if (degree < 0) {
            System.err.println("Error: Cannot raise cargo bed with a negative value.");
            return;
        }
        if (cargoChecker() && degree > 0) {
            cargoBedAngle += degree;
            if(cargoBedAngle > maxAngle){
                cargoBedAngle = maxAngle;
            }
        }
    }

    public void lowerCargoBed(int degree) {
        if (degree < 0) {
            System.err.println("Error: Cannot lower cargo bed with a negative value.");
            return;
        } 
        if (cargoChecker()) {
            cargoBedAngle -= degree;
            if(cargoBedAngle < minAngle){
                cargoBedAngle = minAngle;
            }
        }
    }   
}
