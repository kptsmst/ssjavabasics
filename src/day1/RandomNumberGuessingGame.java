package day1;

import java.util.Random;

// Assignment 2

// User is asked to guess a number 1-100. (Program chooses randomly.)
// If the guess is within 10 of the correct answer, plus or minus, output the
// correct answer and exit. (If the answer is 63, user must guess 53-73.)
// If the number is not within 10 of the correct answer, ask the user to keep
// guessing.
// If the user does not succeed within 5 attempts, display, "Sorry," along with
// the answer and exit.

public class RandomNumberGuessingGame {
    public static void main(String[] args) {
        // initialize random class
        Random rand = new Random();
        // rand.nextInt(bound) gives a numbe between [0, bound) so we add 1 to change
        // the range to to [1, bound];
        int numberToGuess = rand.nextInt(100) + 1;
        System.out.println("Random number on [1, 100] generated.");
        // loop giving the user 5 attempts
        for (int attempt = 0; attempt < 5; attempt++) {
            try {

                //get user number
                int guessedNumber = getNumber();
                //check user number
                Boolean closeOrCorrect = checkNumber(numberToGuess, guessedNumber);
                //give feedback!
                if (closeOrCorrect) {
                    System.out.println("You guessed " + String.valueOf(guessedNumber) + " and the correct number was "
                            + String.valueOf(numberToGuess) + ".");
                    System.out.println("Good job!");
                    break;
                } else {
                    System.out.println(
                            "Not close enough. " + String.valueOf(4 - attempt) + " attempts remaining. Try again.");
                    
                }
            //catch the parse failing
            } catch (Exception e) {
                System.out.println("Wrong. That isn't a number. Please enter a number next time. 45, 12, 9... a number.");
            }
            //let the user know they failed their final attempt
            if (attempt == 4) {
                System.out.println("Sorry, the random number was " + String.valueOf(numberToGuess) + ".");
            }
        }

    }

    public static boolean checkNumber(int numberToGuess, int guessedNumber) {
        if (guessedNumber >= numberToGuess - 10 && guessedNumber <= numberToGuess + 10) {
            return true;
        } else
            return false;
    }

    public static int getNumber() {

        System.out.print("Make a guess within 10 of the correct answer: ");
        String userInput = System.console().readLine();
        int parsed = Integer.parseInt(userInput);
        return parsed;

    }
}
