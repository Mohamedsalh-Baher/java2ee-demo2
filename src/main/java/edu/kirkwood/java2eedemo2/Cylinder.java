package edu.kirkwood.java2eedemo2;


import edu.kirkwood.shard.Helpers;

public class Cylinder {
    private Circle base;
    private double height;

    // Default constructor
    public Cylinder() {
        this.base = new Circle(0);
        this.height = 0;
    }

    // Parameterized constructor
    public Cylinder(double radius, double height) {
        this.base = new Circle(radius);
        setHeight(height);
    }

    // Getter for height
    public double getHeight() {
        return height;
    }

    // Setter for height with validation
    public void setHeight(double height) {
        if (height < 0) {
            throw new IllegalArgumentException("Height cannot be negative.");
        }
        this.height = height;
    }

    // Method to calculate volume
    public double getVolume() {
        return Math.PI * base.getRadius() * base.getRadius() * height;
    }

    // toString method
    @Override
    public String toString() {
        String volume = Helpers.round(getVolume(), 1);
        return height + " · π · " + base.getRadius() + "^2 ≅ " + volume;
    }
}
