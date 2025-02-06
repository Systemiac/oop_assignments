package interfaces;

public interface MotorVehicle {
    int getNrDoors();
    double getEnginePower();
    double getCurrentSpeed();
    void startEngine();
    void stopEngine();
}