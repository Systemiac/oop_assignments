package model.managers;

import model.vehicles.CarPrototype;
import model.vehicles.VehiclePrototype;
import model.interfaces.IVehicleManager;
import java.util.List;

public class CarManager implements IVehicleManager {
    private final List<CarPrototype> cars;

    public CarManager(List<CarPrototype> cars){
        this.cars = cars;
    }

    @Override
    public void startAllEngines(){
        for(CarPrototype car : cars) {
            car.getEngine().startEngine();
        }
    }

    @Override
    public void stopAllEngines() {
        for(CarPrototype car : cars) {
            car.getEngine().stopEngine();
        }
    }

    @Override
    public void accelerateAll(double amount) {
        for(CarPrototype car : cars) {
            car.gas(amount);
        }
    }

    @Override
    public void brakeAll(double amount) {
        for (CarPrototype car : cars) {
            car.brake(amount);
        }
    }

    @Override
    public void moveAllVehicles() {
        for(CarPrototype car : cars){
            car.move();
        }
    }

    @Override
    public void stopAllVehicles() {
        for(CarPrototype car : cars) {
            car.stopVehicle();
        }
    }

    @Override
    public List<VehiclePrototype> getVehicles() {
        return List.copyOf(cars);
    }

    public void activateTurbo(){
        for(CarPrototype car : cars){
            if(car instanceof ITurbo)
        }
    }
}