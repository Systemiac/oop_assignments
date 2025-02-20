package model.vehicles;

import java.awt.*;

public class Saab95 extends CarPrototype {

    private boolean turboOn;

    public Saab95(Point initialPosition) {
        super(2, Color.RED, 125, "Saab95", initialPosition, "/pics/Saab95.jpg");
        turboOn = false;
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn)
            turbo = 1.3;
        return getEngine().getEnginePower() * 0.01 * turbo;
    }
}