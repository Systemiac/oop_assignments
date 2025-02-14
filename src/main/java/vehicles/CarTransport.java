package vehicles;

import java.awt.Color;
import java.util.Stack;

public abstract class CarTransport extends TruckPrototype {
    private int maxCarsInTruck;
    private double offset = 0.5;
    private Stack<CarPrototype> loadedCars = new Stack<>();

    public CarTransport(int nrDoors, Color color, double enginePower, String modelName, int maxCarsInTruck) {
        super(nrDoors, color, enginePower, modelName);
        this.maxCarsInTruck = maxCarsInTruck;
        this.cargoBedAngle = 0;
    }

    public int getCarAmount() {
        return loadedCars.size();
    }

    public Stack<CarPrototype> getStackContent() {
        return loadedCars;
    }

    public double getOffset() {
        return offset + loadedCars.size();
    }

    public boolean setOffset(double newOffset) {
        if (newOffset <= 0) {
            return false;
        }
        this.offset = newOffset;
        return true;
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

    public void loadCar(CarPrototype car) {
        if (loadedCars.size() < maxCarsInTruck
                && getMovement().getCurrentSpeed() == 0
                && cargoBedAngle == maxAngle
                && calculateDistance(getMovement().getPosX(), getMovement().getPosY(), car.getMovement().getPosX(),
                        car.getMovement().getPosY()) < 100) {
            loadedCars.push(car);
            updateCarPositions();
        }
    }

    private static double calculateDistance(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance;
    }

    public void unloadCar() {
        if (loadedCars.size() > 0
                && getMovement().getCurrentSpeed() == 0
                && cargoBedAngle == maxAngle) {
            loadedCars.pop();
            updateCarPositions();
        }
    }

    public void updateCarPositions() {
        double transportX = getMovement().getPosX();
        double transportY = getMovement().getPosY();

        for (int i = 0; i < loadedCars.size(); i++) {
            CarPrototype car = loadedCars.get(i);
            double carX = transportX;
            double carY = transportY + (i + 1) * offset;
            double distance = calculateDistance(transportX, transportY, carX, carY);

            if (distance >= offset) {
                car.getMovement().setPos(carX, carY);
            } else {
                System.out.println("Car " + (i + 1) + " did not move, too close to another car.");
            }
        }
    }

    @Override
    public void move() {
        super.move();
        updateCarPositions();
    }
}