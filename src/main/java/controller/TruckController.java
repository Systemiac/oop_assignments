package controller;

import model.vehicles.*;
import model.managers.TruckManager;
import java.util.List;

public class TruckController {
    public TruckManager truckManager;

    public TruckController(List<TruckPrototype> trucks) {
        this.truckManager = new TruckManager(trucks);
    }

    public void liftTruckBed(int amount) {
        truckManager.raiseAllCargoBeds(amount);
    }

    public void lowerTruckBed(int amount) {
        truckManager.lowerAllCargoBeds(amount);
    }

    public void startAllTrucks() {
        truckManager.startAllEngines();

    }

    public void stopAllTrucks() {
        truckManager.stopAllVehicles();

    }

    public void brake(int amount) {
        truckManager.brakeAll(amount / 100.0);
    }
}
