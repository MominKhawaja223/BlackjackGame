public class Card {
    private String suit; // Suit of the card (Hearts, Diamonds, Clubs, Spades)
    private String rank; // Rank of the card (2, 3, 4, ..., Jack, Queen, King, Ace)
    private int value; // Value of the card (2-10, 10 for face cards, 11 for Ace)

    public Card(String suit, String rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
