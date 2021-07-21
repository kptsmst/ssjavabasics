package day2;

public class Circle implements Shape {

    //circle variable and consturctor
    double radius;
    public Circle(float radius) {
        this.radius = radius;
        System.out.printf("Created Circle with radius %f\n", radius);
    }

    //area = pi * r^2;
    @Override
    public double calculateArea() {
        return Math.PI * this.radius * this.radius;
    }

    //use default display method from Shape interface
    
}
