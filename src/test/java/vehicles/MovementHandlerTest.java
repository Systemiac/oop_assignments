package vehicles;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MovementHandlerTest {

    private MovementHandler testVehicle;

    @BeforeEach
    void setUp() {
        testVehicle = new MovementHandler();
    }


    @Test
    public void testMove(){
        testVehicle.move(5);
        assertEquals(-5, testVehicle.getPosY());

        testVehicle.turnLeft();
        testVehicle.turnLeft();
        testVehicle.move(5);
        assertEquals(0, testVehicle.getPosY());

        testVehicle.turnRight();
        testVehicle.move(5);
        assertEquals(-5, testVehicle.getPosX());
        
        testVehicle.turnRight();
        testVehicle.turnRight();
        testVehicle.move(5);
        assertEquals(0, testVehicle.getPosX());
    }

    @Test
    public void testTurnLeft(){
        testVehicle.turnLeft();
        testVehicle.turnLeft();
        testVehicle.turnLeft();
        testVehicle.turnLeft();
        assertEquals(0, testVehicle.getDir());

    }

    @Test
    public void testTurnRight(){
        testVehicle.turnRight();
        testVehicle.turnRight();
        testVehicle.turnRight();
        testVehicle.turnRight();
        assertEquals(0, testVehicle.getDir());

    }
    
}
