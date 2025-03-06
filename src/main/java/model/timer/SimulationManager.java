package model.timer;


import model.gamelogic.GameHandler;
import model.managers.*;
import model.vehicles.*;
import model.observer.Observable;
import javax.swing.Timer;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulationManager extends Observable{
    private final int delay = 50;
    public final Timer timer = new Timer(delay, new TimerListener());

    private GameHandler gameHandler = new GameHandler();
    private WorkshopManager workshopManager;
    private CarManager carManager;
    private TruckManager truckManager;

    public SimulationManager(CarManager carManager, TruckManager truckManager, WorkshopManager workshopManager) {
        this.carManager = carManager;
        this.truckManager = truckManager;
        this.workshopManager = workshopManager;
    }

    public void startSimulation() {

      
        carManager.startAllEngines();
        truckManager.startAllEngines();
        timer.start();
    }

    public void stopSimulation() {
        carManager.stopAllEngines();
        truckManager.stopAllEngines();
        timer.stop();
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            carManager.moveAllVehicles();
            truckManager.moveAllVehicles();
    
            for (CarPrototype car : carManager.getVehicles()) {
                gameHandler.avoidWall(car);
                workshopManager.handleWorkshopLogic(car);
            }
            for (TruckPrototype truck : truckManager.getVehicles()) {
                gameHandler.avoidWall(truck);
            }
              notifyObservers();
        }
    }
}
