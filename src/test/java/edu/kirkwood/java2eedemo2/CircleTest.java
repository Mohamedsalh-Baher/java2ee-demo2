package edu.kirkwood.java2eedemo2;

import edu.kirkwood.java2eedemo2.model.Circle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    private Circle circle1;
    private Circle circle2;

    @BeforeEach
    void setUp() {
        circle1 = new Circle();
        circle2 = new Circle(7.0);
    }

    @Test
    void getRadius() {
        assertEquals(0, circle1.getRadius(), "Default radius should be 0");
        assertEquals(7.0, circle2.getRadius(), "Radius should be initialized to 7.0");

        circle1.setRadius(5.5);
        assertEquals(5.5, circle1.getRadius(), "Radius should be set to 5.5");
    }

    @Test
    void setRadius() {
        circle1.setRadius(10.0);
        assertEquals(10.0, circle1.getRadius(), "Radius should be set to 10");

        circle1.setRadius(0.0);
        assertEquals(0.0, circle1.getRadius(), "Radius should be set to 0");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> circle1.setRadius(-1.0));
        assertEquals("Radius cannot be negative.", exception.getMessage(), "Expected IllegalArgumentException for negative radius");
    }

    @Test
    void getArea() {
        assertEquals(0.0, circle1.getArea(), "Area should be 0 for radius 0");

        circle1.setRadius(3.0);
        assertEquals(28.274333882308138, circle1.getArea(), 1e-9, "Area should be calculated correctly for radius 3");

        assertEquals(153.93804002589985, circle2.getArea(), 1e-9, "Area should be calculated correctly for radius 7");

        circle1.setRadius(0.0);
        assertEquals(0.0, circle1.getArea(), "Area should be 0 for radius 0");
    }

    @Test
    void testToString() {
        circle1.setRadius(5.0);
        assertEquals("Circle with radius 5.0 and area 78.53981633974483", circle1.toString());

        circle2.setRadius(10.0);
        assertEquals("Circle with radius 10.0 and area 314.1592653589793", circle2.toString());
    }
}