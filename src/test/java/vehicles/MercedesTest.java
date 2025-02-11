package vehicles;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class MercedesTest {

    private Mercedes mercedes;

    @BeforeEach
    void setUp() {
        mercedes = new Mercedes();
    }

    @Test
    public void testSpeedFactor() {
        assertEquals(4.28, mercedes.speedFactor());
        mercedes.raiseCargoBed();
        
        assertEquals(0, mercedes.speedFactor());
    }
}
