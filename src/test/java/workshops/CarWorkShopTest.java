package workshops;

import vehicles.CarPrototype;
import vehicles.Volvo240;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarWorkShopTest {
    private CarWorkshop<CarPrototype> testWorkshop;
    private CarWorkshop<Volvo240> volvoWorkshop;
    private Volvo240 testVolvo;

    @BeforeEach
    void setUp() {
        testWorkshop = new CarWorkshop<>(1);
        testVolvo = new Volvo240();
        volvoWorkshop = new CarWorkshop<>(20);
    }

    @Test
    public void testConstructor() {
        assertEquals(0, testWorkshop.getCarAmountInWorkshop());
    }

    @Test
    public void loadCar() {
        testWorkshop.addCarToWorkshop(testVolvo);
        assertEquals(1, testWorkshop.getCarAmountInWorkshop());
        testWorkshop.addCarToWorkshop(testVolvo);
        assertEquals(1, testWorkshop.getCarAmountInWorkshop());
    }

    @Test
    void testUnloadCar() {
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
        assertEquals(1, volvoWorkshop.getCarAmountInWorkshop());
    }

    @Test
    void testMaxCarsCapacity() {
        assertEquals(20, volvoWorkshop.getMaxCarsCapacity());
    }
}