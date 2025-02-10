package vehicles; 

import java.awt.Color;


public class CarTransport extends Truck{
    private int maximumAmountOfCars;
    private int cargoBedAngle;
    private int minAngle;
    private int maxAngle;
    

    public CarTransport(){
        super(2,Color.green,540,"Scania p410");
        this.maximumAmountOfCars = 8;
        
    }

    public double speedFactor(){
        if (getCargoBedAngle() == 0) {
            return getEnginePower() * 0.01;
        } 
        else {
            return 0;
        }
    }

    
    public void raiseCargoBed() {
        cargoBedAngle = maxAngle;
    }

    public void lowerCargoBed(){
        cargoBedAngle = minAngle;
    }

    
}