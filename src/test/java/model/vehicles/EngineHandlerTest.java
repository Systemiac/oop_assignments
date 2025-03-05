package model.vehicles;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EngineHandlerTest {
    private EngineHandler engine;

    @BeforeEach
    void setUp() {
        engine = new EngineHandler(100.0); // Skapar en motor med 100 hp
    }

    @Test
    void testGetEnginePower() {
        assertEquals(100.0, engine.getEnginePower(), "Engine power should be initialized correctly.");
    }

    @Test
    void testStartEngine() {
        engine.stopEngine();
        engine.startEngine();
        assertEquals(1, engine.getEngineOn(), "Engine not starting.");

    }

    @Test
    void testStopEngine() {
        engine.startEngine();
        engine.stopEngine();
        assertEquals(0, engine.getEngineOn(), "Engine not stopping.");
    }
}
