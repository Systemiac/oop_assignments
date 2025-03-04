package model.managers;

import model.interfaces.IVehicleManager;
import model.vehicles.VehiclePrototype;

import java.util.ArrayList;
import java.util.List;

public class VehicleManager implements IVehicleManager {
    private final List<VehiclePrototype> vehicles;
    
    public VehicleManager(List<VehiclePrototype> vehicles){
        this.vehicles = vehicles;
    }

    public VehicleManager(){
        this.vehicles = new ArrayList<>();
    }

    public List<VehiclePrototype> getVehicles(){
        return vehicles;
    }
    public void addVehicle(VehiclePrototype vehicle){
        vehicles.add(vehicle);
    }

    public void startAllEngines(){
        for(VehiclePrototype vehicle : vehicles) {
            vehicle.getEngine().startEngine();
        }
    }

    public void stopAllEngines() {
        for(VehiclePrototype vehicle : vehicles){
            vehicle.getEngine().startEngine();
        }
    }

    public void accelerateAll(double amount){
        for(VehiclePrototype vehicle : vehicles){
            vehicle.gas(amount);
        }
    }

    public void brakeAll(double amount) {
        for (VehiclePrototype vehicle : vehicles) {
            vehicle.brake(amount);
        }
    }

    public void moveAllVehicles(){
        for(VehiclePrototype vehicle : vehicles) {
            vehicle.move();
        }
    }

    public void stopAllVehicles() {
        for(VehiclePrototype vehicle : vehicles){
            vehicle.stopVehicle();
        }
    }
}