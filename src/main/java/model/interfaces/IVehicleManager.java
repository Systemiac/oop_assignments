package model.interfaces;

import model.vehicles.VehiclePrototype;
import java.util.List;

public interface IVehicleManager {
    void startAllEngines();
    void stopAllEngines();
    void accelerateAll(double amount);
    void brakeAll(double amount);
    void moveAllVehicles();
    void stopAllVehicles();
    List<VehiclePrototype> getVehicles();
}
