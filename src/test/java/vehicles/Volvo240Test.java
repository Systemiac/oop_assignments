package vehicles;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Volvo240Test {

    @Test
    public void testConstructor() {
        Volvo240 volvo = new Volvo240();
        assertEquals(4, volvo.getNrDoors());
        assertEquals(Color.black, volvo.getColor());
        assertEquals(100, volvo.getEnginePower());
        assertEquals("Volvo240", volvo.getModelName());
    }

    @Test
    public void testSpeedFactor() {
        Volvo240 volvo = new Volvo240();
        double expectedFactor = 100 * 0.01 * 1.25;
        assertEquals(expectedFactor, volvo.speedFactor());

    }

    @Test
    public void testSetColor() {
        Volvo240 volvo = new Volvo240();
        volvo.setColor(Color.pink);
        assertEquals(volvo.getColor(), Color.pink);
    }

    @Test
    public void testGetCurrentSpeed() {
        Volvo240 volvo = new Volvo240();
        assertEquals(volvo.getCurrentSpeed(), 0);
    }

    @Test
    public void testStartEngine() {
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        assertEquals(volvo.getCurrentSpeed(), 0.1);
    }

    @Test
    public void testGetPosX() {
        Volvo240 volvo = new Volvo240();
        assertEquals(volvo.getPosX(), 0);
    }

    @Test
    public void testGetPosY() {
        Volvo240 volvo = new Volvo240();

        assertEquals(volvo.getPosY(), 0);
    }

    @Test
    public void testMove() {
        //Test north
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        volvo.move();
        assertEquals(volvo.getPosY(), -0.1);
        assertEquals(volvo.getPosX(), 0);

        
        //Test West
        volvo = new Volvo240();
        volvo.turnLeft();
        volvo.startEngine();
        volvo.move();
        assertEquals(volvo.getPosY(), 0);
        assertEquals(volvo.getPosX(), -0.1);

        
        //Test south
        volvo = new Volvo240();
        volvo.turnLeft();
        volvo.turnLeft();
        volvo.startEngine();
        volvo.move();
        assertEquals(volvo.getPosY(), 0.1);
        assertEquals(volvo.getPosX(), 0);

        
         
        //Test East
        volvo = new Volvo240();
        volvo.turnRight();
        volvo.startEngine();
        volvo.move();
        assertEquals(volvo.getPosY(), 0);
        assertEquals(volvo.getPosX(), 0.1);
    }


    @Test
    public void testTurnLeft() {
        Volvo240 volvo = new Volvo240();
        volvo.turnLeft();
        assertEquals(volvo.getDir(), 3);
        volvo.turnLeft();
        assertEquals(volvo.getDir(), 2);
        volvo.turnLeft();
        assertEquals(volvo.getDir(), 1);
        volvo.turnLeft();
        assertEquals(volvo.getDir(), 0);
    }

    @Test
    public void testTurnRight() {
        Volvo240 volvo = new Volvo240();
        volvo.turnRight();
        assertEquals(volvo.getDir(), 1);
        volvo.turnRight();
        assertEquals(volvo.getDir(), 2);
        volvo.turnRight();
        assertEquals(volvo.getDir(), 3);
        volvo.turnRight();
        assertEquals(volvo.getDir(), 0);
    }

    @Test
    public void testGas() {
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        volvo.gas(0.5);
        assertTrue(volvo.getCurrentSpeed() > 0.1);
        double speedAfterInvalidGas = volvo.getCurrentSpeed();
        volvo.gas(1.5);
        assertEquals(speedAfterInvalidGas, volvo.getCurrentSpeed());
        volvo.gas(-1.5);
        assertEquals(speedAfterInvalidGas, volvo.getCurrentSpeed()); 
    }

    @Test
    public void testBrake() {
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        volvo.gas(1.0);
        double speedBeforeBrake = volvo.getCurrentSpeed();
        volvo.brake(0.5);
        assertTrue(volvo.getCurrentSpeed() < speedBeforeBrake);
        double speedAfterInvalidBrake = volvo.getCurrentSpeed();
        volvo.brake(1.5);
        assertEquals(speedAfterInvalidBrake, volvo.getCurrentSpeed());
        volvo.brake(-1.5);
        assertEquals(speedAfterInvalidBrake, volvo.getCurrentSpeed()); 
    }

    @Test
    public void testSpeedLimit() {
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        for (int i = 0; i < 100; i++) {
            volvo.gas(1.0);
        }
        assertEquals(volvo.getEnginePower(), volvo.getCurrentSpeed());
    }

    @Test
    public void testBrakeToZero() {
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        volvo.gas(1.0);
        for (int i = 0; i < 100; i++) {
            volvo.brake(1.0);
        }
        assertEquals(0, volvo.getCurrentSpeed());
    }

}