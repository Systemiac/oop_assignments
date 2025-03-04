package model.managers;

import model.vehicles.CarPrototype;
import model.interfaces.ITurbo;
import java.util.List;

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
}