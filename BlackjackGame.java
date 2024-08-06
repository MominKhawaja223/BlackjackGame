import java.util.Scanner;

public class BlackjackGame {
    private Deck deck; // Deck of cards used in the game
    private Player player; // Player in the game
    private Player dealer; // Dealer in the game

    public BlackjackGame() {
        deck = new Deck(); // Initialize the deck
        player = new Player(); // Initialize the player
        dealer = new Player(); // Initialize the dealer
    }

    public void play() {
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        String choice; // User's choice to hit or stand

        for (int round = 1; round <= 4; round++) { // Play 4 rounds
            System.out.println("Round " + round);
            player.resetHand(); // Reset player's hand
            dealer.resetHand(); // Reset dealer's hand

            player.addCard(deck.drawCard()); // Player draws first card
            player.addCard(deck.drawCard()); // Player draws second card
            dealer.addCard(deck.drawCard()); // Dealer draws first card
            dealer.addCard(deck.drawCard()); // Dealer draws second card

            System.out.println("Player's " + player);
            System.out.println("Dealer's first card: " + dealer.getHand().get(0));

            while (true) {
                System.out.print("Do you want to hit or stand? (hit/stand): ");
                choice = scanner.nextLine(); // Get user's choice

                if (choice.equalsIgnoreCase("hit")) {
                    player.addCard(deck.drawCard()); // Player draws another card
                    System.out.println("Player's " + player);

                    if (player.isBusted()) { // Check if player is busted
                        System.out.println("Player busted! Dealer wins this round.");
                        break;
                    }
                } else if (choice.equalsIgnoreCase("stand")) {
                    break; // Player stands
                } else {
                    System.out.println("Invalid choice. Please choose 'hit' or 'stand'.");
                }
            }

            if (!player.isBusted()) {
                while (dealer.getScore() < 17) { // Dealer draws cards until score is at least 17
                    dealer.addCard(deck.drawCard());
                }
                System.out.println("Dealer's " + dealer);

                if (dealer.isBusted() || player.getScore() > dealer.getScore()) {
                    System.out.println("Player wins this round!");
                } else if (player.getScore() < dealer.getScore()) {
                    System.out.println("Dealer wins this round!");
                } else {
                    System.out.println("It's a tie!");
                }
            }
        }
        scanner.close(); // Close the scanner
    }

    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame(); // Create a new game
        game.play(); // Start the game
    }
}
