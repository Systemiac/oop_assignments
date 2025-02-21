package model.vehicles;

import model.interfaces.IEngine;

public class EngineHandler implements IEngine {
    private final double enginePower;
    private double engineSpeed;
    public int engineOn;

    public EngineHandler(double enginePower) {
        this.enginePower = enginePower;
        this.engineOn=0;
    }

    // properties
    @Override
    public double getEnginePower() {
        return enginePower;
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
    @Override
    public void startEngine() {
        if(engineSpeed == 0) {
            engineSpeed = 0.1; 
            engineOn=1;
        }
    }

    @Override
    public void stopEngine() {
        engineSpeed = 0;
        engineOn=0;
    }
}
