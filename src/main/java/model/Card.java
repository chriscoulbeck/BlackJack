package model;

/**
 * The {@code Card} record represents a playing card. All cards have a suit and rank.
 */
public record Card(String suit, String rank) {
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
