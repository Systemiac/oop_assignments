package vehicles;

import java.awt.Color;

import java.util.Stack;
import java.awt.geom.Ellipse2D;

public class CarTransport extends Truck {
    private int maximumAmountOfCars;
    private int cargoBedAngle;
    private int minAngle;
    private int maxAngle;
    private Stack<Car> loadedCars = new Stack<>();
    Ellipse2D.Double pickUpArea = new Ellipse2D.Double(this.getPosX(), this.getPosY(), 100, 100);

    public CarTransport() {
        super(2, Color.green, 540, "Scania p410");
        this.maximumAmountOfCars = 8;
        lowerCargoBed();
    }

    @Override
    public void move(){
        
    }

    public double speedFactor() {
        if (getCargoBedAngle() == 0) {
            return getEnginePower() * 0.01;
        } else {
            return 0;
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

    public void loadCarTransport(Car car) {

        if (loadedCars.size() < maximumAmountOfCars
                && getCurrentSpeed() == 0
                && cargoBedAngle == maxAngle
                && pickUpArea.contains(car.getPosX(), car.getPosY())) {

            loadedCars.push(car);

        }
    }

    public void unloadCarTransport() {
        if (loadedCars.size() > 0 && getCurrentSpeed() == 0 && cargoBedAngle == maxAngle) {
            loadedCars.pop();
        }
    }

}