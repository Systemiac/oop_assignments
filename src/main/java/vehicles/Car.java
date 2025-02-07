package vehicles;
import java.awt.Color;

abstract class Car extends VehiclePrototype {
    public Car(int nrDoors, Color color, double enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
    }
}