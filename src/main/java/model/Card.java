package model;

/**
 * The {@code Card} record represents a playing card. All cards have a suit and rank.
 */
public record Card(String rank, String suit) {
    public int value() {
        return switch (rank) {
            case "Ace" -> 11;
            case "Jack", "Queen", "King" -> 10;
            default -> {
                try {
                    yield Integer.parseInt(rank);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid rank: " + rank);
                }
            }
        };
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
