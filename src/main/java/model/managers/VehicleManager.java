package model.managers;

import model.vehicles.VehiclePrototype;

import java.util.List;

public abstract class VehicleManager<T extends VehiclePrototype>  {
    protected final List<T> vehicles;
    
    public VehicleManager(List<T> vehicles){
        this.vehicles = vehicles;
    }

    public List<T> getVehicles(){
        return vehicles;
    }

    public void startAllEngines(){
        for(T vehicle : vehicles) {
            vehicle.getEngine().startEngine();
        }
    }

    public void stopAllEngines() {
        for(T vehicle : vehicles){
            vehicle.getEngine().stopEngine();
        }
    }

    public void accelerateAll(double amount){
        for(T vehicle : vehicles){
            vehicle.gas(amount);
        }
    }

    public void brakeAll(double amount) {
        for (T vehicle : vehicles) {
            vehicle.brake(amount);
        }
    }

    public void moveAllVehicles(){
        for(T vehicle : vehicles) {
            vehicle.move();
        }
    }

    public void stopAllVehicles() {
        for(T vehicle : vehicles){
            vehicle.stopVehicle();
        }
    }
}