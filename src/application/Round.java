import java.util.ArrayList;
import java.util.Comparator;

public class Round {
    ArrayList<Card> cards;
    ArrayList<Player> players;
    ArrayList<Card> table;

    public Round(ArrayList<Card> cards, ArrayList<Player> players) {
        // Initialize the Round with the given cards and players
        this.cards = cards;
        this.players = players;
        players.forEach(this::handCards); // Distribute cards to each player
    }

    public void handCards(Player player) {
        ArrayList<Card> initialCards = new ArrayList<Card>();

        for (int j = 1; j <= 5; j++) {
            int cardRandom = (int) Math.floor(Math.random() * (cards.size() - 2 + 1) + 1);
            Card card = this.cards.get(cardRandom); // Get a random card from the deck
            initialCards.add(card); // Add the card to the player's initial hand
            cards.remove(card); // Remove the card from the deck
        }

        player.setInitialCards(initialCards); // Set the initial hand for the player
        System.out.println(player); // Print the player's details
        player.getInitialCards().forEach((Card c) -> c.setOwner(player)); // Set the owner for each card in the player's
                                                                          // hand
    }

    public ArrayList<Card> getTable() {
        return table; // Returns the table of cards
    }

    public String determineHakem() {
        // Generate a random index to select a player as the "Hakem"
        int randomHakem = (int) Math.floor(Math.random() * (players.size() - 2 + 1) + 1);
        Player hakem = players.get(randomHakem); // Select a player as the "Hakem"
        hakem.setHakem(true); // Set the selected player as the "Hakem"
        // Define a sorting algorithm based on whether a player is the "Hakem"
        var sortingAlgorithm = Comparator.comparing(Player::isPlayerHakem);
        players.sort(sortingAlgorithm.reversed()); // Sort the players based on the "Hakem" status
        return hakem.declareHokm(); // Have the "Hakem" declare the "Hokm"
    }

    public void assessCards(String shape, String hokm) {
        // Define a sorting algorithm based on the provided shape and hokm
        var sortingAlgorithm = Comparator.comparing((Card c) -> c.getName().equals(hokm))
                .thenComparing((Card c) -> c.getName().equals(shape))
                .thenComparing(Card::getValue);
        table.sort(sortingAlgorithm.reversed());
    }

    public Player playRound() {
        table = new ArrayList<Card>(); // Initialize the table for the round
        String hokm = determineHakem(); // Determine the hokm for the round
        String shape = ""; // Initialize the shape variable

        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i); // Get the current player
            Card playedCard;
            if (i == 0) {
                playedCard = player.playCard(hokm); // First player plays a card based on hokm
                shape = playedCard.getName(); // Set the shape based on the card played
            } else {
                playedCard = player.playCard(shape, hokm); // Other players play cards based on shape and hokm
            }
            player.removeCard(playedCard); // Remove the played card from the player's hand
            table.add(playedCard); // Add the played card to the table
        }

        assessCards(shape, hokm); // Assess the cards played in the round
        Player winner = table.get(0).getOwner(); // Get the winner of the round
        winner.setWonCards(table); // Set the won cards for the winner
        winner.increamentWonRounds(); // Increment the number of rounds won by the winner
        return winner; // Return the winner of the round
    }

}
