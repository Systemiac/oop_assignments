package model.vehicles;
import java.awt.Point;

import model.interfaces.IMovable;

public class MovementHandler implements IMovable {
    private double currentSpeed;
    private double posX, posY;
    public enum Direction { north, east, south, west; }
    private Direction dir;
    

    public MovementHandler(Point initialPosition) {
        this.posX = initialPosition.getX();
        this.posY = initialPosition.getY();
        this.dir = Direction.east;
        this.currentSpeed = 0;
    }

    // properties 
    // TODO använd container istället
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

    public void setDir(Direction dir) { // for testing
        this.dir = dir;
    }

    public void move(double distance) { // for testing ...
        if(currentSpeed == 0) {
            return;
        }
        while (distance > 0) {
            move();
            distance -= Math.min(currentSpeed, 1.0);
        }
    }

    @Override
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

    @Override
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

    @Override
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
        currentSpeed += speedFactor * amount;
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
