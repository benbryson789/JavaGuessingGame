package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner keyboardInput = new Scanner ( System.in );

        System.out.println ( "Welcome to the Guessing Game: " );

        System.out.println ( "Enter your name: " );
        String name = keyboardInput.nextLine ();

        boolean playAgain = true;

        while ( playAgain ) {
            // Game starts
            int secretNum;
            int guess;
            boolean correct = false;
            int count = 1;
            secretNum = new Random ().nextInt ( 100 ); // get a random number between 0 and 100.

            while ( !correct ) {
                if (count > 5) {
                    System.out.println ( "The correct number was: " + secretNum );
                    System.out.println ( "You Lose, Try Again" );
                    break;
                }
                count = count + 1;

                System.out.println ( "Guess: " );
                // guess = keyboardInput.nextInt ();
                guess = readInteger ( keyboardInput );

                if (guess == secretNum) {
                    correct = true;
                    System.out.println ( "Congratulations " + name + "!! you are right!" );
                } else if (guess < secretNum) {
                    System.out.println ( "The secret number is Higher than your guess. You guessed " + guess );
                } else if (guess > secretNum) {
                    System.out.println ( "The secret number is Lower than your guess. You guessed " + guess );
                }
            }

            System.out.println ( "Do you want to play again or quit: [y/n]" );
            String response = keyboardInput.nextLine ();
            if (response.equalsIgnoreCase ( "n" )) {
                playAgain = false;
            }
        }

    }

    /**
     * Reads an integer from the user.
     * Gives an error message if the user enters an invalid integer and requires the user to enter again
     */
    static int readInteger(Scanner sc) {
        int guess = -1;
        boolean success = false;
        while ( !success ) {
            try {
                String line = sc.nextLine ();
                guess = Integer.parseInt ( line );  // This line generates an exception (failure) if line is not a valid integer number.
                success = true;
            } catch (NumberFormatException e) {
                System.out.println ( "The entered value is not a valid integer, please enter again: " );
            }
        }
        return guess;
    }
}
