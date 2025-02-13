package vehicles;
import java.awt.Color;
import interfaces.IChassi;

public abstract class VehiclePrototype implements IChassi {

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

    @Override
    public int getNrDoors() {
        return nrDoors;
    }
    
    public void setPos(double x, double y){
        movement.setPos(x,y);
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

    @Override
    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }
    
    public abstract double speedFactor();
}
