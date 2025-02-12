package vehicles;

import java.awt.Color;
import java.util.Stack;


public abstract class CarTransport extends Truck {
    private int maxCars;

    private Stack<Car> loadedCars = new Stack<>();

    public CarTransport(int nrDoors, Color color, double enginePower, String modelName, int maxCars) {
        super(nrDoors,color,enginePower,modelName);
        this.maxCars = maxCars;
        this.cargoBedAngle=0;
    }

    @Override
    public void move() {
        super.move();
        for (Car car : loadedCars) {
            car.setPos(getPosX(), getPosY());
        }
    }

   

    public void raiseCargoBed() {
        if (cargoChecker() && cargoBedAngle == minAngle) {
            cargoBedAngle = maxAngle;
        }
    }

    public void lowerCargoBed() {
        if (cargoChecker() && cargoBedAngle == maxAngle) {
            cargoBedAngle = minAngle;
        }
    }

    public void loadCar(Car car) {

        if (loadedCars.size() < maxCars
                && getCurrentSpeed() == 0
                && cargoBedAngle == maxAngle
                && calculateDistance(getPosX(), getPosY(), car.getPosX(), car.getPosY()) < 100) {

            loadedCars.push(car);
        }
    }
    
    private static double calculateDistance(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public void unloadCar() {
        if (loadedCars.size() > 0 && getCurrentSpeed() == 0 && cargoBedAngle == maxAngle) {
            loadedCars.pop();
        }
    }

    public int getCarAmount(){
        return loadedCars.size();
    }
}