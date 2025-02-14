package vehicles;

import java.awt.Color;
import interfaces.IChassi;

public abstract class VehiclePrototype implements IChassi {
    private int nrDoors;
    private Color color;
    private String modelName;
    private EngineHandler engine;
    private MovementHandler movement;
    private double maxSpeed = calculateMaxSpeed();

    public VehiclePrototype(int nrDoors, Color color, double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.modelName = modelName;
        this.engine = new EngineHandler(enginePower);
        this.movement = new MovementHandler(engine);
        
    }

    // properties
    public String getModelName() {
        return modelName;
    }

    public EngineHandler getEngine() {
        return engine;
    }

    public MovementHandler getMovement() {
        return movement;
    }

    public void move() {
        movement.move();
    }

    // methods
    public abstract double speedFactor();

    public void gas(double amount) {
        if (0 <= amount && amount <= 1) {
            double acceleration = speedFactor() * engine.getEnginePower() * amount;
            double newSpeed = movement.getCurrentSpeed() + acceleration;
            if (newSpeed <= maxSpeed) {
                movement.incrementSpeed(amount, acceleration);
            }
        } else
            System.out.println("Invalid gas input: " + amount);
    }

    public void brake(double amount) {
        if (0 <= amount && amount <= 1) {
            double deceleration = speedFactor() * engine.getEnginePower() * amount;
            movement.decrementSpeed(amount, deceleration);
        } else
            System.out.println("Invalid brake input: " + amount);
    }

    public double getSpeed() {
        return movement.getCurrentSpeed();
    }

    private double calculateMaxSpeed() {
        return engine.getEnginePower() * 2; // Vettigt?
    }
    
    @Override
    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    @Override
    public int getNrDoors() {
        return nrDoors;
    }
}
