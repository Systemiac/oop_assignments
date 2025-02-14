package vehicles;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import vehicles.MovementHandler.Direction;

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
        carTransport = new CarTransport(2, Color.WHITE, 540, "TestTruck", 5) {
            @Override
            public double speedFactor() {
                return 1.5;
            }
        };
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
        assertEquals(1, testCar2.getMovement().getPosY());
        carTransport.loadCar(testCar3);
        assertEquals(1.5, testCar3.getMovement().getPosY());
        carTransport.loadCar(testCar4);
        assertEquals(2, testCar4.getMovement().getPosY());
        carTransport.loadCar(testCar5);
        assertEquals(2.5, testCar5.getMovement().getPosY());
        carTransport.loadCar(testCar6);
        assertEquals(0, testCar6.getMovement().getPosY());
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

}
