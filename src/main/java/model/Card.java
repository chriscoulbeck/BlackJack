package model;

/**
 * The {@code Card} record represents a playing card. All cards have a suit and rank.
 */
public record Card(String rank, String suit) {
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
