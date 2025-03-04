package application;

import java.awt.Point;

import controller.CarController;
import model.vehicles.Saab95;
import model.vehicles.Scania;
import model.vehicles.Volvo240;
import model.workshops.CarWorkshop;
import view.CarView;

public class Main {

    // main() is only used for testing imlemented code
    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.vehicleManager.getVehicles().add(new Volvo240(new Point(0,0)));
        cc.vehicleManager.getVehicles().add(new Saab95(new Point(0,100)));
        cc.vehicleManager.getVehicles().add(new Scania(new Point(0, 200)));
        
        CarWorkshop<Volvo240> carWorkshop =new CarWorkshop<Volvo240>(3,new Point(200,0),Volvo240.class);
        cc.workshopManager.addWorkshop(carWorkshop);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
        // cc.frame.setController(cc);

        // Start the timer
        cc.timer.start();
    }
}