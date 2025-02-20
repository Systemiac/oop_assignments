package model.workshops;

import model.vehicles.CarPrototype;
import model.vehicles.Volvo240;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarWorkShopTest {
    private CarWorkshop<CarPrototype> testWorkshop;
    private CarWorkshop<Volvo240> volvoWorkshop;
    private Volvo240 testVolvo;

    @BeforeEach
    void setUp() {
        testWorkshop = new CarWorkshop<>(1,null,null);
        testVolvo = new Volvo240(new Point(0,0));
        volvoWorkshop = new CarWorkshop<>(20,null,null);
    }

    @Test
    public void testConstructor() {
        assertEquals(0, testWorkshop.getCurrentCarsInWorkshop());
    }

    
    @Test
    public void testAddCarToWorkshop() {
        testWorkshop.addCarToWorkshop(testVolvo);
        assertEquals(1, testWorkshop.getCurrentCarsInWorkshop());
        testWorkshop.addCarToWorkshop(testVolvo);
        assertEquals(1, testWorkshop.getCurrentCarsInWorkshop());
    }

    @Test
    void testRemoveCarFromWorkshop() {
        volvoWorkshop.addCarToWorkshop(testVolvo);
        Volvo240 aCar = volvoWorkshop.removeCarFromWorkshop(testVolvo);
        assertNotNull(aCar);
        assertEquals(null, volvoWorkshop.removeCarFromWorkshop(testVolvo));
    }

    @Test
    void testCarAmount() {
        volvoWorkshop.addCarToWorkshop(testVolvo);
        Volvo240 aCar = volvoWorkshop.removeCarFromWorkshop(testVolvo);
        volvoWorkshop.addCarToWorkshop(aCar);
        assertEquals(1, volvoWorkshop.getCurrentCarsInWorkshop());
    }

    @Test
    void testMaxCarsCapacity() {
        assertEquals(20, volvoWorkshop.getMaxCarsInWorkshop());
    }
}