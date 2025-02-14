package interfaces; 

public interface IMovable {
    void move(double currentSpeed);
    void turnLeft();
    void turnRight();
    double getCurrentSpeed();
}
