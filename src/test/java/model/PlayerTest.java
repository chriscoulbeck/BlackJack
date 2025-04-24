package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {
    Player player ;
    int initialBalance;

    @BeforeEach
    void setUp() {
        player = new Player(100);
        initialBalance = player.getBalance();
    }

    @Test
    void placeBet_validAmount_deductsBetAmount() {
        int amount = 10;
        player.placeBet(amount);
        assertEquals(initialBalance - amount, player.getBalance());
    }

    @Test
    void placeBet_amountEqualToBalance_balanceIsZero() {
        player.placeBet(initialBalance);
        assertEquals(0, player.getBalance());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -10})
    void placeBet_nonPositiveAmount_throwsIllegalArgumentException(int nonPositiveAmount) {
        assertThrows(IllegalArgumentException.class, () -> player.placeBet(nonPositiveAmount));
        assertEquals(initialBalance, player.getBalance());
    }

    @Test
    void placeBet_insufficientBalance_throwsIllegalStateException() {
        assertThrows(IllegalStateException.class, () -> player.placeBet(201));
        assertEquals(initialBalance, player.getBalance());
    }

    @Test
    void receiveCard_null_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> player.receiveCard(null));
    }

    @Test
    void receiveCard_validCard_addCardToHand() {
        Card validCard = new Card("Ace", "Clubs");
        player.receiveCard(validCard);

        assertEquals(1, player.getHand().size());
        assertEquals("Ace", player.getHand().getFirst().rank());
        assertEquals("Clubs", player.getHand().getFirst().suit());
    }
}
