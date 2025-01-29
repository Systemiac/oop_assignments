package cars;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.*;

public class Saab95Test {

    @Test
    public void testConstructor() {
        Saab95 saab = new Saab95();
        assertEquals(2, saab.getNrDoors(), "Saab95 ska ha 2 dörrar");
        assertEquals(Color.red, saab.getColor(), "Saab95 ska vara röd");
        assertEquals(125, saab.getEnginePower(), "Saab95 ska ha 125 hk");
        assertEquals("Saab95", saab.getModelName(), "Modellnamnet ska vara Saab95");
    }

    @Test
    public void testSetTurboOn() {
        Saab95 saab = new Saab95();
        saab.setTurboOn();
        assertEquals(1.3, saab.speedFactor() / (saab.getEnginePower() * 0.01), 0.0001,
                     "Turbo ska öka speedFactor till 1.3 gånger");
    }

    @Test
    public void testSetTurboOff() {
        Saab95 saab = new Saab95();
        saab.setTurboOn(); // Sätter på turbon först
        saab.setTurboOff();
        assertEquals(1.0, saab.speedFactor() / (saab.getEnginePower() * 0.01), 0.0001,
                     "Turbo ska vara avstängd och speedFactor ska vara normalt");
    }

    @Test
    public void testSpeedFactorWithTurbo() {
        Saab95 saab = new Saab95();
        saab.setTurboOn();
        double expectedFactor = 125 * 0.01 * 1.3;
        assertEquals(expectedFactor, saab.speedFactor(), 0.0001,
                     "SpeedFactor ska öka när turbo är på");
    }

    @Test
    public void testSpeedFactorWithoutTurbo() {
        Saab95 saab = new Saab95();
        saab.setTurboOff();
        double expectedFactor = 125 * 0.01 * 1.0;
        assertEquals(expectedFactor, saab.speedFactor(), 0.0001,
                     "SpeedFactor ska vara normalt när turbo är av");
    }
}
