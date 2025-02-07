package vehicles; 

import java.awt.Color;


public class CarTransport extends Truck{
   
    public CarTransport(){
        super(2,Color.green,540,"Scania p410");
    }

    public double speedFactor(){
        if (getCargoBedAngle() == 0) {
            return getEnginePower() * 0.01;
        } 
        else {
            return 0;
        }
    }
}