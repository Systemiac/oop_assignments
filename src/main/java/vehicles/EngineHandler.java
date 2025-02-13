package vehicles;

import interfaces.IEngine;
import interfaces.IMovable;

public class EngineHandler implements IEngine {
    private double enginePower;
    private double currentSpeed;

    public EngineHandler(double enginePower) {
        this.enginePower = enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public void incrementSpeed(double amount, double speedFactor, IMovable vehicle) {
        double newSpeed = vehicle.speed() + speedFactor * amount;
        currentSpeed = Math.min(newSpeed, enginePower);
    }

    public void decrementSpeed(double amount, double speedFactor, IMovable vehicle) {
        double newSpeed = vehicle.speed() - speedFactor * amount;
        currentSpeed = Math.max(newSpeed, 0);
    }
}
