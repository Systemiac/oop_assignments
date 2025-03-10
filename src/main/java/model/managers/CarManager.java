package model.managers;

import java.util.List;
import java.util.Random;

import model.factories.CarFactory;
import model.interfaces.ICarControllerListener;
import model.interfaces.ITurbo;
import model.vehicles.CarPrototype;

public class CarManager extends VehicleManager<CarPrototype> {
    
    private static final int MAX_CARS = 10;
    
    private ICarControllerListener listener;

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

    public void addCar(){
        if (getVehicles().size() < MAX_CARS) {
            Random rand = new Random();
            
            CarPrototype newCar = CarFactory.createCar(rand.nextInt(2));
            getVehicles().add(newCar);
    
            System.out.println("Added a new car at position: " 
                + newCar.getMovement().getPosX() + ", " + newCar.getMovement().getPosY());

            if (listener != null) {
                listener.onCarListUpdated(getVehicles());
            }
        } else {
            System.out.println("Max number of cars reached.");
        }
    }

    public void removeCar(){
        if (!getVehicles().isEmpty()) {
            int index = new Random().nextInt(getVehicles().size());
            CarPrototype removedCar = getVehicles().remove(index);

            System.out.println("Removed a car: " + removedCar.getClass().getSimpleName());

            if (listener != null) {
                listener.onCarListUpdated(getVehicles());
            }
        } else {
            System.out.println("No cars to remove.");
        }
    }
}