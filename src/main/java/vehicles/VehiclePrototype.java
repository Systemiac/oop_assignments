package vehicles;

import java.awt.Color;

import interfaces.Chassi;
import interfaces.Engine;
import interfaces.Movable;

public abstract class VehiclePrototype implements Movable, Engine, Chassi {

    private int nrDoors;
    private Color color;
    private String modelName;
    private EngineHandler engine;
    private MovementHandler movement;

    public VehiclePrototype(int nrDoors, Color color, double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.modelName = modelName;
        this.engine = new EngineHandler(enginePower);
        this.movement = new MovementHandler();
        stopEngine();
    }

    public String getModelName() {
        return modelName;
    }

    public int getNrDoors() {
        return nrDoors;
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public double getEnginePower() {
        return engine.getEnginePower();
    }

    public double getCurrentSpeed() {
        return engine.getCurrentSpeed();
    }

    public abstract double speedFactor();

    @Override
    public void move() {
        movement.move(engine.getCurrentSpeed());
    }

    @Override
    public void turnLeft() {
        movement.turnLeft();
    }

    
    public void turnRight() {
        movement.turnRight();
    }

    public void gas(double amount) {
        if (0 <= amount && amount <= 1) {
            engine.incrementSpeed(amount, speedFactor());
        } else
            System.out.println("Invalid input!");
    }

    public void brake(double amount) {

        if (0 <= amount && amount <= 1) {
            engine.decrementSpeed(amount, speedFactor());
        } else
            System.out.println("Invalid input!");
    }

    @Override
    public void startEngine() {
        engine.startEngine();
    }

    @Override
    public void stopEngine() {
        engine.stopEngine();
    }

    public double getPosX() {
        return movement.getPosX();
    }
    
    public double getPosY() {
        return movement.getPosY();
    }
    
    public int getDir() {
        return movement.getDir();
    }
    
}
