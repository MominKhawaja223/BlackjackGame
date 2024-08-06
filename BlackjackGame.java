import java.util.Scanner;

public class BlackjackGame {
    private Deck deck;
    private Player player;
    private Player dealer;

    public BlackjackGame() {
        deck = new Deck();
        player = new Player();
        dealer = new Player();
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        String choice;

        for (int round = 1; round <= 4; round++) {
            System.out.println("Round " + round);
            player.resetHand();
            dealer.resetHand();

            player.addCard(deck.drawCard());
            player.addCard(deck.drawCard());
            dealer.addCard(deck.drawCard());
            dealer.addCard(deck.drawCard());

            System.out.println("Player's " + player);
            System.out.println("Dealer's first card: " + dealer.getHand().get(0));

            while (true) {
                System.out.print("Do you want to hit or stand? (hit/stand): ");
                choice = scanner.nextLine();

                if (choice.equalsIgnoreCase("hit")) {
                    player.addCard(deck.drawCard());
                    System.out.println("Player's " + player);

                    if (player.isBusted()) {
                        System.out.println("Player busted! Dealer wins this round.");
                        break;
                    }
                } else if (choice.equalsIgnoreCase("stand")) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please choose 'hit' or 'stand'.");
                }
            }

            if (!player.isBusted()) {
                while (dealer.getScore() < 17) {
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
        scanner.close();
    }

    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame();
        game.play();
    }
}
