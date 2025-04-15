package cli;

import model.Player;

import java.util.Scanner;

/**
 * The CommandLineInterface class is a service class that handles user interactions for playing the game.
 * This class relies on the Scanner object to read input from the console.
 */
public class CommandLineInterface {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Prints a prompt to the console displaying the player's current balance
     * and asking them to bet on the current round.
     *
     * @param balance the player's current balance to be displayed
     */
    public void printBetPrompt(int balance) {
        System.out.printf("Your current balance: %d\n", balance);
        System.out.println("How much would you like to bet?\n" + "Enter a whole number (or type 'quit' to leave the table): ");
    }

    /**
     * Prompts the player to bet on the current round, and validates the input.
     * This prompt continues until a valid bet is entered, or the player quits.
     * <p>
     * If the player quits, the method returns -1.
     * If the player enters an invalid bet (non-numeric or exceeds the current balance), the prompt will repeat.
     *
     * @param player the player making the bet
     * @return the bet amount chosen by the player, or -1 is the player decides to quit
     */
    public int getPlayerBet(Player player) {
        printBetPrompt(player.getBalance());

        while (true) {
            // Get user input
            String input = scanner.nextLine();

            // Check if player wants to quit
            if (isQuitCommand(input)) {
                return -1;
            }

            // Validate numeric input
            if (!isValidInteger(input)) {
                System.out.println("❌ Please enter a valid whole number.");
                continue;
            }

            int betAmount = Integer.parseInt(input);

            // Validate against balance
            if (!player.canPlaceBet(betAmount)) {
                System.out.println("❌ Bet must be a positive number and cannot exceed your balance.");
                continue;
            }

            // Valid bet
            return betAmount;
        }
    }

    /**
     * Checks whether the player entered "quit" to exit the game.
     *
     * @param input the player's input string to be checked
     * @return true if the input is "quit" (case-insensitive), false otherwise
     */
    private boolean isQuitCommand(String input) {
        return input.equalsIgnoreCase("quit");
    }

    /**
     * Checks if the provided string is a valid integer.
     *
     * @param input the string to be checked
     * @return true if the string can be parsed into a valid integer, false otherwise
     */
    private boolean isValidInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
