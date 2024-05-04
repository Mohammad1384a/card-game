import java.util.ArrayList;
import java.util.Comparator;

public class Player {
    private String name;
    private ArrayList<Card> wonCards = new ArrayList<Card>();
    private boolean isHakem = false;
    private int wonRounds = 0;
    private ArrayList<Card> initialCards;

    // Constructor for the Player class
    public Player(ArrayList<Card> initialCards, String name) {

        this.initialCards = initialCards; // Initialize initialCards with the provided initialCards parameter
        this.name = name; // Set the name of the player
    }

    // Setter method to set the initial cards of the player
    public void setInitialCards(ArrayList<Card> cards) {

        initialCards = cards; // Update the initialCards with the provided cards
    }

    // Getter method to retrieve the number of rounds won by the player
    public int getWonRounds() {

        return wonRounds; // Return the number of won rounds
    }

    // Method to increment the count of won rounds by the player
    public void increamentWonRounds() {

        wonRounds++; // Increment the count of won rounds
    }

    // Method to set the cards won by the player
    public void setWonCards(ArrayList<Card> wonCards) {
        this.wonCards.addAll(wonCards); // Add all the won cards to the player's collection
    }

    // Method to check if the player is the Hakem (game leader)
    public boolean isPlayerHakem() {
        return isHakem; // Return the status of the player as the Hakem
    }

    // Method to get the name of the player
    public String getName() {
        return name; // Return the name of the player
    }

    // Method to set the player as the Hakem or not
    public void setHakem(boolean status) {
        this.isHakem = status; // Set the player's status as the Hakem based on the provided status
    }

    // returns the specific card types of player if not hokm otherwise a random card
    public Card playCard(String name, String hokm) {
        var sortingAlgorithm = Comparator.comparing((Card c) -> c.getName().equals(name))
                .thenComparing((Card c) -> c.getName().equals(hokm))
                .thenComparing(Card::getValue);
        initialCards.sort(sortingAlgorithm.reversed());
        return initialCards.get(0);
    }

    public Card playCard(String hokm) {
        // Define a sorting algorithm based on card value and whether the card's name
        // matches the 'hokm'.
        var sortingAlgorithm = Comparator.comparing(Card::getValue)
                .thenComparing((Card c) -> c.getName().equals(hokm));

        // Sort the initial cards list in descending order using the defined sorting
        // algorithm.
        initialCards.sort(sortingAlgorithm.reversed());

        // Return the card with the highest value after sorting.
        return initialCards.get(0);
    }

    // Method to retrieve the initial cards
    public ArrayList<Card> getInitialCards() {

        return initialCards;
    }

    // Method to remove a specific card from the initial cards
    public boolean removeCard(Card card) {

        if (initialCards.contains(card)) {
            initialCards.remove(card);
            return true; // Card successfully removed
        }

        return false; // Card not found
    }

    // Method to declare the "Hokm" (trump suit)
    public String declareHokm() {

        if (!isHakem) {
            return null; // Return null if the player is not the "Hakem" (game leader)
        }

        int size = initialCards.size();
        int randomHokm = (int) Math.floor(Math.random() * (size == 1 ? -1 : size - 2 + 1) + 1);
        return initialCards.get(randomHokm).getName(); // Return the name of the randomly selected card as the "Hokm"
    }

    @Override
    public String toString() {
        // Creating a StringBuilder to store the player's cards information
        StringBuilder cards = new StringBuilder();

        // Iterating through the initial cards of the player
        for (Card initialCard : initialCards) {
            // Appending the card's name and value to the StringBuilder
            cards.append(" ").append(initialCard.getName()).append("(").append(initialCard.getValue()).append(")");
        }

        // Returning the player's information as a formatted string
        return "Player{" +
                "name='" + name + '\'' +
                "isHakem=" + isHakem +
                "wonRounds=" + wonRounds +
                ", wonCards=" + wonCards +
                ", initialCards=" + cards +
                '}';
    }
}
