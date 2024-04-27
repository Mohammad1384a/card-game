import java.util.ArrayList;
import java.util.Comparator;

public class Player {
    private String name;
    private ArrayList<Card> wonCards = new ArrayList<Card>();
    private boolean isHakem = false;
    private int wonRounds = 0;
    private ArrayList<Card> initialCards;

    public Player(ArrayList<Card> initialCards,String name){
        this.initialCards = initialCards;
        this.name = name;
    }

    public void setInitialCards(ArrayList<Card> cards){
        initialCards = cards;
    }

    public int getWonRounds(){
        return wonRounds;
    }

    public void increamentWonRounds(){
       wonRounds++;
    }

    public void setWonCards(ArrayList<Card> wonCards){
        this.wonCards.addAll(wonCards);
    }

    public boolean isPlayerHakem(){
        return isHakem;
    }

    public String getName(){
        return name;
    }

    public void setHakem(boolean status){
        this.isHakem = status;
    }

    // returns the specific card types of player if not hokm otherwise a random card
    public Card playCard(String name,String hokm){
        var sortingAlgorithm = Comparator.comparing((Card c)-> c.getName().equals(name)).thenComparing((Card c)-> c.getName().equals(hokm))
                .thenComparing(Card :: getValue);
        initialCards.sort(sortingAlgorithm.reversed());
        return initialCards.get(0);
    }

    public Card playCard(String hokm){
        var sortingAlgorithm = Comparator.comparing(Card :: getValue)
                .thenComparing((Card c)-> c.getName().equals(hokm));
        initialCards.sort(sortingAlgorithm.reversed());
        return initialCards.get(0);
    }

    public ArrayList<Card> getInitialCards(){
        return initialCards;
    }

    public boolean removeCard(Card card){
        if(initialCards.contains(card)){
            initialCards.remove(card);
            return true;
        }
        return false;
    }

    public String declareHokm(){
       if(!isHakem){
           return null;
       }
       int size = initialCards.size();
      int randomHokm = (int)Math.floor(Math.random() *(size == 1 ? -1 : size - 2 + 1) + 1);
       return initialCards.get(randomHokm).getName();
    }

    @Override
    public String toString() {
        StringBuilder cards = new StringBuilder();
        for (Card initialCard : initialCards) {
            cards.append(" ").append(initialCard.getName()).append("(").append(initialCard.getValue()).append(")");
        }
        return "Player{" +
                "name='" + name + '\'' +
                "isHakem=" + isHakem +
                "wonRounds=" + wonRounds +
                ", wonCards=" + wonCards +
                ", initialCards=" + cards +
                '}';
    }
}
