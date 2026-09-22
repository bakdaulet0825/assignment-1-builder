package com.example.builder;
public class ComputerDirector {
    public static Computer buildOfficePc() {
        return new Computer.Builder("Office Workstation", "Intel Core i3", 8, 256)
                .powerSupply(400)
                .caseType("Compact Desktop")
                .withOs("Windows 11 Pro")
                .build();
    }
    public static Computer buildMidRangeGamingPc() {
        return new Computer.Builder("Gaming Rig Mid", "AMD Ryzen 5", 16, 1024)
                .withGpu("RTX 4060")
                .powerSupply(600)
                .build();
    }
    public static Computer buildHighEndGamingPc() {
        return new Computer.Builder("Ultimate Gaming PC", "Intel Core i7-12700H", 32, 2048)
                .withGpu("RTX 4090")
                .powerSupply(850)
                .enableLiquidCooling()
                .peripherals(new Peripherals("3840x2160", true, true))
                .build();
    }
}