package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SmokeTest {
    @Test
    void sampleTestPasses() {
        assertTrue(2 + 2 == 4, "Basic Maven test should pass");
    }
}
