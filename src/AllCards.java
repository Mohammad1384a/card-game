import java.util.ArrayList;
import java.util.Collections;

public class AllCards {
    //gishniz
    private CardGroup clubs;
    private CardGroup hearts;
    private CardGroup diamonds;
    //pik
    private CardGroup spades;
    private ArrayList<Card> shuffledCards;

    public AllCards(){
        clubs = new CardGroup("clubs");
        hearts = new CardGroup("hearts");
        diamonds = new CardGroup("diamonds");
        spades = new CardGroup("spades");
        shuffledCards = new ArrayList<Card>();
        shuffledCards.addAll(clubs.getCardGroup());
        shuffledCards.addAll(hearts.getCardGroup());
        shuffledCards.addAll(diamonds.getCardGroup());
        shuffledCards.addAll(spades.getCardGroup());
        Collections.shuffle(shuffledCards);
    }

    public ArrayList<Card> getShuffledCards(){
        return shuffledCards;
    }

}
