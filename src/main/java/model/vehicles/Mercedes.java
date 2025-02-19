package model.vehicles;

import java.awt.Color;
import java.awt.Point;

public class Mercedes extends CarTransport {

    public Mercedes(Point initialPosition){
        super(2, Color.WHITE, 428 , "Mercedes-Benz Actros 1843", 10, initialPosition);
    }

     public double speedFactor() {
        if (getCargoBedAngle() == 0) {
            return getEngine().getEnginePower() * 0.01;
        } else {
            return 0;
        }
    }
}
