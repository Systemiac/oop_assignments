package model.vehicles;
import java.awt.Color;
import java.awt.Point;

abstract class TruckPrototype extends VehiclePrototype {
    protected int cargoBedAngle;
    protected static final int maxAngle =70;
    protected static final int minAngle = 0;
    
    public TruckPrototype(int nrDoors, Color color, double enginePower, String modelName, Point initialPosition) {
        super(nrDoors, color, enginePower, modelName, initialPosition);
        this.cargoBedAngle=0;
    
    }

    // properties
    public int getCargoBedAngle(){
        return cargoBedAngle;
    }

    public int getMaxAngle(){
        return maxAngle;
    }

    public int getMinAngle() {
        return minAngle;
    }

    // methods
    protected boolean cargoChecker() {
        if (getMovement().getCurrentSpeed() == 0) {
            return true;
        } else {
            System.out.println("Can't change cargoBedAngle while moving");
            return false;
        }
    }
}