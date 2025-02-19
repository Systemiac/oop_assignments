package model.vehicles;
import java.awt.Color;
import java.awt.Point;

public abstract class CarPrototype extends VehiclePrototype {
    public CarPrototype(int nrDoors, Color color, double enginePower, String modelName, Point initialPosition) {
        super(nrDoors, color, enginePower, modelName, initialPosition);
    }
}