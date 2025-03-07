package model.factories;

import java.awt.Point;
import java.util.Random;

import model.vehicles.CarPrototype;
import model.vehicles.Saab95;
import model.vehicles.Volvo240;

public class CarFactory {
    private static final Random random = new Random();

    public static CarPrototype createCar() {
        int x = random.nextInt(600);
        int y = random.nextInt(300);

        if (random.nextBoolean()) {
            return new Volvo240(new Point(x, y));
        } else {
            return new Saab95(new Point(x, y));
        }
    }
}
