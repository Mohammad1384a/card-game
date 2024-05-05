import java.util.*;

public class Game {
    private ArrayList<Player> players = new ArrayList<Player>(); // Initialize an ArrayList to store players.
    private ArrayList<String> names = new ArrayList<String>(List.of("ali", "jafar", "hossein", "mamad"));

    public Game() {
        for (int i = 0; i < 4; i++) {
            ArrayList<Card> initialCards = new ArrayList<Card>(); // Initialize an ArrayList to store initial cards for
                                                                  // each player.
            Player player = new Player(initialCards, names.get(i)); // Create a new player with initial cards and a
                                                                    // name.
            players.add(player); // Add the player to the list of players.
        }

        int round = 1; // Initialize the round counter.

        while (round <= 25) {
            AllCards allCards = new AllCards(); // Create a new deck of cards.
            Round newRound = new Round(allCards.getShuffledCards(), players); // Start a new round with shuffled cards
                                                                              // and players.
            Player winner = newRound.playRound(); // Play the round and determine the winner.
            System.out.println("the winner of " + round + " is " + winner.getName()); // Print the winner of the round.
            round++; // Increment the round counter.
            if (winner.getWonRounds() == 7) {
                System.out.println("the winner of all game is " + winner.getName()); // Print the overall winner if they
                                                                                     // have won 7 rounds.
                break; // Exit the game loop.
            }
        }
    }

    @Override
    // Override the toString method to provide a custom string representation of the
    // Game object.
    public String toString() {
        return "Game{" +
                "players=" + players +
                '}';
    }

}
