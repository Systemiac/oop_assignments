package model.managers;

import java.util.ArrayList;
import java.util.List;

import model.vehicles.CarPrototype;
import model.workshops.CarWorkshop;

public class WorkshopManager {

    private List<CarWorkshop> workshops;

    public WorkshopManager(List<CarWorkshop> workshops) {
        this.workshops = workshops;
    }

    public WorkshopManager() {
        workshops = new ArrayList<CarWorkshop>();
    }

    public List<CarWorkshop> getWorkshops() {
        return workshops;
    }

    public void addWorkshop(CarWorkshop workshop) {
        workshops.add(workshop);
    }

    public void handleWorkshopLogic(CarPrototype car) {
        for (CarWorkshop workshop : workshops) {
            if (workshop.getType() == car.getClass()) {
                if (!workshop.getCars().contains(car)) {
                    workshop.addCarToWorkshop(car);
                    // System.out.println(workshop.getCars());
                } else {
                    car.brake(1);
                    car.getEngine().stopEngine();
                }
            }
        }
    }
}
