package com.example.builder;
public class Peripherals {
    private String monitorResolution;
    private boolean mechanicalKeyboard;
    private boolean gamingMouse;
    public Peripherals(String monitorResolution, boolean mechanicalKeyboard, boolean gamingMouse) {
        this.monitorResolution = monitorResolution;
        this.mechanicalKeyboard = mechanicalKeyboard;
        this.gamingMouse = gamingMouse;
    }
    public String getMonitorResolution() { return monitorResolution; }
    public boolean isMechanicalKeyboard() { return mechanicalKeyboard; }
    public boolean isGamingMouse() { return gamingMouse; }
}