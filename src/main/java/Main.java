import vehicles.Saab95;
import vehicles.Volvo240;

public class Main {
    public static void main(String[] args) {
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();

        System.out.println("Saab95 har " + saab.getNrDoors() + " dörrar.");
        System.out.println("Volvo240 har " + volvo.getNrDoors() + " dörrar.");
    }
}
