package workshops;

import vehicles.Car;
import vehicles.Volvo240;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarWorkShopTest {
    private CarWorkshop<Car> testWorkshop;
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
        assertEquals(0, testWorkshop.getCarAmount());
    }

    @Test
    public void loadCar() {
        testWorkshop.loadCar(testVolvo);
        assertEquals(1, testWorkshop.getCarAmount());
        testWorkshop.loadCar(testVolvo);
        assertEquals(1, testWorkshop.getCarAmount());
    }

    @Test
    void testUnloadCar() {
        volvoWorkshop.loadCar(testVolvo);
        Volvo240 aCar = volvoWorkshop.unloadCar(testVolvo);
        assertNotNull(aCar);
        assertEquals(null, volvoWorkshop.unloadCar(testVolvo));
    }

    @Test
    void testCarAmount() {
        volvoWorkshop.loadCar(testVolvo);
        Volvo240 aCar = volvoWorkshop.unloadCar(testVolvo);
        volvoWorkshop.loadCar(aCar);
        assertEquals(1, volvoWorkshop.getCarAmount());
    }

    @Test
    void testMaxCarsCapacity() {
        assertEquals(20, volvoWorkshop.getMaxCarsCapacity());
    }
}