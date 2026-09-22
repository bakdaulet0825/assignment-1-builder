# Assignment 1: Builder Design Pattern

## Project Overview
This project implements the **Builder Design Pattern** in Java as part of software design pattern coursework. It demonstrates how to construct complex `Computer` objects step-by-step with flexible configuration parameters (CPU, RAM, Storage, GPU, Liquid Cooling, Peripherals) and robust validation.

## Structure
- `com.example.builder.Computer` — The main product class with a nested `Builder` static class.
- `com.example.builder.ComputerDirector` — Director class providing preset configurations (Office PC, Mid-Range Gaming PC, High-End Gaming PC, Ultimate Gaming PC).
- `com.example.builder.Peripherals` — Component class representing extra hardware parts.
- `com.example.builder.ComputerTest` — Comprehensive unit test suite covering valid configurations, edge cases, and boundary constraints.

## Requirements
- Java 17 or higher
- Maven
- JUnit 5

## How to Run Tests
You can run all tests via IntelliJ IDEA by clicking the green play button next to `ComputerTest` class, or via Maven in the terminal:
```bash
mvn test