package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a player with a current balance.
 */
public class Player {
    private int balance;
    private List<Card> hand;

    /**
     * Constructs a new {@code Player} with the specified starting balance.
     *
     * @param balance the initial balance
     */
    public Player(int balance) {
        this.balance = balance;
        this.hand = new ArrayList<>();
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
     * Adds the specified card to the player's hand.
     *
     * @param card the card to be added
     * @throws IllegalArgumentException if the card is null
     */
    public void receiveCard(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Card cannot be null");
        }
        hand.add(card);
    }

    /**
     * Gets the balance of the player.
     *
     * @return the player's balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Gets the player's hand.
     *
     * @return a list of {@link Card} objects representing the player's hand.
     */
    public List<Card> getHand() {
        return hand;
    }
}
