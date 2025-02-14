package vehicles;
import java.awt.Color;

public class Volvo240 extends CarPrototype {

    private final static double trimFactor = 1.25;

    public Volvo240() {
        super(4, Color.black, 100, "Volvo240");
    }

    @Override
    public double speedFactor() {
        return getEngine().getEnginePower() * 0.01 * trimFactor;
    }
}
