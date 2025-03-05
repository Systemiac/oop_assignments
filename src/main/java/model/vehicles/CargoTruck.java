package model.vehicles;

import java.awt.Color;
import java.awt.Point;

public abstract class CargoTruck extends TruckPrototype {

    public CargoTruck(int nrDoors, Color color, double enginePower, String modelName, Point initialPosition, String imagePath) {
        super(nrDoors, color, enginePower, modelName, initialPosition, imagePath);
    }
 
    // methods
    public void raiseCargoBed(int degree) {
        if (degree < 0) {
            System.err.println("Error: Cannot raise cargo bed with a negative value.");
            return;
        }
        if (cargoChecker() && degree > 0) {
            cargoBedAngle += degree;
            System.out.println("CargoBed has been rasied");
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
            System.out.println("CargoBed has been lowered");
            if(cargoBedAngle < minAngle){
                cargoBedAngle = minAngle;
            }
        }
    }   
}
