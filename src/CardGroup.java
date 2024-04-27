import java.util.ArrayList;

public class CardGroup {
    private String name;
    private ArrayList<Card> cardGroup;

    public CardGroup(String name){
        this.name = name;
        cardGroup = new ArrayList<Card>();
        // create deck of cards
        for(int i = 1; i<= 13; i++){
            Card card = new Card(this.name,i);
           cardGroup.add(card);
        }
    }

    public ArrayList<Card> getCardGroup(){
        return cardGroup;
    }
}
