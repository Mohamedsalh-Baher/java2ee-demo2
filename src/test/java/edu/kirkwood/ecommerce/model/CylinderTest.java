package edu.kirkwood.ecommerce.model;
// CylinderTest
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CylinderTest {

    private Cylinder cylinder1;
    private Cylinder cylinder2;

    @BeforeEach
    void setUp() {
        cylinder1 = new Cylinder();
        cylinder2 = new Cylinder(5.0, 10.0);
    }

    @Test
    void getHeight() {
        assertEquals(0.0, cylinder1.getHeight(), "Default height should be 0");
        assertEquals(10.0, cylinder2.getHeight(), "Height should be initialized to 10.0");

        cylinder1.setHeight(7.5);
        assertEquals(7.5, cylinder1.getHeight(), "Height should be set to 7.5");
    }

    @Test
    void setHeight() {
        cylinder1.setHeight(12.0);
        assertEquals(12.0, cylinder1.getHeight(), "Height should be set to 12.0");

        cylinder1.setHeight(0.0);
        assertEquals(0.0, cylinder1.getHeight(), "Height should be set to 0");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> cylinder1.setHeight(-1.0));
        assertEquals("Height cannot be negative.", exception.getMessage(), "Expected IllegalArgumentException for negative height");
    }

    @Test
    void getVolume() {
        assertEquals(0.0, cylinder1.getVolume(), "Volume should be 0 for radius and height 0");

        cylinder1 = new Cylinder(3.0, 4.0);
        assertEquals(113.09733552923255, cylinder1.getVolume(), 1e-9, "Volume should be calculated correctly for radius 3 and height 4");

        // Test volume for cylinder2 initialized with radius 5 and height 10
        assertEquals(785.3981633974483, cylinder2.getVolume(), 1e-9, "Volume should be calculated correctly for radius 5 and height 10");
    }

    @Test
    void testToString() {
        cylinder1 = new Cylinder(4.0, 7.5);
        assertEquals("7.50 · π · 4.00² ≅ 376.9", cylinder1.toString());

        cylinder2.setHeight(12.5);
        assertEquals("12.50 · π · 5.00² ≅ 981.7", cylinder2.toString());
    }
}