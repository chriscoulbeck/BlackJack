package model;

import java.util.Collections;
import java.util.Stack;

/**
 * Models a deck of playing cards.
 *
 * <p>
 * This class provides functionality to create a standard 52-card deck, shuffle the deck, and draw cards.
 * The deck is initially generated in standard order (Ace to King of each suit) and can be shuffled for use in the game.
 */
public class Deck {
    private final Stack<Card> cards;
    private final static String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private final static String[] RANKS = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

    /**
     * Constructs a new deck of cards in standard order.
     */
    public Deck() {
        cards = new Stack<>();
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    /**
     * Shuffles the deck of cards into random order.
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Draws a {@code Card} from the top of the deck.
     * If the deck is empty, returns null.
     *
     * @return the card drawn from the deck, or null if the deck is empty
     */
    public Card drawCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.pop();
    }
}
