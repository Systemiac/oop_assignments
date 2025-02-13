package vehicles;

import java.awt.Color;
import java.util.Stack;

public abstract class CarTransport extends TruckPrototype {
    private int maxCars;

    private Stack<CarPrototype> loadedCars = new Stack<>();

    public CarTransport(int nrDoors, Color color, double enginePower, String modelName, int maxCars) {
        super(nrDoors, color, enginePower, modelName);
        this.maxCars = maxCars;
        this.cargoBedAngle = 0;
    }

    // properties
    public int getCarAmount() {
        return loadedCars.size();
    }

    // methods
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

    public void loadCar(CarPrototype car) {

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

    @Override
    public void move() {
        super.move();
        for (CarPrototype car : loadedCars) {
            car.setPos(getPosX(), getPosY());
        }
    }
}