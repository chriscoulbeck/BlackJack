package cli;

import model.Player;

import java.util.Scanner;

/**
 * Interface for handling command line input to the application.
 */
public class CommandLineInterface {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Gets the next line from the input stream without whitespace and converted to lowercase.
     *
     * @return Next line from input stream as a string
     */
    private static String getNextLine() {
        return scanner.nextLine().trim().toLowerCase();
    }

    /**
     * Prompt the user for their bet amount.
     *
     * @param player the player being prompted
     * @return an integer representing their bet amount, or 0 if the user quits.
     */
    public static int promptForValidBet(Player player) {
        while (true) {
            System.out.println("Enter bet (or type 'quit' to exit): ");
            String input = getNextLine();

            if (input.equals("quit")) {
                return 0;
            }

            int amount;
            try {
                amount = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            if (amount <= 0) {
                System.out.println("Bet must be a positive number.");
            } else if (amount > player.getBalance()) {
                System.out.println("You do not have enough balance.");
            } else {
                return amount;
            }
        }
    }
}
