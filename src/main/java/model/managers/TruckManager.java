package model.managers;

import model.vehicles.TruckPrototype;
import model.vehicles.VehiclePrototype;
import model.interfaces.IVehicleManager;
import java.util.List;

public class TruckManager implements IVehicleManager {
    private final List<TruckPrototype> trucks;

    public TruckManager(List<TruckPrototype> trucks){
        this.trucks = trucks;
    }

    @Override
    public void startAllEngines(){
        for(TruckPrototype truck : trucks) {
            truck.getEngine().startEngine();
        }
    }

    @Override
    public void stopAllEngines() {
        for(TruckPrototype truck : trucks) {
            truck.getEngine().stopEngine();
        }
    }

    @Override
    public void accelerateAll(double amount) {
        for(TruckPrototype truck : trucks) {
            truck.gas(amount);
        }
    }

    @Override
    public void brakeAll(double amount) {
        for (TruckPrototype truck : trucks) {
            truck.brake(amount);
        }
    }

    @Override
    public void moveAllVehicles() {
        for(TruckPrototype truck : trucks){
            truck.move();
        }
    }

    @Override
    public void stopAllVehicles() {
        for(TruckPrototype truck : trucks) {
            truck.stopVehicle();
        }
    }

    @Override
    public List<VehiclePrototype> getVehicles() {
        return List.copyOf(trucks);
    }

}