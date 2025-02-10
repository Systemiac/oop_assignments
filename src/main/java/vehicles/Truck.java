package vehicles;
import java.awt.Color;
import interfaces.CargoBed;

abstract class Truck extends VehiclePrototype implements CargoBed {
    private int cargoBedAngle;
    private final int minAngle;
    private final int maxAngle;
    
    public Truck(int nrDoors, Color color, double enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
        this.cargoBedAngle=0;
        this.maxAngle = 70;
        this.minAngle = 0;
    }

    public int getCargoBedAngle(){
        return cargoBedAngle;
    }

    public abstract void raiseCargoBed();

    public abstract void lowerCargoBed();

}