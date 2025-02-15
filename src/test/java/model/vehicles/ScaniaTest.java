package vehicles;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Color;

class ScaniaTest {

    private Scania scania;

    @BeforeEach
    void setUp() {
        scania = new Scania();
    }

    @Test
    public void testConstructor() {
        assertEquals(2, scania.getNrDoors(), "Scania ska ha 2 dörrar");
        assertEquals(Color.blue, scania.getColor(), "Scania ska vara blå");
        assertEquals(540, scania.getEngine().getEnginePower(), "Scania ska ha 540 hk");
        assertEquals("Scania", scania.getModelName(), "Modellnamnet ska vara Scania");
    }

    @Test
    public void testGetCargoBedAngle() {
        assertEquals(scania.getCargoBedAngle(), 0);
    }
    
    @Test
    public void testSpeedFactor() {
        assertEquals(5.40, scania.speedFactor());
        scania.raiseCargoBed(45);
        
        assertEquals(0, scania.speedFactor());
    }

}