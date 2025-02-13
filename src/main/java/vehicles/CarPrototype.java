package vehicles;
import java.awt.Color;

public abstract class CarPrototype extends VehiclePrototype {
    public CarPrototype(int nrDoors, Color color, double enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
    }
}