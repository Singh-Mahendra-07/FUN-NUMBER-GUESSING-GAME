import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        // Initializing the 2D array to store the user's details
        String[][] user = new String[10][3];
        int index = 0;

        // Asking the user if they want to play
        System.out.print("Do you want to play a number guessing game? (y/n) ");
        String play = sc.nextLine();

        while (play.equalsIgnoreCase("y")) {
            // Taking the user's name as input
            System.out.print("Enter your name: ");
            String name = sc.nextLine();

            // Generating a random number between 0 and 100
            int num = rand.nextInt(101);

            // Setting the number of guesses to 0
            int numGuesses = 0;

            // Looping through the guesses
            while (numGuesses < 5) {
                System.out.print("Guess a number between 0 and 100: ");
                int guess = sc.nextInt();
                sc.nextLine();

                // Checking if the guess is correct
                if (guess == num) {
                    System.out.println("Congratulations, " + name + "! You won the game.");
                    break;
                } else {
                    numGuesses++;

                    // Giving the user a hint after 2 incorrect guesses
                    boolean checkforgreaterthen50 = true;
                    if (numGuesses == 2) {

                        if (num < 50) {
                            checkforgreaterthen50 = false;
                            System.out.println("Hint: The number is less than 50.");
                        } else {
                            System.out.println("Hint: The number is greater than or equal to 50.");
                        }
                    }

                    // Giving the user a hint after 3 incorrect guesses
                    if (checkforgreaterthen50 == true) {
                        if (numGuesses == 3) {
                            if (num < 50) {
                                if (num > 25) {
                                    System.out.println("Hint: The number is greater than 25.");
                                } else {
                                    System.out.println("Hint: The number is less than 25.");
                                }
                            } else {
                                if (num > 75) {
                                    System.out.println("Hint: The number is greater than 75.");
                                } else {
                                    System.out.println("Hint: The number is less than 75.");
                                }
                            }
                        }
                    }

                    // Checking if the user has used all their guesses
                    if (numGuesses == 5) {
                        System.out.println(
                                "Sorry, " + name + ". You have used all your guesses. The number was " + num + ".");
                    }
                }
            }

            // Adding the user's details to the 2D array
            boolean userPresent = false;
            for (int i = 0; i < index; i++) {
                if (user[i][0].equals(name)) {
                    userPresent = true;
                    user[i][1] = String.valueOf(Integer.parseInt(user[i][1]) + 1);
                    if (numGuesses < 5) {
                        user[i][2] = String.valueOf(Integer.parseInt(user[i][2]) + 1);
                    }
                }
            }

            if (!userPresent) {
                user[index][0] = name;
                user[index][1] = "1";
                if (numGuesses < 5) {
                    user[index][2] = "1";
                } else {
                    user[index][2] = "0";
                }
                index++;
            }

            // Asking the user if they want to play again
            System.out.print("Do you want to play again? (yes/no) ");
            play = sc.nextLine();
        }

        // Printing the user's details
        System.out.println("Name\tMatches Played\tMatches Won");
        for (int i = 0; i < index; i++) {
            //"\t" is use to add 4 spaces.
            System.out.println(user[i][0] + "\t" + user[i][1] + "\t\t" + user[i][2]);
        }

        sc.close();
    }
}
