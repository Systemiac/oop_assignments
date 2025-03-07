package application;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import controller.CarController;
import controller.TruckController;
import model.factories.CarFactory;
import model.managers.WorkshopManager;
import model.timer.SimulationManager;
import model.vehicles.CarPrototype;
import model.vehicles.Scania;
import model.vehicles.TruckPrototype;
import model.vehicles.Volvo240;
import model.workshops.CarWorkshop;
import view.CarView;
import view.DrawPanel;

public class Main {
    public static void main(String[] args) {

        // Skapa fordon
        List<CarPrototype> cars = new ArrayList<>();
        List<TruckPrototype> trucks = new ArrayList<>();

        cars.add(CarFactory.createCar());
        cars.add(CarFactory.createCar());

        trucks.add(new Scania(new Point(0, 200)));

        TruckController truckController = new TruckController(trucks);
        WorkshopManager workshopManager = new WorkshopManager();

        CarWorkshop<Volvo240> workshop = new CarWorkshop<>(3, new Point(200, 0), Volvo240.class);

        workshopManager.addWorkshop(workshop);

        SimulationManager simulation = new SimulationManager(new model.managers.CarManager(cars),
                truckController.truckManager, workshopManager);

        DrawPanel drawPanel = new DrawPanel(800, 560, truckController.truckManager, simulation.getCarManager(),
                workshopManager, simulation);

        CarController carController = new CarController(cars);

        CarView frame = new CarView("CarSim 1.0", carController, truckController, workshopManager, simulation);

        simulation.startSimulation();
    }
}
