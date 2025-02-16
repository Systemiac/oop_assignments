package model.vehicles;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.vehicles.MovementHandler.Direction;

class MovementHandlerTest {
    private MovementHandler movement;

    @BeforeEach
    void setUp() {
        movement = new MovementHandler();
    }

    @Test
    void testInitialPositionAndDirection() {
        assertEquals(0, movement.getPosX());
        assertEquals(0, movement.getPosY());
        assertEquals(Direction.north.ordinal(), movement.getDir());
    }

    @Test
    void testMoveDoesNothingIfSpeedZero() {
        movement.move(10);
        assertEquals(0, movement.getPosX());
        assertEquals(0, movement.getPosY());
    }

    @Test
    void testMoveNorth() {
        movement.setCurrentSpeed(5);
        movement.setDir(Direction.north);
        movement.move();
        assertEquals(-5, movement.getPosY());
    }

    @Test
    void testMoveSouth() {
        movement.setCurrentSpeed(3);
        movement.setDir(Direction.south);
        movement.move();
        assertEquals(3, movement.getPosY());
    }

    @Test
    void testMoveEast() {
        movement.setCurrentSpeed(4);
        movement.setDir(Direction.east);
        movement.move();
        assertEquals(4, movement.getPosX());
    }

    @Test
    void testMoveWest() {
        movement.setCurrentSpeed(2);
        movement.setDir(Direction.west);
        movement.move();
        assertEquals(-2, movement.getPosX());
    }

    @Test
    void testTurnLeft() {
        movement.turnLeft();
        assertEquals(Direction.west.ordinal(), movement.getDir());
        movement.turnLeft();
        assertEquals(Direction.south.ordinal(), movement.getDir());
        movement.turnLeft();
        assertEquals(Direction.east.ordinal(), movement.getDir());
        movement.turnLeft();
        assertEquals(Direction.north.ordinal(), movement.getDir());
    }

    @Test
    void testTurnRight() {
        movement.turnRight();
        assertEquals(Direction.east.ordinal(), movement.getDir());
        movement.turnRight();
        assertEquals(Direction.south.ordinal(), movement.getDir());
        movement.turnRight();
        assertEquals(Direction.west.ordinal(), movement.getDir());
        movement.turnRight();
        assertEquals(Direction.north.ordinal(), movement.getDir());
    }

    @Test
    void testIncrementSpeed() {
        movement.incrementSpeed(2, 1.5);
        assertEquals(3.0, movement.getCurrentSpeed());
    }

    @Test
    void testDecrementSpeed() {
        movement.setCurrentSpeed(10);
        movement.decrementSpeed(2, 3);
        assertEquals(4, movement.getCurrentSpeed());
    }

    @Test
    void testDecrementSpeedBelowZero() {
        movement.setCurrentSpeed(5);
        movement.decrementSpeed(2, 3);
        assertEquals(0, movement.getCurrentSpeed());
    }
}
