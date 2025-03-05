package model.vehicles;

import model.interfaces.IEngine;

public class EngineHandler implements IEngine {
    private final double enginePower;
    public int engineOn;

    public EngineHandler(double enginePower) {
        this.enginePower = enginePower;
        this.engineOn=0;
    }

    // properties
    public double getEnginePower() {
        return enginePower;
    }    

    public double getEngineOn() {
        return engineOn;
    }    

    
    // methods
    
    public void startEngine() {
            engineOn=1;
    }

    
    public void stopEngine() {
        engineOn=0;
    }
}
