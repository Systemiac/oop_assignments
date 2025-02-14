package vehicles;

import interfaces.IEngine;

public class EngineHandler implements IEngine {
    private double enginePower;
    private double engineSpeed;

    public EngineHandler(double enginePower) {
        this.enginePower = enginePower;
    }

    // properties
    public double getEnginePower() {
        return enginePower;
    }

    public void setCurrentRPM(double engineSpeed) {
        this.engineSpeed = Math.max(engineSpeed, 0);
    }

    public double getCurrentRPM() {
        return engineSpeed;
    }

    public void increaseRPM(double amount) {
        if (amount < 0) return; 
        engineSpeed = Math.min(engineSpeed + amount, enginePower);
    }
    
    public void decreaseRPM(double amount) {
        if (amount < 0) return;
        engineSpeed = Math.max(engineSpeed - amount, 0);
    }

    // methods
    public void startEngine() {
        engineSpeed = 0.1; 
    }

    public void stopEngine() {
        engineSpeed = 0;
    }
}
