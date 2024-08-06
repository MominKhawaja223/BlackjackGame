import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards; // List of cards in the deck

    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};

        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                cards.add(new Card(suit, ranks[i], values[i])); // Add card to the deck
            }
        }
        shuffle(); // Shuffle the deck
    }

    public void shuffle() {
        Collections.shuffle(cards); // Shuffle the cards
    }

    public Card drawCard() {
        return cards.remove(0); // Draw a card from the top of the deck
    }
}
