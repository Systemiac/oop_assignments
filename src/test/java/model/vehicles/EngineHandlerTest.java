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
        engine.startEngine();
        assertEquals(0.1, engine.getCurrentRPM(), "Engine should start at 0.1 RPM.");
    }

    @Test
    void testStopEngine() {
        engine.startEngine();
        engine.stopEngine();
        assertEquals(0, engine.getCurrentRPM(), "Engine should stop and have 0 RPM.");
    }

    @Test
    void testIncreaseRPM() {
        engine.startEngine();
        engine.increaseRPM(20);
        assertEquals(20.1, engine.getCurrentRPM(), "RPM should increase correctly.");
    }

    @Test
    void testIncreaseRPMMaxLimit() {
        engine.increaseRPM(150); // Försöker öka mer än maxvärdet
        assertEquals(100.0, engine.getCurrentRPM(), "RPM should not exceed engine power.");
    }

    @Test
    void testDecreaseRPM() {
        engine.increaseRPM(50);
        engine.decreaseRPM(20);
        assertEquals(30, engine.getCurrentRPM(), "RPM should decrease correctly.");
    }

    @Test
    void testDecreaseRPMBelowZero() {
        engine.decreaseRPM(50); // Försöker minska mer än möjligt
        assertEquals(0, engine.getCurrentRPM(), "RPM should not go below zero.");
    }

    
}
