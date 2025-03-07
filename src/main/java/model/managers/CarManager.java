package model.managers;

import java.util.List;

import model.interfaces.ITurbo;
import model.vehicles.CarPrototype;

public class CarManager extends VehicleManager<CarPrototype> {

    public CarManager(List<CarPrototype> cars) {
        super(cars);
    }

    public void activateTurbo() {
        for (CarPrototype car : vehicles) {
            if (car instanceof ITurbo) {
                ((ITurbo) car).setTurboOn();
            }
        }
    }

    public void deactivateTurbo() {
        for (CarPrototype car : vehicles) {
            if (car instanceof ITurbo) {
                ((ITurbo) car).setTurboOff();
            }
        }
    }
    public void update(List<CarPrototype> newCars) {
        for (CarPrototype car : newCars) {
            if (!vehicles.contains(car)) {
                vehicles.add(car);
            }
        }
    }
}