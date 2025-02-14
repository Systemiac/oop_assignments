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

    public int getCarAmount() {
        return loadedCars.size();
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
        if (loadedCars.size() < maxCars
                && getMovement().getCurrentSpeed() == 0
                && cargoBedAngle == maxAngle
                && calculateDistance(getMovement().getPosX(), getMovement().getPosY(), car.getMovement().getPosX(), car.getMovement().getPosY()) < 100) {
            loadedCars.push(car);
            updateCarPositions();
        }
    }

    private static double calculateDistance(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(dx * dx + dy * dy);
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

        double offset = 1.5; // avstånd mellan bilar
        double x = getMovement().getPosX();
        double y = getMovement().getPosY();

        for (int i = 0; i < loadedCars.size(); i++) {
            CarPrototype car = loadedCars.get(i);
            double newX = x;
            double newY = y;

            switch (getMovement().getDir()) {
                case 0:
                    newY += (i + 1) * offset;
                    break;
                case 1:
                    newX -= (i + 1) * offset;
                    break;
                case 2:
                    newY -= (i + 1) * offset;
                    break;
                case 3:
                    newX += (i + 1) * offset;
                    break;
            }

            if (calculateDistance(newX, newY, car.getMovement().getPosX(), car.getMovement().getPosY()) > offset) {
                car.getMovement().setPos(newX, newY);
            }
        }
    }
    
    @Override
    public void move() {
        super.move();
        updateCarPositions();
    }
}