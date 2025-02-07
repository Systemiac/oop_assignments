package vehicles;
import java.awt.Color;
import interfaces.CargoBed;

abstract class Truck extends VehiclePrototype implements CargoBed {
    private int cargoBedAngle;
    private final int minAngle;
    private final int maxAngle;

    public Truck(int nrDoors, Color color, double enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
        this.cargoBedAngle=0;
        this.maxAngle = 70;
        this.minAngle = 0;
    }

    public int getCargoBedAngle() {
        return cargoBedAngle;
    }

    public void lowerCargoBed(int degree){
        if(cargoChecker() && cargoBedAngle - degree >= minAngle && degree > 0){
            cargoBedAngle -= degree;
        }
    }

    public void raiseCargoBed(int degree){
        if(cargoChecker() && getCargoBedAngle() + degree <= maxAngle && degree >0 ){
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