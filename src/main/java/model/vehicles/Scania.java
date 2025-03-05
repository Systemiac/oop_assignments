package model.vehicles;

import java.awt.Color;
import java.awt.Point;

public class Scania extends CargoTruck {
    public Scania(Point initialPoint) {
        super(2, Color.BLUE, 540, "Scania", initialPoint, "/pics/Scania.jpg");
    }

    @Override
    public double speedFactor() {
        if (getCargoBedAngle() == 0) {
            return getEngine().getEnginePower() * 0.01;
        } 
        else {
            return 0;
        }
    }
}