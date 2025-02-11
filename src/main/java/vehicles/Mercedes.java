package vehicles;

import java.awt.Color;

public class Mercedes extends CarTransport {

    public Mercedes(){
        super(2, Color.WHITE, 428 , "Mercedes-Benz Actros 1843", 10);
    }

     public double speedFactor() {
        if (getCargoBedAngle() == 0) {
            return getEnginePower() * 0.01;
        } else {
            return 0;
        }
    }
}
