import java.util.Random;
import java.util.Scanner;
public class CrapsGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Roll the dice.");
            int die1 = rollDice(random);
            int die2 = rollDice(random);
            int sum = die1 + die2;

            System.out.println("You have rolled: " + die1 + " + " + die2 + " = " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {

                System.out.println("Craps. You have lost.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural. You have won.");

            } else {
                int point = sum;
                System.out.println("The point is: " + point);
                boolean keepRolling = true;

                while (keepRolling) {
                    System.out.println("Roll again...");
                    die1 = rollDice(random);
                    die2 = rollDice(random);
                    sum = die1 + die2;
                    System.out.println("You have rolled: " + die1 + " + " + die2 + " = " + sum);

                    if (sum == point) {
                        System.out.println("You made the point. You have won.");
                        keepRolling = false;
                    } else if (sum == 7) {
                        System.out.println("You rolled a 7. You have lost.");
                        keepRolling = false;
                    } else {
                        System.out.println("Trying for the point.");
                    }
                }
            }

            System.out.print("Would you like to play again? (yes/no): ");
            String userResponse = scanner.next().toLowerCase();
            playAgain = userResponse.equals("yes");

        }

        System.out.println("Thank you for playing the game!");
    }

    private static int rollDice(Random random) {
        return random.nextInt(6) + 1; //
    }
}
