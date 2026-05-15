
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        int num1, num2, result = 0, wrongOffset;
        String op;

        // INPUT NUMBERS
        System.out.print("Enter first number: ");
        while (!scanner.hasNextInt()) scanner.next();
        num1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        while (!scanner.hasNextInt()) scanner.next();
        num2 = scanner.nextInt();

        // INPUT OPERATION
        System.out.print("Choose operation (+, -, *, /): ");
        op = scanner.next();

        while (!(op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/"))) {
            System.out.println("THAT'S THE WRONG INPUT, please try again!");
            System.out.print("Operation (+, -, *, /): ");
            op = scanner.next();
        }

        // CALCULATE RESULT WITH RANDOM OFFSET
        wrongOffset = rand.nextInt(23) + 1; // random 1-23 for all operations
        switch (op) {
            case "+":
                result = num1 + num2 + wrongOffset;
                break;
            case "-":
                result = num1 - num2 + wrongOffset;
                break;
            case "*":
                result = num1 * num2 + wrongOffset;
                break;
            case "/":
                result = num1 / num2 + wrongOffset;
                break;
        }

        System.out.println("Yes I am always Wrong: " + result);

        // GUESSING GAME
        guessingGame(scanner, num1, num2, result, op.charAt(0));

        // SPECIAL EASTER EGGS
        checkEasterEgg(result);
    }

    // GUESSING GAME METHOD
    public static void guessingGame(Scanner sc, int num1, int num2, int result, char op) {
        System.out.print("Guess how much I added for " + op + ": ");
        while (!sc.hasNextInt()) sc.next();
        int guess = sc.nextInt();

        int actualDifference = 0;
        switch(op) {
            case '+': actualDifference = result - (num1 + num2); break;
            case '-': actualDifference = result - (num1 - num2); break;
            case '*': actualDifference = result - (num1 * num2); break;
            case '/': actualDifference = result - (num1 / num2); break;
        }

        if (guess == actualDifference) {
            System.out.println("You gained 1 Brain cell!");
        } else {
            System.out.println("Wrong! It was OBVIOUSLY " + actualDifference);
        }
    }

    // CHECK AND SAVE EASTER EGGS
    public static void checkEasterEgg(int result) {
        if(result == 69) saveEasterEgg("You dirty dog! Achievement gained!");
        if(result == 67) saveEasterEgg("67 67 67 67 67 67 😏");
        // Add more easter eggs here
    }

    // SAVE EASTER EGG TO FILE
    public static void saveEasterEgg(String message) {
        try (FileWriter fw = new FileWriter("easter_eggs.txt", true)) {
            fw.write(message + "\n");
        } catch (IOException e) {
            System.out.println("Error saving Easter egg: " + e.getMessage());
        }
    }
}