package vehicles;

public class MovementHandler {
    
    private double posX, posY;
    
    public enum Direction {
        north, east, south, west;
    }
    private Direction dir;

    public MovementHandler() {
        this.posX = 0;
        this.posY = 0;
        this.dir = Direction.north;
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

    // S: ändrade currentSpeed() till parameter
    public void move(double currentSpeed) {
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
}
