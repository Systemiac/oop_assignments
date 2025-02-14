package vehicles;

import interfaces.IEngine;

public class EngineHandler implements IEngine {
    private double enginePower;
    private double engineOutputSpeed = 0;

    public EngineHandler(double enginePower) {
        this.enginePower = enginePower;
    }

    // properties
    public double getEnginePower() {
        return enginePower;
    }

    public void setCurrentEngineOutputSpeed(double currentSpeed) {
        this.engineOutputSpeed = currentSpeed;
    }

    public double getCurrentEngineOutputSpeed() {
        return engineOutputSpeed;
    }

    // methods
    public void startEngine() {
        engineOutputSpeed = 0.1;
    }

    public void stopEngine() {
        engineOutputSpeed = 0;
    }
}
