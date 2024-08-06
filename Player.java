import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand; // Player's hand of cards
    private int score; // Player's score

    public Player() {
        hand = new ArrayList<>();
        score = 0;
    }

    public void addCard(Card card) {
        hand.add(card); // Add card to hand
        score += card.getValue(); // Add card value to score
    }

    public int getScore() {
        return score;
    }

    public boolean isBusted() {
        return score > 21; // Check if score is over 21
    }

    public void resetHand() {
        hand.clear(); // Clear the hand
        score = 0; // Reset the score
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    @Override
    public String toString() {
        return "Hand: " + hand + " | Score: " + score;
    }
}
