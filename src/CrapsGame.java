import java.util.Random;
import java.util.Scanner;

public class CrapsGame {
    public static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Craps!");
        do {
            playGame();
        } while (playAgain(scanner));

        System.out.println("Thanks for playing!");
    }

    public static void playGame() {
        int sum = rollAndDisplay();

        if (sum == 2 || sum == 3 || sum == 12) {
            System.out.println("You lose.");
        } else if (sum == 7 || sum == 11) {
            System.out.println("You win.");
        } else {
            int point = sum;
            System.out.println("The point is (" + point + ").");

            do {
                sum = rollAndDisplay();
                if (sum != point && sum != 7) {
                    System.out.println("The point (" + point + ").");
                }
            } while (sum != point && sum != 7);

            System.out.println(sum == point ? "You win." : "Got a seven. You lose.");
        }
    }

    public static int rollAndDisplay() {
        int die1 = RANDOM.nextInt(6) + 1;
        int die2 = RANDOM.nextInt(6) + 1;
        int sum = die1 + die2;

        System.out.println("Die 1: " + die1 + ", Die 2: " + die2 + ", Sum: " + sum);
        return sum;
    }

    public static boolean playAgain(Scanner scanner) {
        while (true) {
            System.out.print("Play again? (y/n): ");
            System.out.flush();

            if (!scanner.hasNextLine()) {
                return false;
            }

            String answer = scanner.nextLine().trim();

            if (answer.equals("y")) {
                return true;
            }
            if (answer.equals("n")) {
                return false;
            }

            System.out.println("Please enter y or n.");
        }
    }
}
