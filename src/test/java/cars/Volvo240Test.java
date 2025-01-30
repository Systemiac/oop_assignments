package cars;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Volvo240Test{

    @Test
    public void testConstructor() {
        Volvo240 volvo = new Volvo240();
        assertEquals(4, volvo.getNrDoors(), "Volvo240 ska ha 4 dörrar");
        assertEquals(Color.black, volvo.getColor(), "Volvo240 ska vara svart");
        assertEquals(100, volvo.getEnginePower(), "Volvo240 ska ha 100 hk");
        assertEquals("Volvo240", volvo.getModelName(), "Modellnamnet ska vara Volvo240");
    }

    @Test
    public void testSpeedFactor(){
        Volvo240 volvo = new Volvo240();
        double expectedFactor = 100 * 0.01 *1.25;
        assertEquals(expectedFactor, volvo.speedFactor(), "Speedfactor ska vara 1.25 vid start");

    }

}