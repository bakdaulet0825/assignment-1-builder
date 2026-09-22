package com.example.builder;
public class Computer {
    private final String modelName;
    private final String cpu;
    private final int ramGb;
    private final int storageGb;
    private final String gpu;
    private final int powerSupplyWatts;
    private final String caseType;
    private final boolean liquidCooling;
    private final boolean wiFiModule;
    private final String os;
    private final Peripherals peripherals;
    private Computer(Builder builder) {
        this.modelName = builder.modelName;
        this.cpu = builder.cpu;
        this.ramGb = builder.ramGb;
        this.storageGb = builder.storageGb;
        this.gpu = builder.gpu;
        this.powerSupplyWatts = builder.powerSupplyWatts;
        this.caseType = builder.caseType;
        this.liquidCooling = builder.liquidCooling;
        this.wiFiModule = builder.wiFiModule;
        this.os = builder.os;
        this.peripherals = builder.peripherals;
    }
    public String getModelName() { return modelName; }
    public String getCpu() { return cpu; }
    public int getRamGb() { return ramGb; }
    public int getStorageGb() { return storageGb; }
    public String getGpu() { return gpu; }
    public int getPowerSupplyWatts() { return powerSupplyWatts; }
    public String getCaseType() { return caseType; }
    public boolean isLiquidCooling() { return liquidCooling; }
    public boolean isWiFiModule() { return wiFiModule; }
    public String getOs() { return os; }
    public Peripherals getPeripherals() { return peripherals; }
    public static class Builder {
        private final String modelName;
        private final String cpu;
        private final int ramGb;
        private final int storageGb;
        private String gpu = "Integrated";
        private int powerSupplyWatts = 500;
        private String caseType = "Standard Mid-Tower";
        private boolean liquidCooling = false;
        private boolean wiFiModule = true;
        private String os = "Windows 11 Home";
        private Peripherals peripherals = new Peripherals("1920x1080", false, false);
        public Builder(String modelName, String cpu, int ramGb, int storageGb) {
            this.modelName = modelName;
            this.cpu = cpu;
            this.ramGb = ramGb;
            this.storageGb = storageGb;
        }
        public Builder withGpu(String gpu) {
            this.gpu = gpu;
            return this;
        }
        public Builder powerSupply(int watts) {
            this.powerSupplyWatts = watts;
            return this;
        }
        public Builder caseType(String caseType) {
            this.caseType = caseType;
            return this;
        }
        public Builder enableLiquidCooling() {
            this.liquidCooling = true;
            return this;
        }
        public Builder enableWiFi() {
            this.wiFiModule = true;
            return this;
        }
        public Builder withOs(String os) {
            this.os = os;
            return this;
        }
        public Builder peripherals(Peripherals peripherals) {
            this.peripherals = peripherals;
            return this;
        }
        public Computer build() {
            if (modelName == null || modelName.trim().isEmpty()) {
                throw new IllegalArgumentException("Model name cannot be empty");
            }
            if (ramGb < 4 || ramGb > 128) {
                throw new IllegalArgumentException("RAM must be between 4 GB and 128 GB");
            }
            if (storageGb < 128) {
                throw new IllegalArgumentException("Storage must be at least 128 GB");
            }
            boolean isHighEndGpu = gpu != null && (gpu.contains("RTX 4090") || gpu.contains("RX 7900"));
            if (isHighEndGpu) {
                if (powerSupplyWatts < 650) {
                    throw new IllegalStateException("High-end GPU requires a power supply of at least 650W!");
                }
                if (!liquidCooling) {
                    throw new IllegalStateException("High-end GPU requires liquid cooling!");
                }
            }
            Computer computer = new Computer(this);
            if ("Ultimate Gaming PC".equalsIgnoreCase(computer.modelName)) {
                System.out.println("🍌 Ultimate Gaming PC successfully built!");
            }
            return computer;
        }
    }
}