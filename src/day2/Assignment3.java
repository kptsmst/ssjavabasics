package day2;


public class Assignment3 {
    public static void main(String[] args) {
        //circle demo
        Circle circle = new Circle(5);
        circle.display();

        //rectangle demo
        Rectangle rectangle = new Rectangle(10, 3);
        rectangle.display();

        //valid and invalid triangle demos
        Triangle triangle = new Triangle(2, 3, 4);
        triangle.display();

        Triangle brokenTriangle = new Triangle(3, 4, 7);
        brokenTriangle.display();
    }
}
