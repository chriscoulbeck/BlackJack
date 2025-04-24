package model;

/**
 * Represents a player with a current balance.
 */
public class Player {
    private int balance;

    /**
     * Constructs a new {@code Player} with the specified starting balance.
     *
     * @param balance the initial balance
     */
    public Player(int balance) {
        this.balance = balance;
    }

    /**
     * Deducts the specified bet amount from the player's balance.
     * <p>
     * The bet amount must be positive and the player
     * must have sufficient balance to place the bet.
     * </p>
     *
     * @param amount the amount to bet
     * @throws IllegalArgumentException if the amount is zero or negative
     * @throws IllegalStateException    if the player's balance is insufficient to cover the bet
     */
    public void placeBet(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Bet amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalStateException("Insufficient balance to place bet");
        }
        balance -= amount;
    }

    /**
     * Gets the balance of the player.
     *
     * @return the player's balance
     */
    public int getBalance() {
        return balance;
    }
}
