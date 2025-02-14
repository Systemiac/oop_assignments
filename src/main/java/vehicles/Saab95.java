package vehicles;
import java.awt.*;

public class Saab95 extends CarPrototype {

    private boolean turboOn;

    public Saab95() {
        super(2, Color.RED, 125, "Saab95");
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