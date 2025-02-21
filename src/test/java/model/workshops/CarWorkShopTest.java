package model.workshops;

import java.awt.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.vehicles.CarPrototype;
import model.vehicles.Volvo240;

public class CarWorkShopTest {
    private CarWorkshop<CarPrototype> testWorkshop;
    private CarWorkshop<Volvo240> volvoWorkshop;
    private Volvo240 testVolvo;

    @BeforeEach
    void setUp() {
        testWorkshop = new CarWorkshop<>(1, new Point(100, 100), CarPrototype.class);
        testVolvo = new Volvo240(new Point(0, 0));
        volvoWorkshop = new CarWorkshop<>(20, new Point(200, 200), Volvo240.class);
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