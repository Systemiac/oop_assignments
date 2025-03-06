package application;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import controller.CarController;
import controller.TruckController;
import model.managers.WorkshopManager;
import model.timer.SimulationManager;
import model.vehicles.CarPrototype;
import model.vehicles.Saab95;
import model.vehicles.Scania;
import model.vehicles.TruckPrototype;
import model.vehicles.Volvo240;
import model.workshops.CarWorkshop;
import view.CarView;

public class Main {
    public static void main(String[] args) {

        List<CarPrototype> cars = new ArrayList<>();
        List<TruckPrototype> trucks = new ArrayList<>();

        cars.add(new Volvo240(new Point(0, 0)));
        cars.add(new Saab95(new Point(0, 100)));
        trucks.add(new Scania(new Point(0, 200)));

        CarWorkshop workshop = new CarWorkshop<>(3, new Point(200, 0), Volvo240.class);

        CarController carController= new CarController(cars);
        TruckController truckController= new TruckController(trucks);
        WorkshopManager workshopManager = new WorkshopManager();

        workshopManager.addWorkshop(workshop);
        SimulationManager simulation = new SimulationManager(carController.carManager, truckController.truckManager, workshopManager);
        CarView frame = new CarView("CarSim 1.0", carController, truckController, workshopManager, simulation);


        simulation.startSimulation();
    }
}
