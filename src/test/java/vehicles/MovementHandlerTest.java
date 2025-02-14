package vehicles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MovementHandlerTest {

    private MovementHandler testVehicle;

    @BeforeEach
    void setUp() {
        testVehicle = new MovementHandler();
    }

    @Test
    public void testMove() {
        testVehicle.incrementSpeed(1.0, 1.0);
        testVehicle.move(5);
        assertEquals(-5, testVehicle.getPosY());
        testVehicle.turnLeft();
        testVehicle.turnLeft();
        testVehicle.move(5);
        assertEquals(0, testVehicle.getPosY());
        testVehicle.turnRight();
        testVehicle.move(5);
        assertEquals(-5, testVehicle.getPosX());
        testVehicle.turnRight();
        testVehicle.turnRight();
        testVehicle.move(5);
        assertEquals(0, testVehicle.getPosX());
    }

    @Test
    void testMoveNorth() {
        assertEquals(0, testVehicle.getDir(), "Are we facing north?");
        testVehicle.incrementSpeed(1.0, 1.0); // earlier startEnging()
        testVehicle.move();
        assertTrue(testVehicle.getPosY() < 0);
    }

    @Test
    void testMoveEastAfterTurnRight() {
        testVehicle.incrementSpeed(1.0, 1.0);
        testVehicle.turnRight();
        testVehicle.move();
        assertTrue(testVehicle.getPosX() > 0);
    }

    @Test
    void testMoveSouthAfterTwoTurns() {
        testVehicle.incrementSpeed(1.0, 1.0);
        testVehicle.turnRight();
        testVehicle.turnRight();
        testVehicle.move();
        assertTrue(testVehicle.getPosY() > 0);
    }

    @Test
    void testTurnLeft() {
        testVehicle.turnLeft();
        assertEquals(3, testVehicle.getDir());
    }

    @Test
    void testTurnRight() { 
        testVehicle.turnRight();
        assertEquals(1, testVehicle.getDir());
    }

    @Test
    public void testSetPos() {
        testVehicle.setPos(300, 300);
        assertEquals(testVehicle.getPosX(), 300);
        assertEquals(testVehicle.getPosY(), 300);
    }

}
