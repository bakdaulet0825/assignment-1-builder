package com.example.builder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ComputerTest {
    @Test
    void testValidOfficePc() {
        Computer pc = ComputerDirector.buildOfficePc();
        assertEquals("Office Workstation", pc.getModelName());
        assertEquals(8, pc.getRamGb());
    }
    @Test
    void testValidMidRangeGamingPc() {
        Computer pc = ComputerDirector.buildMidRangeGamingPc();
        assertEquals(16, pc.getRamGb());
        assertEquals(1024, pc.getStorageGb());
    }
    @Test
    void testValidHighEndGamingPc() {
        Computer pc = ComputerDirector.buildHighEndGamingPc();
        assertTrue(pc.isLiquidCooling());
        assertEquals(32, pc.getRamGb());
    }
    @Test
    void testInvalidModelName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Computer.Builder("", "Intel i5", 16, 512).build();
        });
    }
    @Test
    void testInvalidRamBoundaryLow() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Computer.Builder("Budget PC", "Intel i3", 2, 256).build();
        });
    }
    @Test
    void testInvalidStorageBoundary() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Computer.Builder("PC", "Intel i3", 8, 64).build();
        });
    }
    @Test
    void testBoundaryMinRam() {
        Computer pc = new Computer.Builder("Minimal PC", "Intel i3", 4, 128).build();
        assertEquals(4, pc.getRamGb());
    }
    @Test
    void testBoundaryMaxRam() {
        Computer pc = new Computer.Builder("Server PC", "Intel Xeon", 128, 4096).build();
        assertEquals(128, pc.getRamGb());
    }
    @Test
    void testHighEndGpuConstraintViolationPowerSupply() {
        assertThrows(IllegalStateException.class, () -> {
            new Computer.Builder("Beast PC", "Intel i9", 32, 1024)
                    .withGpu("RTX 4090")
                    .powerSupply(500)
                    .enableLiquidCooling()
                    .build();
        });
    }
    @Test
    void testBuilderReuseAndProductIndependence() {
        Computer.Builder builder = new Computer.Builder("Custom Rig", "AMD Ryzen 7", 32, 1024)
                .withGpu("RTX 4070")
                .powerSupply(750)
                .enableLiquidCooling();
        Computer pc1 = builder.caseType("Mini-Tower").build();
        Computer pc2 = builder.caseType("Full-Tower").build();
        assertEquals("Mini-Tower", pc1.getCaseType());
        assertEquals("Full-Tower", pc2.getCaseType());
    }
}