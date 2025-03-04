package model.managers;

import model.vehicles.TruckPrototype;
import model.vehicles.CargoTruck;
import java.util.List;

public class TruckManager extends VehicleManager<TruckPrototype> {

    public TruckManager(List<TruckPrototype> trucks) {
        super(trucks);
    }

    public void raiseAllCargoBeds(int amount) {
        for (TruckPrototype truck : vehicles) {
            if (truck instanceof CargoTruck) {
                ((CargoTruck) truck).raiseCargoBed(amount);
            }
        }
    }

    public void lowerAllCargoBeds(int amount) {
        for (TruckPrototype truck : vehicles) {
            if (truck instanceof CargoTruck) {
                ((CargoTruck) truck).lowerCargoBed(amount);
            }
        }
    }
}
