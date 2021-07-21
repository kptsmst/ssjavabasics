package day2;

public class Triangle implements Shape {

    //triangle class variables and constructor, also determines triangle validity
    double length1;
    double length2;
    double length3;
    boolean valid;
    public Triangle(double length1, double length2, double length3) {
        this.length1 = length1;
        this.length2 = length2;
        this.length3 = length3;
        this.valid = areLengthsValid(length1, length2, length3);
        System.out.printf("Created Triangle with side lengths %f, %f, and %f\n", length1, length2, length3);
    }

    //static function to check if lengths are valid, each side must be shorter than the sum of the other sides
    public static boolean areLengthsValid(double length1, double length2, double length3) {
        if (length1 >= length2 + length3) return false;
        if (length2 >= length1 + length3) return false;
        if (length3 >= length1 + length2) return false;
        return true;
    }

    //heron's formula to calculate area
    @Override
    public double calculateArea() {
        if (this.valid) {
            double semiperimeter = (length1 + length2 + length3)/2;
            double area = Math.sqrt(semiperimeter*(semiperimeter-length1)*(semiperimeter-length2)*(semiperimeter-length3));
            return area;

        } else return 0;
    }

    //overridden display function to show different message if triangle is invalid;
    @Override
    public void display() {
        if (this.valid) {
            Shape.super.display();
        } else {
            System.out.println("Your triangle isn't valid.");
        }
    }
    
}
