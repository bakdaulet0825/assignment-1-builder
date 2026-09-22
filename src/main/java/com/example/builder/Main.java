package com.example.builder;
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Running Computer Builder Demo ===");
        Computer officePc = ComputerDirector.buildOfficePc();
        System.out.println("Built: " + officePc.getModelName() + " with " + officePc.getRamGb() + "GB RAM");
        Computer gamingPc = ComputerDirector.buildMidRangeGamingPc();
        System.out.println("Built: " + gamingPc.getModelName() + " with GPU " + gamingPc.getGpu());
        Computer topPc = ComputerDirector.buildHighEndGamingPc();
        System.out.println("Built: " + topPc.getModelName() + " (Power Supply: " + topPc.getPowerSupplyWatts() + "W)");
    }
}