
import vehicles.*;

import workshops.CarWorkshop;

public class Main {
    // main() is only used for testing imlemented code
    public static void main(String[] args) {      
        Saab95 saab = new Saab95();
        Volvo240 volvo_1 = new Volvo240();
        Volvo240 volvo_2 = new Volvo240();
        // Scania scania = new Scania();

        //System.out.println("Saab95 har " + saab.getNrDoors() + " dörrar.");
        //System.out.println("Volvo240 har " + volvo_1.getNrDoors() + " dörrar.");

        CarWorkshop <CarPrototype> volvoWorkshop = new CarWorkshop<>(2);
        volvoWorkshop.addCarToWorkshop(volvo_1);
        volvoWorkshop.addCarToWorkshop(volvo_2);
       
        CarPrototype volvo_4= volvoWorkshop.removeCarFromWorkshop(volvo_1);
        //System.out.println(volvoWorkshop.getCarAmount());
        //System.out.println(volvo_4.toString());
        //System.out.println(volvo_3.toString());
       
        volvoWorkshop.addCarToWorkshop(saab);

        Mercedes mercedes = new Mercedes();
        mercedes.raiseCargoBed();
        mercedes.loadCar(volvo_4);
        System.out.println(mercedes.getCarAmount());
    }
}