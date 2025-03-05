package controller;

import model.vehicles.*;
import model.managers.CarManager;
import java.util.List;


public class CarController {
    public CarManager carManager;

    public CarController(List<CarPrototype> cars) {
        this.carManager = new CarManager(cars);
    }


    public void gas(int amount) {
        carManager.accelerateAll(amount / 100.0);
    }

    public void brake(int amount) {
        carManager.brakeAll(amount / 100.0);
    }

    public void turboOn() {
        carManager.activateTurbo();
    }

    public void turboOff() {
        carManager.deactivateTurbo();
    }

    public void startAllCars() {
        carManager.startAllEngines();
    }
    
    public void stopAllCars() {
        carManager.stopAllVehicles();
    }
}