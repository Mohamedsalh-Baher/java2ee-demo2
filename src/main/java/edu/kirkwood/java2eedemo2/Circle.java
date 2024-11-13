package edu.kirkwood.java2eedemo2;


public class Circle {
    private double radius;

    public Circle() {
        this.radius = 0;
    }

    public Circle(double radius) {
        setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative.");
        }
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}
