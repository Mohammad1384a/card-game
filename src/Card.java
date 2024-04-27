public class Card {
    private String name;
    private int value;
    private Player owner;

    public Card(String name, int value){
        this.name = name;
        this.value = value;
    }

    public void setOwner(Player owner){
        this.owner = owner;
    }

    public String getName(){
        return name;
    }

    public Player getOwner(){
        return owner;
    }

    public int getValue(){
        return value;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
