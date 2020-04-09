package com.example.sabermobile;

public class Cube {
    private double cubeZ;
    private double cubeY;
    private double cubeX;
    private String direction;
    private double timeOfSpawn;

    public Cube(double timeOfSpawn, double cubeX, double cubeY, String direction) {
        this.timeOfSpawn = timeOfSpawn;
        this.cubeX = cubeX;
        this.cubeY = cubeY;
        this.direction = direction;
    }
}