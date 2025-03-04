package application;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import controller.*;
import model.vehicles.*;
import model.workshops.CarWorkshop;
import view.CarView;

public class SimulationManager {
    private CarController carController;
    private TruckController truckController;
    private CarView frame;

    public void startSimulation() {
        List<CarPrototype> cars = new ArrayList<>();
        List<TruckPrototype> trucks = new ArrayList<>();

        cars.add(new Volvo240(new Point(0, 0)));
        cars.add(new Saab95(new Point(0, 100)));
        trucks.add(new Scania(new Point(0, 200)));

        carController = new CarController(cars);
        truckController = new TruckController(trucks);
        truckController.lowerTruckBed(70);

        CarWorkshop<Volvo240> carWorkshop = new CarWorkshop<>(3, new Point(200, 0), Volvo240.class);
        carController.workshopManager.addWorkshop(carWorkshop);

        frame = new CarView("CarSim 1.0", carController, truckController);
        carController.setView(frame);
        truckController.setView(frame);

        carController.startAllCars();
        truckController.startAllTrucks();
        carController.timer.start();
        truckController.timer.start();
    }

    public void stopSimulation() {
        carController.stopAllCars();
        truckController.stopAllTrucks();
        carController.timer.stop();
        truckController.timer.stop();
    }
}
