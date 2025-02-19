package controller;

import model.vehicles.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
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
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<VehiclePrototype> vehicles = new ArrayList<>();

    // methods:

    // TODO: need to add cars into the lists in drawPanel when creating instances
    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        Point volvoStart = new Point(0,0);
        Point saabStart = new Point(0,100);

        cc.vehicles.add(new Volvo240(volvoStart));
        cc.vehicles.add(new Saab95((saabStart)));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
        // cc.frame.setController(cc);

        // Start the timer
        cc.timer.start();
    }

    /*
     * Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (VehiclePrototype car : vehicles) {
                System.out.println(car.getMovement().getPosX() + " " + car.getMovement().getPosY());

                car.move();
                int x = (int) Math.round(car.getMovement().getPosX());
                int y = (int) Math.round(car.getMovement().getPosY());
                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (VehiclePrototype car : vehicles) {
            car.gas(gas);
        }
    }

    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (VehiclePrototype car : vehicles) {
            car.brake(brake);
        }
    }

    public void turboOn() {
        for (VehiclePrototype car : vehicles) {

            try {

                Method method = car.getClass().getMethod("setTurboOn");

                method.invoke(car);

            } catch (NoSuchMethodException ex) {
                // Handle the case where the method is not found

                System.out.println(car.getModelName() + "does not have method 'setTurboOff'");
            } catch (Exception ex) {
                // Handle other exceptions (like IllegalAccessException,
                // InvocationTargetException, etc.)
                ex.printStackTrace();
            }
        }

    }

    public void turboOff() {
        for (VehiclePrototype car : vehicles) {

            try {

                Method method = car.getClass().getMethod("setTurboOff");

                method.invoke(car);

            } catch (NoSuchMethodException ex) {
                // Handle the case where the method is not found
                // TODO: Fix better name on car
                System.out.println(car.getModelName() + "does not have method 'setTurboOff'");
            } catch (Exception ex) {
                // Handle other exceptions (like IllegalAccessException,
                // InvocationTargetException, etc.)
                ex.printStackTrace();
            }
        }
    }

    public void liftTruckBed() {
        for (VehiclePrototype truck : vehicles) {
            if (truck instanceof CargoTruck) {
                ((CargoTruck) truck).raiseCargoBed(70);
            }
            else if (truck instanceof CarTransport) {
                ((CarTransport) truck).raiseCargoBed();
            }
        }
    }

    public void lowerTruckBed() {
        for (VehiclePrototype truck : vehicles) {
            if(truck instanceof CargoTruck){
                ((CargoTruck)truck).lowerCargoBed(70);
            }
            else if(truck instanceof CarTransport){
                ((CarTransport)truck).lowerCargoBed();
            }
        }
    }

    public void startAllCars () {
        for (VehiclePrototype car : vehicles) {
            car.getEngine().startEngine();
        }
    }

    public void stopAllCars () {
        for (VehiclePrototype car : vehicles) {
            car.getEngine().stopEngine();
        }
    }
}