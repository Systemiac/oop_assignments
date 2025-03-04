package model.vehicles;

import java.awt.Color;
import java.awt.Point;

import model.interfaces.IChassi;

public abstract class VehiclePrototype implements IChassi {
    private final int nrDoors;
    private Color color;
    private final String modelName;
    private final double maxSpeed;
    private final EngineHandler engine;
    private final MovementHandler movement;
    private final String imagePath;


    public VehiclePrototype(int nrDoors, Color color, double enginePower, String modelName, Point initialPosition, String imagePath) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.modelName = modelName;
        this.engine = new EngineHandler(enginePower);
        this.movement = new MovementHandler(initialPosition);
        this.maxSpeed = calculateMaxSpeed();
        this.imagePath=imagePath;
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

    // methods
    public abstract double speedFactor();

    public void move() {
        movement.move();
    }

    public void gas(double amount) {
        if (betweenZeroAndOne(amount)) {
            double acceleration = speedFactor() * engine.getEnginePower() * amount * engine.engineOn;
            double newSpeed = movement.getCurrentSpeed() + acceleration;

            if (newSpeed <= maxSpeed) {
                movement.incrementSpeed(amount, acceleration);
            }
        } else
            System.out.println("Invalid gas input: " + amount);
    }

   
    public void brake(double amount) {
        if (betweenZeroAndOne(amount)) {
            double deceleration = speedFactor() * engine.getEnginePower() * amount;
            deceleration = Math.min(deceleration, movement.getCurrentSpeed() / 0.2); // Begränsa bromsningen per steg
            movement.decrementSpeed(amount, deceleration);
        } else {
            System.out.println("Invalid brake input: " + amount);
        }
    }
    

    private boolean betweenZeroAndOne(double amount) {
        return (0 <= amount && amount <= 1);
    }

    public void stopVehicle() { 
        getEngine().stopEngine();
        getMovement().setCurrentSpeed(0);
    }

    private double calculateMaxSpeed() {
        if (engine == null) {
            throw new IllegalStateException("Engine is null when calculating max speed!");
        }
        return engine.getEnginePower() * 2;
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

    public String getImagePath(){
        return imagePath;
    }
}
