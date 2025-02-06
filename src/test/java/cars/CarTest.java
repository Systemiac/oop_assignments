package cars;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.Color;

class CarTest {

    private Car testCar;

    @BeforeEach
    void setUp() {
        testCar = new Car(4, Color.RED, 100, "TestCar") {
            @Override
            public double speedFactor() {
                return 1.5;
            }
        };
    }

    @Test
    void testCarInitialization() {
        assertEquals(4, testCar.getNrDoors());
        assertEquals(100, testCar.getEnginePower());
        assertEquals(Color.RED, testCar.getColor());
        assertEquals("TestCar", testCar.getModelName());
    }

    @Test
    void testMoveNorth() {
        testCar.startEngine();
        testCar.move();
        assertTrue(testCar.getPosY() < 0);
    }

    @Test
    void testMoveEastAfterTurnRight() {
        testCar.startEngine();
        testCar.turnRight();
        testCar.move();
        assertTrue(testCar.getPosX() > 0);
    }

    @Test
    void testMoveSouthAfterTwoTurns() {
        testCar.startEngine();
        testCar.turnRight();
        testCar.turnRight();
        testCar.move();
        assertTrue(testCar.getPosY() > 0);
    }

    @Test
    void testTurnLeft() {
        testCar.turnLeft();
        assertEquals(3, testCar.getDir());
    }

    @Test
    void testTurnRight() {
        testCar.turnRight();
        assertEquals(1, testCar.getDir());
    }
}