import java.util.ArrayList;

public class CardGroup {
    private String name;
    private ArrayList<Card> cardGroup;

    public CardGroup(String name) {
        this.name = name; // Initialize the name of the card group.
        cardGroup = new ArrayList<Card>(); // Initialize the ArrayList to store cards.
        // create deck of cards
        for (int i = 1; i <= 13; i++) {
            Card card = new Card(this.name, i); // Create a new card with name and value.
            cardGroup.add(card); // Add the card to the card group.
        }
    }

    public ArrayList<Card> getCardGroup() {
        return cardGroup; // Return the ArrayList of cards in the group.
    }
}
