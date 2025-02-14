package vehicles;

import java.awt.Color;
import interfaces.IChassi;

public abstract class VehiclePrototype implements IChassi {
    private double speed;
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
        movement.move(getMovement().getCurrentSpeed());
    }

    // methods
    public abstract double speedFactor();

    public void gas(double amount) {
        if (0 <= amount && amount <= 1) {
            engine.incrementSpeed(amount, movement.getCurrentSpeed());
        } else
            System.out.println("Invalid gas input: " + amount);
    }
    
    public void brake(double amount) {

        if (0 <= amount && amount <= 1) {
            engine.decrementSpeed(amount, engine.getCurrentSpeed());
        } else
            System.out.println("Invalid brake input: " + amount);
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
