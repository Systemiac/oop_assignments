package application;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import controller.*;
import model.gamelogic.GameHandler;
import model.managers.WorkshopManager;
import model.vehicles.*;
import model.workshops.CarWorkshop;
import view.CarView;

import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulationManager {
    private final int delay = 50;
    public final Timer timer = new Timer(delay, new TimerListener());

    private CarController carController;
    private TruckController truckController;
    private CarView frame;
    private GameHandler gameHandler = new GameHandler();
    private WorkshopManager workshopManager = new WorkshopManager();

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
        workshopManager.addWorkshop(carWorkshop);

        frame = new CarView("CarSim 1.0", carController, truckController, workshopManager);

        carController.startAllCars();
        truckController.startAllTrucks();
        timer.start();
    }

    public void stopSimulation() {
        carController.stopAllCars();
        truckController.stopAllTrucks();
        timer.stop();
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            carController.carManager.moveAllVehicles();
            truckController.truckManager.moveAllVehicles();
    
            for (CarPrototype car : carController.carManager.getVehicles()) {
                gameHandler.avoidWall(car);
                workshopManager.handleWorkshopLogic(car);
            }
            for (TruckPrototype truck : truckController.truckManager.getVehicles()) {
                gameHandler.avoidWall(truck);
            }
            frame.drawPanel.repaint();
        }
    
       
    }
}
