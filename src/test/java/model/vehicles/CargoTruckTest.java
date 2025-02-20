package model.vehicles;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.Color;
import java.awt.Point;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CargoTruckTest {
    private CargoTruck truckPrototype;

    @BeforeEach
    void setup() {
        truckPrototype = new CargoTruck(2, Color.WHITE, 540, "TestTruck", new Point(0,0), null) {
            @Override
            public double speedFactor() {
                return 1.5;
            }
        };
    }

    @Test
    void testLowerCargoBed() {
        truckPrototype.raiseCargoBed(50);
        assertEquals(50, truckPrototype.getCargoBedAngle());
        truckPrototype.lowerCargoBed(20);
        assertEquals(30, truckPrototype.getCargoBedAngle());
        truckPrototype.lowerCargoBed(40);
        assertEquals(0, truckPrototype.getCargoBedAngle());
        truckPrototype.lowerCargoBed(-10);
        assertEquals(0, truckPrototype.getCargoBedAngle());
        truckPrototype.getEngine().startEngine();
        truckPrototype.lowerCargoBed(10);
        assertEquals(0, truckPrototype.getCargoBedAngle());
    }

    @Test
    void testRaiseCargoBed() {
        truckPrototype.raiseCargoBed(50);
        assertEquals(50, truckPrototype.getCargoBedAngle());
        truckPrototype.raiseCargoBed(0);
        assertEquals(50, truckPrototype.getCargoBedAngle());
        truckPrototype.raiseCargoBed(-10);
        assertEquals(50, truckPrototype.getCargoBedAngle());
        truckPrototype.raiseCargoBed(40);
        assertEquals(70, truckPrototype.getCargoBedAngle());
        truckPrototype.getEngine().startEngine();
        truckPrototype.raiseCargoBed(10);
        assertEquals(70, truckPrototype.getCargoBedAngle());
    }

    @Test
    void cargoCheckerCoversAllCases() {
        assertTrue(truckPrototype.cargoChecker());
        truckPrototype.getEngine().startEngine();
        truckPrototype.gas(0.1);
        assertFalse(truckPrototype.cargoChecker());
        truckPrototype.stopVehicle();
        assertTrue(truckPrototype.cargoChecker());
    }
}
