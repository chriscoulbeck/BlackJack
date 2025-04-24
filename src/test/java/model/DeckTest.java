package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {
    private Deck deck;
    private int initialSize;

    @BeforeEach
    public void setUp() {
        deck = new Deck();
        initialSize = deck.size();
    }

    @Test
    void drawCard_nonEmptyDeck_removesSingleCardFromDeck() {
        assertFalse(deck.isEmpty());

        Card card = deck.drawCard();

        assertNotNull(card);
        assertEquals(initialSize - 1, deck.size());
    }

    @Test
    void drawCard_emptyDeck_returnsNull() {
        while (!deck.isEmpty()) {
            deck.drawCard();
        }

        Card card = deck.drawCard();

        assertNull(card);
    }
}
