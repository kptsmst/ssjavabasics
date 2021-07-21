package day2;

public class Rectangle implements Shape {

    //retangle variables and consturctor;
    double width;
    double height;
    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
        System.out.printf("Created Rectangle with width %f and height %f\n", width, height);
    }

    //area of a rectangle = w * h
    @Override
    public double calculateArea() {
        return this.width * this.height;
    }
    
    //use default display() method from Shape
}
