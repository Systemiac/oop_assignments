package controller;

import model.vehicles.*;
import model.workshops.CarWorkshop;
import model.managers.CarManager;
import model.managers.WorkshopManager;

import javax.swing.*;

import application.SimulationManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.BoundaryHandler;
import view.CarView;
import java.util.List;


public class CarController {
    private final int delay = 50;
    public final Timer timer = new Timer(delay, new TimerListener());
    public CarView frame;
    
    public WorkshopManager workshopManager = new WorkshopManager();
    public SimulationManager simulationManager = new SimulationManager();
    public CarManager carManager;
    private BoundaryHandler boundaryHandler;

    public CarController(List<CarPrototype> cars) {
        this.carManager = new CarManager(cars);
    }

    public void setView(CarView frame){
        this.frame = frame;
        if(this.boundaryHandler == null) {
            this.boundaryHandler = new BoundaryHandler(frame.drawPanel.getWidth(), frame.drawPanel.getHeight());
        }
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            carManager.moveAllVehicles();
    
            for (CarPrototype car : carManager.getVehicles()) {
                boundaryHandler.keepWithinBounds(car);
                handleWorkshopLogic(car);
            }
            frame.drawPanel.repaint();
        }
    
        private void handleWorkshopLogic(CarPrototype car) {
            for (CarWorkshop workshop : workshopManager.getWorkshops()) {
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

    public void gas(int amount) {
        carManager.accelerateAll(amount / 100.0);
    }

    public void brake(int amount) {
        carManager.brakeAll(amount / 100.0);
    }

    public void turboOn() {
        carManager.activateTurbo();
    }

    public void turboOff() {
        carManager.deactivateTurbo();
    }

    public void startAllCars() {
        carManager.startAllEngines();
        if(!timer.isRunning()) {
            timer.start();
        }
    }
    
    public void stopAllCars() {
        carManager.stopAllEngines();
        timer.stop();
    }
}