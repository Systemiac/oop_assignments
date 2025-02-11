package vehicles;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Color;

class VehiclePrototypeTest {

    private VehiclePrototype testVehicle;

    @BeforeEach
    void setUp() {
        testVehicle = new VehiclePrototype(2, Color.WHITE, 100, "TestVehicle") {
            @Override
            public double speedFactor() {
                return 1.5;
            }
        };
    }

    @Test
    void testMoveNorth() {
        assertEquals(0, testVehicle.getDir(), "Norr?");
        testVehicle.startEngine();
        testVehicle.move();
        assertTrue(testVehicle.getPosY() < 0);
    }

    @Test
    void testMoveEastAfterTurnRight() {
        testVehicle.startEngine();
        testVehicle.turnRight();
        testVehicle.move();
        assertTrue(testVehicle.getPosX() > 0);
    }

    @Test
    void testMoveSouthAfterTwoTurns() {
        testVehicle.startEngine();
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
    public void testStartEngine() {
        testVehicle.startEngine();
        assertEquals(testVehicle.getCurrentSpeed(), 0.1);
    }

    @Test
    void testStopEngine() {
        testVehicle.startEngine();
        testVehicle.stopEngine();
        assertEquals(0, testVehicle.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testBrake() {
        testVehicle.startEngine();
        testVehicle.gas(1.0);
        double speedBeforeBrake = testVehicle.getCurrentSpeed();
        
        testVehicle.brake(0.5);
        assertTrue(testVehicle.getCurrentSpeed() < speedBeforeBrake);
        
        testVehicle.brake(1.0);
        assertEquals(0, testVehicle.getCurrentSpeed());

        testVehicle.gas(2);
        assertEquals(0, testVehicle.getCurrentSpeed());

        testVehicle.gas(-2);
        assertEquals(0, testVehicle.getCurrentSpeed());
    }    
    
    @Test
    public void testGas() {
        testVehicle.startEngine();
        
        testVehicle.gas(0.5);
        assertTrue(testVehicle.getCurrentSpeed() > 0.1);
        
        double speedBeforeGas = testVehicle.getCurrentSpeed();
        
        testVehicle.gas(1.0); 
        assertTrue(testVehicle.getCurrentSpeed() > speedBeforeGas);

        double speedBeforeGas2 = testVehicle.getCurrentSpeed();

        testVehicle.brake(2);
        assertEquals(speedBeforeGas2, testVehicle.getCurrentSpeed());

        testVehicle.brake(-2);
        assertEquals(speedBeforeGas2, testVehicle.getCurrentSpeed());
    }

    @Test
    public void testSetPos(){
        testVehicle.setPos(300,300);
        assertEquals(testVehicle.getPosX(), 300);
        assertEquals(testVehicle.getPosY(), 300);
    }
}