package vehicles;
import interfaces.IMovable;

public class MovementHandler implements IMovable {
    private double currentSpeed;
    private double posX, posY;
    public enum Direction { north, east, south, west; }
    private Direction dir;

    public MovementHandler() {
        this.posX = 0;
        this.posY = 0;
        this.dir = Direction.north;
        this.currentSpeed = 0;
    }

    // properties
    public void setPos(double x, double y){
        posX = x;
        posY = y;
    }

    public double getPosX(){
        return posX;
    }

    public double getPosY(){
	    return  posY;
    }

    public int getDir(){
        return dir.ordinal();
    }

    public void move(double distance) { // testing ...
        if(currentSpeed == 0) {
            return;
        }
        while (distance > 0) {
            move();
            distance -= Math.min(currentSpeed, 1.0);
        }
    }

    public void move() {
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

    public void incrementSpeed(double amount, double speedFactor) {
        currentSpeed += speedFactor * amount; // maxSpeed bestäms i VehiclePrototype
    }

    public void decrementSpeed(double amount, double speedFactor) {

        currentSpeed = Math.max(currentSpeed - speedFactor * amount, 0);
    }

    @Override
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed){
        this.currentSpeed = currentSpeed;
    }
}
