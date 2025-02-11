package vehicles;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Volvo240Test {

    private Volvo240 testVolvo240;

    @BeforeEach
    void setUp() {
        testVolvo240 = new Volvo240();
    }

    @Test
    public void testConstructor() {
        assertEquals(4, testVolvo240.getNrDoors());
        assertEquals(Color.BLACK, testVolvo240.getColor());
        assertEquals(100, testVolvo240.getEnginePower());
        assertEquals("Volvo240", testVolvo240.getModelName());
    }

    @Test
    public void testSpeedFactor() {
        double expectedFactor = 100 * 0.01 * 1.25;
        assertEquals(expectedFactor, testVolvo240.speedFactor(), 0.01);
    }

    @Test
    public void testSetColor() {
        testVolvo240.setColor(Color.PINK);
        assertEquals(Color.PINK, testVolvo240.getColor());
    }

    @Test
    public void testGetCurrentSpeed() {
        assertEquals(0, testVolvo240.getCurrentSpeed());
    }

    @Test
    public void testGetPosX() {
        assertEquals(0, testVolvo240.getPosX());
    }

    @Test
    public void testGetPosY() {
        assertEquals(0, testVolvo240.getPosY());
    }
}
