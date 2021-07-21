package day2;

public class Assignment2 {
    
    public static void main(String[] args) {

        //initialization of 2d array
        int[][] twoDimensionalIntArray = {
            {1, 4, 9},
            {12, 3, 2},
            {5, 7}
        };

        //initialization of variables
        int maxX = 0;
        int maxY = 0;
        int maxNumber = Integer.MIN_VALUE;

        //nested loop iterating through the array by column then row
        for (int y = 0; y < twoDimensionalIntArray.length; y++) {
            for (int x = 0; x < twoDimensionalIntArray[y].length; x++) {
                int number = twoDimensionalIntArray[y][x];
                System.out.printf("Number at location (%d,%d): %d\n", x, y, number);
                //set new max variables when a new max is found
                if (number > maxNumber) {
                    maxX = x;
                    maxY = y;
                    maxNumber = number;
                    System.out.printf("New max number: %d\n", maxNumber);
                }
            }
        }

        //print final max value
        System.out.printf("Maximum number found: %d at (%d,%d)\n", maxNumber, maxX, maxY);
    }
}
