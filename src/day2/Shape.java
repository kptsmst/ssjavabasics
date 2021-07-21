package day2;

public interface Shape {

    //abstract method that all Shapes must implement
    abstract double calculateArea();

    //default method that Shapes MAY override
    default void display(){
        double area = this.calculateArea();
        System.out.printf("The area of this shape is %f\n", area);
    }
}
