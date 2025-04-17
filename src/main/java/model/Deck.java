package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Represents a deck of playing cards.
 * <p>
 * This class provides functionality to create a standard 52-card deck, shuffle the deck, and retrieve the deck of cards.
 * The deck is initially generated in a standard order (Ace to King of each suit) and can be shuffled for use in the game.
 */
public class Deck {
    /**
     * The stack of cards in this deck.
     * Each card is represented by a {@link Card} object.
     */
    Stack<Card> cards;

    /**
     * Constructs a new deck of cards and generates a standard 52-card deck.
     * The deck is created in the standard order and can be shuffled later.
     */
    public Deck() {
        this.cards = generateStandardDeck();
    }

    /**
     * Generates a standard deck of 52 playing cards.
     * <p>
     * This method creates a deck of cards by combining all suits (Hearts, Diamonds, Clubs, Spades)
     * with all ranks (Ace, 2, 3, ..., King). The cards are added to a stack in the default order.
     *
     * @return a {@link Stack} containing the 52 playing cards in the standard order.
     */
    private Stack<Card> generateStandardDeck() {
        List<String> suits = List.of("Hearts", "Diamonds", "Clubs", "Spades");
        List<String> ranks = List.of("Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King");

        return suits.stream().flatMap(suit -> ranks.stream().map(rank -> new Card(suit, rank))).collect(Collectors.toCollection(Stack::new));
    }

    /**
     * Shuffles the deck of cards.
     * <p>
     * This method randomly shuffles the cards in the deck using {@link Collections#shuffle(java.util.List)}.
     * It modifies the order of the cards in the deck, ensuring the cards are in a random order.
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }


    /**
     * Draws a card from the deck.
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

    /**
     * Deals a specified number of cards from the deck.
     *
     * @param numberOfCards the number of cards to deal; must be greater than zero
     * @return a list containing the dealt {@code Card} objects
     * @throws IllegalArgumentException if {@code numberOfCards} is less than or equal to zero
     */
    public List<Card> dealCards(int numberOfCards) {
        if (numberOfCards <= 0) {
            throw new IllegalArgumentException("Number of cards must be greater than zero.");
        }

        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < numberOfCards; i++) {
            cards.add(drawCard());
        }

        return cards;
    }
}
