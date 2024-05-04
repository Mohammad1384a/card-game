public class Card {
    private String name;
    private int value;
    private Player owner;

    // Constructor to initialize the card with a name and value.
    public Card(String name, int value) {
        this.name = name; // Assign the provided name to the card.
        this.value = value; // Assign the provided value to the card.
    }

    // Method to set the owner of the card.
    public void setOwner(Player owner) {
        this.owner = owner; // Assign the provided owner to the card.
    }

    // Method to get the name of the card.
    public String getName() {
        return name; // Return the name of the card.
    }

    // Method to get the owner of the card.
    public Player getOwner() {
        return owner; // Return the owner of the card
    }

    // Method to get the value of the card.
    public int getValue() {
        return value; // Return the value of the card.
    }

    // Override toString method to represent the card as a string.
    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
