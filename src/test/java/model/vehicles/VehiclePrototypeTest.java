package model.vehicles;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Color;
import java.awt.Point;

class VehiclePrototypeTest {

    private VehiclePrototype testVehicle;

    @BeforeEach
    void setUp() {
        testVehicle = new VehiclePrototype(2, Color.WHITE, 100, "TestVehicle", new Point(0,0)) {
            @Override
            public double speedFactor() {
                return 1.5;
            }
        };
    }

    @Test
    public void testStartEngine() {
        testVehicle.getEngine().startEngine();
        assertEquals(testVehicle.getEngine().getCurrentRPM(), 0.1);
    }

    @Test
    void testStopEngine() {
        testVehicle.getEngine().startEngine();
        testVehicle.getEngine().stopEngine();
        assertEquals(0, testVehicle.getMovement().getCurrentSpeed(), 0.01);
    }

    @Test
    public void testBrake() {
        testVehicle.getEngine().startEngine();
        testVehicle.gas(1.0);
        double speedBeforeBrake = testVehicle.getMovement().getCurrentSpeed();
        
        testVehicle.brake(0.5);
        assertTrue(testVehicle.getMovement().getCurrentSpeed() < speedBeforeBrake);
        
        testVehicle.brake(1.0);
        assertEquals(0, testVehicle.getMovement().getCurrentSpeed());

        testVehicle.gas(2);
        assertEquals(0, testVehicle.getMovement().getCurrentSpeed());

        testVehicle.gas(-2);
        assertEquals(0, testVehicle.getMovement().getCurrentSpeed());
    }    
    
    @Test
    public void testGas() {
        testVehicle.getEngine().startEngine();
        
        testVehicle.gas(0.5);
        assertTrue(testVehicle.getMovement().getCurrentSpeed() > 0.1);
        
        double speedBeforeGas = testVehicle.getMovement().getCurrentSpeed();
        
        testVehicle.gas(1.0); 
        assertTrue(testVehicle.getMovement().getCurrentSpeed() > speedBeforeGas);

        double speedBeforeGas2 = testVehicle.getMovement().getCurrentSpeed();

        testVehicle.brake(2);
        assertEquals(speedBeforeGas2, testVehicle.getMovement().getCurrentSpeed());

        testVehicle.brake(-2);
        assertEquals(speedBeforeGas2, testVehicle.getMovement().getCurrentSpeed());
    }
}