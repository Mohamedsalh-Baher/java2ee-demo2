package edu.kirkwood.ecommerce.model;
//Cylinder
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

    // Method to calculate volume of the cylinder
    public double getVolume() {
        return base.getArea() * height;
    }

    // toString method for displaying volume formula
    public String toString() {
        double roundedVolume = Double.parseDouble(Helpers.round(getVolume(), 1));  // Assuming Helpers.round() is implemented to round to 1 decimal
        return String.format("%.2f · π · %.2f² ≅ %.1f", height, base.getRadius(), roundedVolume);
    }
}