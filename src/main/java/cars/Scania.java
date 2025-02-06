package cars;
import java.awt.Color;

public class Scania extends Car{
    private int cargoBedAngle;
    private final int minAngle = 0;
    private final int maxAngle = 70;

    public Scania(){
        super(2, Color.red, 540, "Scania");  
        this.cargoBedAngle=0;
    }

    public int getCargoBedAngle(){
        return cargoBedAngle;
    }

    @Override
    public double speedFactor(){
        if(cargoBedAngle == 0){
            return this.getEnginePower() * 0.01; 
        }
        else{
            return 0;
        }
    }

    public void lowerCargoBed(int degree){
        if(cargoChecker() && cargoBedAngle - degree > minAngle && degree > 0){
            cargoBedAngle -= degree;
        }
    }

    public void raiseCargoBed(int degree){
        if(cargoChecker() && getCargoBedAngle() + degree < maxAngle && degree >0 ){
            cargoBedAngle += degree;
        }
    }

    public boolean cargoChecker(){
        if (getCurrentSpeed() == 0){
            return true;
        }
        else {
            System.out.println("Can't change cargoBedAngle while moving");
            return false;
        }
    }

    

    
}