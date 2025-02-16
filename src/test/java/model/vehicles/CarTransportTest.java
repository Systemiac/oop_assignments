package model.vehicles;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.Color;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTransportTest {
    private CarTransport carTransport;
    private CarPrototype testCar1;
    private CarPrototype testCar2;
    private CarPrototype testCar3;
    private CarPrototype testCar4;
    private CarPrototype testCar5;
    private CarPrototype testCar6;

    @BeforeEach
    void setup() {
        if (carTransport == null) {
            carTransport = new CarTransport(2, Color.WHITE, 540, "TestTruck", 6) {
                @Override
                public double speedFactor() {
                    return 1.5;
                }
            };
        }

        testCar1 = new Volvo240();
        testCar2 = new Saab95();
        testCar3 = new Volvo240();
        testCar4 = new Volvo240();
        testCar5 = new Saab95();
        testCar6 = new Volvo240();
    }

    @Test
    public void testMove() {
        carTransport.loadCar(testCar1);
        carTransport.loadCar(testCar2);
        carTransport.move();

        assertEquals(carTransport.getMovement().getPosY(), testCar1.getMovement().getPosY());
        assertEquals(carTransport.getMovement().getPosX(), testCar1.getMovement().getPosX());
        assertEquals(carTransport.getMovement().getPosX(), testCar2.getMovement().getPosX());
        assertEquals(carTransport.getMovement().getPosY(), testCar2.getMovement().getPosY());
    }

    @Test
    public void testRaiseCargoBed() {
        carTransport.getMovement().setCurrentSpeed(1);
        assertFalse(carTransport.cargoChecker());
        carTransport.getMovement().setCurrentSpeed(0);
        carTransport.raiseCargoBed();
        assertEquals(carTransport.getMaxAngle(), carTransport.getCargoBedAngle());
        carTransport.lowerCargoBed();
        assertEquals(carTransport.getMinAngle(), carTransport.getCargoBedAngle());
        assertTrue(carTransport.cargoChecker());
    }

    @Test
    public void testLowerCargoBed() {
        carTransport.raiseCargoBed();
        carTransport.lowerCargoBed();
        assertEquals(0, carTransport.getCargoBedAngle());
    }

    @Test
    public void testLoadCarTransport() {
        carTransport.raiseCargoBed();
        assertEquals(0, carTransport.getCarAmount());
        carTransport.loadCar(testCar1);
        assertEquals(1, carTransport.getCarAmount());
    }

    @Test
    void testUnloadCar() {
        carTransport.raiseCargoBed();
        carTransport.loadCar(testCar1);
        assertEquals(1, carTransport.getCarAmount());
        carTransport.unloadCar();
        assertEquals(0, carTransport.getCarAmount());
    }

    @Test
    public void testGetCarAmount() {
        assertEquals(0, carTransport.getCarAmount());
    }

    @Test
    void testUpdateCarPositions() {
        carTransport.getStackContent().clear();
        carTransport.raiseCargoBed();
        carTransport.loadCar(testCar1);
        assertEquals(0.5, testCar1.getMovement().getPosY());
        carTransport.loadCar(testCar2);
        assertEquals(1.0, testCar2.getMovement().getPosY());
        carTransport.loadCar(testCar3);
        assertEquals(1.5, testCar3.getMovement().getPosY());
        carTransport.loadCar(testCar4);
        assertEquals(2.0, testCar4.getMovement().getPosY());
        carTransport.loadCar(testCar5);
        assertEquals(2.5, testCar5.getMovement().getPosY());
        carTransport.loadCar(testCar6);
        assertEquals(3.0, testCar6.getMovement().getPosY());
    }

    @Test
    void testGetOffset() {
        carTransport.getStackContent().clear();
        assertFalse(carTransport.setOffset(0));
        assertEquals(0.5, carTransport.getOffset());
        carTransport.loadCar(testCar1);
        assertEquals(0.5, carTransport.getOffset());
        carTransport.loadCar(testCar2);
        assertEquals(0.5, carTransport.getOffset());
    }

    @Test
    void testEmptyCarTransport() {
        carTransport.getStackContent().clear();
        carTransport.updateCarPositions();
        assertEquals(0, carTransport.getCarAmount());
    }

    @Test
    void testCarTooCloseToAnotherCar() {
        carTransport.getStackContent().clear();
        carTransport.getMovement().setCurrentSpeed(0);
        carTransport.raiseCargoBed();
        carTransport.loadCar(testCar1);
        carTransport.loadCar(testCar2);
        carTransport.loadCar(testCar3);
        carTransport.loadCar(testCar4);
        carTransport.updateCarPositions();
        assertEquals(4, carTransport.getCarAmount());
        assertEquals(carTransport.getMovement().getPosY() + 1.5, testCar3.getMovement().getPosY());
        assertEquals(2, testCar4.getMovement().getPosY());
    }

    @Test
    void testCarTransportFull() {
        System.out.println(">> DEBUG: Using carTransport instance: " + carTransport);
        carTransport.getMovement().setCurrentSpeed(0);
        carTransport.raiseCargoBed();
        assertFalse(carTransport.isFull());
        assertTrue(carTransport.loadCar(testCar1));
        assertTrue(carTransport.loadCar(testCar2));
        assertTrue(carTransport.loadCar(testCar3));
        assertTrue(carTransport.loadCar(testCar4));
        assertTrue(carTransport.loadCar(testCar5));
        assertTrue(carTransport.loadCar(testCar6));
        assertTrue(carTransport.isFull());
    }

    @Test
    void testSetOffsetInvalid() {
        assertFalse(carTransport.setOffset(-1)); 
        assertFalse(carTransport.setOffset(0));
    }

    @Test
    void testCarTransportReallyFull() {
        carTransport.getMovement().setCurrentSpeed(0);
        carTransport.raiseCargoBed();

        for (int i = 0; i < 12; i++) {
            carTransport.loadCar(new Volvo240());
        }
        assertTrue(carTransport.isFull()); // Nu ska den vara full
    }
    @Test
    void testRaiseCargoBedAgain() {
        carTransport.getMovement().setCurrentSpeed(0);
        carTransport.raiseCargoBed();
        carTransport.raiseCargoBed(); // Kör den igen
    
        assertEquals(carTransport.getMaxAngle(), carTransport.getCargoBedAngle()); 
    }    
}
