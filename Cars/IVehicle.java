package cars;

public interface IVehicle {
    int getNrDoors();
    double getEnginePower();
    double getCurrentSpeed();
    void startEngine();
    void stopEngine();
}