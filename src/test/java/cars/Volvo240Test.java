package cars;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;




public class Volvo240Test{

    @Test
    public void testConstructor() {
        Volvo240 volvo = new Volvo240();
        assertEquals(4, volvo.getNrDoors(), "Volvo240 ska ha 4 dörrar");
        assertEquals(Color.black, volvo.getColor(), "Volvo240 ska vara svart");
        assertEquals(100, volvo.getEnginePower(), "Volvo240 ska ha 100 hk");
        assertEquals("Volvo240", volvo.getModelName(), "Modellnamnet ska vara Volvo240");
    }

    @Test
    public void testSpeedFactor(){
        Volvo240 volvo = new Volvo240();
        double expectedFactor = 100 * 0.01 *1.25;
        assertEquals(expectedFactor, volvo.speedFactor(), "Speedfactor ska vara 1.25 vid start");

    }

    @Test
    public void testSetColor(){
        Volvo240 volvo = new Volvo240();
        volvo.setColor(Color.pink);
        assertEquals(volvo.getColor(), Color.pink);
    }

    @Test
    public void testGetCurrentSpeed(){
        Volvo240 volvo = new Volvo240();
        assertEquals(volvo.getCurrentSpeed(), 0);
    }

    @Test
    public void testStartEngine(){
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        assertEquals(volvo.getCurrentSpeed(), 0.1);
    }

    @Test
    public void testGetPosX(){
        Volvo240 volvo = new Volvo240();
        assertEquals(volvo.getPosX(), 0);
    }

    @Test
    public void testGetPosY(){
        Volvo240 volvo = new Volvo240();
        
        assertEquals(volvo.getPosY(), 0);
    }

    @Test
    public void testMoveNorth(){
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        volvo.move();
        assertEquals(volvo.getPosY(), -0.1);
        assertEquals(volvo.getPosX(), 0);

    }

    @Test
    public void testMoveSouth(){
        Volvo240 volvo = new Volvo240();
        volvo.turnLeft();
        volvo.turnLeft();
        volvo.startEngine();
        volvo.move();
        assertEquals(volvo.getPosY(), 0.1);
        assertEquals(volvo.getPosX(), 0);

    }

    @Test
    public void testMoveWest(){
        Volvo240 volvo = new Volvo240();
        volvo.turnLeft();
        volvo.startEngine();
        volvo.move();
        assertEquals(volvo.getPosY(), 0);
        assertEquals(volvo.getPosX(), -0.1);

    }

    @Test
    public void testMoveEast(){
        Volvo240 volvo = new Volvo240();
        volvo.turnRight();
        volvo.startEngine();
        volvo.move();
        assertEquals(volvo.getPosY(), 0);
        assertEquals(volvo.getPosX(), 0.1);

    }

    @Test
    public void testTurnLeft(){
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
    public void testTurnRight(){
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
}