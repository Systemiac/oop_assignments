package cars;
import java.awt.*;

public abstract class Car implements IVehicle, Movable {
    
    protected int nrDoors; // Number of doors on the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected double enginePower; // Engine power of the car
    protected String modelName;
    protected double posX, posY;
    protected enum Direction {
        north, east, south, west;
    }
    private Direction dir;
 
    public Car(int nrDoors,Color color, double enginePower, String modelName){
        this.nrDoors=nrDoors;
        this.color=color;
        this.enginePower=enginePower;
        this.modelName=modelName;
        this.posX = 0;
        this.posY = 0;
        this.dir = Direction.north;
        stopEngine();
    }

    public abstract double speedFactor();

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
	    color = clr;
    }

    public void startEngine(){
	    currentSpeed = 0.1;
    }

    public void stopEngine(){
	    currentSpeed = 0;
    }

    public void move(){
        switch (dir) {
            case north:
                posY -= currentSpeed;
                break;
            case west:
                posX -= currentSpeed;
                break;
            case south:
                posY += currentSpeed;
                break;
            case east:
                posX += currentSpeed;
                break;
        }
    }

    public void turnLeft() {
        switch (dir) {
            case north:
                dir = Direction.west;
                break;
            case west:
                dir = Direction.south;
                break;
            case south:
                dir = Direction.east;
                break;
            case east:
                dir = Direction.north;
                break;
        }
    }

    public void turnRight() {
        switch (dir) {
            case north:
                dir = Direction.east;
                break;
            case west:
                dir = Direction.north;
                break;
            case south:
                dir = Direction.west;
                break;
            case east:
                dir = Direction.south;
                break;
        }
    }
    
    public void gas(double amount){
        if (0 <= amount && amount <= 1){
            incrementSpeed(amount);
        }
        else System.out.println("Invalid input!");
    }

    
    public void brake(double amount){
        
        if (0 <= amount && amount <= 1){
            decrementSpeed(amount);
        }
        else System.out.println("Invalid input!");
    }

    public void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }
    
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }
}
