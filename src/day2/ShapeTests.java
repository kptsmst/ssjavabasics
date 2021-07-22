package day2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShapeTests {

    @Test
    public void testOne() {

        // circle demo
        Circle circle = new Circle(5);
        circle.display();

        // rectangle demo
        Rectangle rectangle = new Rectangle(10, 3);
        rectangle.display();

        // valid and invalid triangle demos
        Triangle triangle = new Triangle(2, 3, 4);
        triangle.display();

        Triangle brokenTriangle = new Triangle(3, 4, 7);
        brokenTriangle.display();

        assertEquals(30, rectangle.calculateArea(), 0.0001);
    }
}
