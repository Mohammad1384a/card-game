import java.util.ArrayList;
import java.util.Collections;

public class AllCards {
    // Define card groups for each suit: clubs, hearts, diamonds, spades.
    private CardGroup clubs;
    private CardGroup hearts;
    private CardGroup diamonds;
    private CardGroup spades;
    private ArrayList<Card> shuffledCards; // Initialize an ArrayList to store shuffled cards.

    public AllCards() {
        clubs = new CardGroup("clubs"); // Create a new card group for clubs.
        hearts = new CardGroup("hearts"); // Create a new card group for hearts.
        diamonds = new CardGroup("diamonds"); // Create a new card group for diamonds.
        spades = new CardGroup("spades"); // Create a new card group for spades.
        shuffledCards = new ArrayList<Card>(); // Initialize the shuffled cards ArrayList.
        shuffledCards.addAll(clubs.getCardGroup()); // Add all club cards to shuffledCards.
        shuffledCards.addAll(hearts.getCardGroup()); // Add all heart cards to shuffledCards.
        shuffledCards.addAll(diamonds.getCardGroup()); // Add all diamond cards to shuffledCards.
        shuffledCards.addAll(spades.getCardGroup()); // Add all spade cards to shuffledCards.
        Collections.shuffle(shuffledCards); // Shuffle the cards in the shuffledCards ArrayList.
    }

    // Get the shuffled cards.
    public ArrayList<Card> getShuffledCards() {
        return shuffledCards;
    }
}
