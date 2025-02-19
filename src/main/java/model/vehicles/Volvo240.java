package model.vehicles;

import java.awt.Color;
import java.awt.Point;


public class Volvo240 extends CarPrototype {

    private final static double trimFactor = 1.25;
   

    public Volvo240(Point initialPosition) {
        super(4, Color.black, 100, "Volvo240", initialPosition);
        
    }

    @Override
    public double speedFactor() {
        return getEngine().getEnginePower() * 0.01 * trimFactor;
    }
}
