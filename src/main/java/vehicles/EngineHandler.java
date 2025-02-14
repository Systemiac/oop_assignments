package vehicles;

import interfaces.IEngine;

public class EngineHandler implements IEngine {
    private double enginePower;
    private double engineOutputSpeed;

    public EngineHandler(double enginePower) {
        this.enginePower = enginePower;
    }

    // properties
    public double getEnginePower() {
        return enginePower;
    }

    public void setCurrentRPM(double currentSpeed) {
        this.engineOutputSpeed = currentSpeed;
    }

    public double getCurrentRPM() {
        return engineOutputSpeed;
    }

    public void increaseRPM(double amount) {
        engineOutputSpeed = Math.min(engineOutputSpeed + amount, enginePower);
    }
    
    public void decreaseRPM(double amount) {
        engineOutputSpeed = Math.max(engineOutputSpeed - amount, 0);
    }

    // methods
    public void startEngine() {
        engineOutputSpeed = 0.1;
    }

    public void stopEngine() {
        engineOutputSpeed = 0;
    }
}
