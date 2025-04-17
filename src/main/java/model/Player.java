package model;

import java.util.List;

/**
 * The Player class represents a player in the game with a balance, card hand, and the ability to place bets.
 * This class tracks the players balance, their card hand, and provides methods to validate bets, and to deduct the bet
 * amount from their balance.
 */
public class Player {
    private int balance;
    List<Card> hand;

    /**
     * Constructs a new Player with the given balance.
     *
     * @param balance the initial balance of the player
     */
    public Player(int balance) {
        this.balance = balance;
    }

    /**
     * Retrieves the current balance of the player.
     *
     * @return the player's current balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Retrieves the current hand of the player.
     *
     * @return the player's current hand
     */
    public List<Card> getHand() {
        return hand;
    }

    /**
     * Sets the current hand of the player.
     *
     * @param hand the player's new hand
     */
    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    /**
     * Checks if the player can place a bet with the specified amount.
     * A player can place a bet if the bet amount is an integer less than or equal to their balance
     * and the bet amount is greater than zero.
     *
     * @param playerBet the bet amount
     * @return true if the player can place the bet, false otherwise
     */
    public Boolean canPlaceBet(int playerBet) {
        return balance >= playerBet && playerBet > 0;
    }

    /**
     * Deducts the specified bet amount from the player's balance if the bet is valid.
     *
     * @param playerBet the amount the player wants to bet
     * @throws IllegalArgumentException if the player does not have enough balance to place the bet
     */
    public void placeBet(int playerBet) {
        if (canPlaceBet(playerBet)) {
            balance -= playerBet;
        } else {
            throw new IllegalArgumentException("You do not have enough to bet.");
        }
    }
}
