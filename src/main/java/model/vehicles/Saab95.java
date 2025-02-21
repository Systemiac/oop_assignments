package model.vehicles;

import java.awt.Color;
import java.awt.Point;

public class Saab95 extends CarPrototype {

    private boolean turboOn;
    private final double turboMultiplier = 5;
    private double ordinarySpeed;
    private double turboeffect;
    
    public Saab95(Point initialPosition) {
        super(2, Color.RED, 125, "Saab95", initialPosition, "/pics/Saab95.jpg");
        turboOn = false;
    }
    
    public void setTurboOn() {
        if (!turboOn) {
            turboOn = true;
            System.out.println("Turbo is on!");
            ordinarySpeed = getMovement().getCurrentSpeed();
            turboeffect = ordinarySpeed * turboMultiplier;
            getMovement().setCurrentSpeed(turboeffect);
        } else {
            System.out.println("Turbo is already on.");
        }
    }

    public void setTurboOff() {
        if (turboOn) {
            turboOn = false;
            System.out.println("Turbo is off");

            getMovement().setCurrentSpeed(ordinarySpeed);
        }
    }
    
    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn)
            turbo = 1.3;
        return getEngine().getEnginePower() * 0.01 * turbo;
    }
}