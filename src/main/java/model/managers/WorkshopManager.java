package model.managers;

import java.util.ArrayList;
import java.util.List;

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

}
