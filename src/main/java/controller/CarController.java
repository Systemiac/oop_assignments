package controller;

import java.util.List;
import java.util.Random;
import model.factories.CarFactory;
import model.managers.CarManager;
import model.vehicles.CarPrototype;
import model.interfaces.ICarControllerListener;


public class CarController {
    public CarManager carManager;
    private ICarControllerListener listener;
    private static final int MAX_CARS = 10;

    public CarController(List<CarPrototype> cars) {
        this.carManager = new CarManager(cars);
    }

    public void setListener(ICarControllerListener listener) {
        this.listener = listener;
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

    public void addCar() {
        if (carManager.getVehicles().size() < MAX_CARS) {
            CarPrototype newCar = CarFactory.createCar();
            carManager.getVehicles().add(newCar);
    
            System.out.println("Added a new car at position: " 
                + newCar.getMovement().getPosX() + ", " + newCar.getMovement().getPosY());

            if (listener != null) {
                listener.onCarListUpdated(carManager.getVehicles());
            }
        } else {
            System.out.println("Max number of cars reached.");
        }
    }
    
    public void removeCar() {
        if (!carManager.getVehicles().isEmpty()) {
            int index = new Random().nextInt(carManager.getVehicles().size());
            CarPrototype removedCar = carManager.getVehicles().remove(index);

            System.out.println("Removed a car: " + removedCar.getClass().getSimpleName());

            if (listener != null) {
                listener.onCarListUpdated(carManager.getVehicles());
            }
        } else {
            System.out.println("No cars to remove.");
        }
    }
}
