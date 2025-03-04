package controller;

import model.vehicles.*;
import model.workshops.CarWorkshop;
import model.managers.VehicleManager;
import model.managers.WorkshopManager;

import javax.swing.*;

import application.SimulationManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import view.CarView;
import java.awt.Point;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state [mainly VehiclePrototyp, in our project] and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    public final Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    public CarView frame;
    // A list of cars, modify if needed

    
    
    
    public WorkshopManager workshopManager = new WorkshopManager();

    public VehicleManager vehicleManager = new VehicleManager();

    public SimulationManager simulationManager = new SimulationManager();

    // methods:

    

    /*
     * Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     */
    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (VehiclePrototype car : vehicleManager.getVehicles()) {
                // System.out.println(car.getMovement().getPosX() + " " +
                // car.getMovement().getPosY());
                

                car.move();
                int x = (int) Math.round(car.getMovement().getPosX());
                int y = (int) Math.round(car.getMovement().getPosY());
                frame.drawPanel.getGameHandler().avoidWall(car, x, y);

                for (CarWorkshop workshop : workshopManager.getWorkshops()) {
                    if (workshop.getType() == car.getClass()) {
                        if (!workshop.getCars().contains(car)) {
                            workshop.addCarToWorkshop((CarPrototype) car);
                            System.out.println(workshop.getCars());
                        } else {
                            car.brake(1);
                            car.getEngine().stopEngine();
                        }
                    }
                }
                
                //System.out.println(workshops.get(0).getCars());
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    // Detta ska ju bort härifrån, men jag är inte helt klar än
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (VehiclePrototype car : vehicleManager.getVehicles()) {
            car.gas(gas);
        }
    }

    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (VehiclePrototype car : vehicleManager.getVehicles()) {
            car.brake(brake);
        }
    }

    public void turboOn() {
        for (VehiclePrototype car : vehicleManager.getVehicles()) {
            if (car instanceof Saab95 saab) {
                saab.setTurboOn();
            }
        }
    }
    
    public void turboOff() {
        for (VehiclePrototype car : vehicleManager.getVehicles()) {
            if (car instanceof Saab95 saab) {
                saab.setTurboOff();
            }
        }
    }
    public void liftTruckBed() {
        for (VehiclePrototype truck : vehicleManager.getVehicles()) {
            if (truck instanceof CargoTruck cargoTruck) {
                cargoTruck.raiseCargoBed(70);
            } else if (truck instanceof CarTransport truckTransport) {
                truckTransport.raiseCargoBed();
            }
        }
    }
    
    public void lowerTruckBed() {
        for (VehiclePrototype truck : vehicleManager.getVehicles()) {
            if (truck instanceof CargoTruck cargoTruck) {
                cargoTruck.lowerCargoBed(70);
            } else if (truck instanceof CarTransport truckTransport) {
                truckTransport.lowerCargoBed();
            }
        }
    }

    public void startAllCars() {
        for (VehiclePrototype car : vehicleManager.getVehicles()) {
            car.getEngine().startEngine();
        }
        if (!timer.isRunning()) {
            timer.start();
        }
    }
    

    public void stopAllCars() {
        for (VehiclePrototype car : vehicleManager.getVehicles()) {
            car.getEngine().stopEngine();
            car.getMovement().setCurrentSpeed(0);
        }
        timer.stop();
    }
}