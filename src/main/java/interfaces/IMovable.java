package interfaces; 

public interface IMovable {
    void move();
    void turnLeft();
    void turnRight();
    void gas(double amount);
    void brake(double amount);
    double speed();
}
