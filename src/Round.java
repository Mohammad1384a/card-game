import java.util.ArrayList;
import java.util.Comparator;

public class Round {
    ArrayList<Card> cards;
    ArrayList<Player> players;
    ArrayList<Card> table;

    public Round(ArrayList<Card> cards,ArrayList<Player> players){
           this.cards = cards;
            this.players = players;
            players.forEach(this::handCards);
    }

    public void handCards(Player player){
        ArrayList<Card> initialCards = new ArrayList<Card>();
        for(int j =1; j<=5; j++){
            int cardRandom =(int)Math.floor(Math.random() *(cards.size() - 2 + 1) + 1);
            Card card = this.cards.get(cardRandom);
            initialCards.add(card);
            cards.remove(card);
        }
        player.setInitialCards(initialCards);
        System.out.println(player);
        player.getInitialCards().forEach((Card c) -> c.setOwner(player));
    }


    public ArrayList<Card> getTable(){
        return table;
    }

    public String determineHakem(){
        int randomHakem = (int)Math.floor(Math.random() *(players.size() - 2 + 1) + 1);
        Player hakem = players.get(randomHakem);
        hakem.setHakem(true);
        var sortingAlgorithm = Comparator.comparing(Player :: isPlayerHakem);
        players.sort(sortingAlgorithm.reversed());
        return hakem.declareHokm();
    }

    public void assessCards(String shape, String hokm){
        var sortingAlgorithm = Comparator.comparing((Card c)-> c.getName().equals(hokm)).thenComparing((Card c)->c.getName().equals(shape))
                .thenComparing(Card :: getValue);
        table.sort(sortingAlgorithm.reversed());
    }

    public Player playRound(){
        table = new ArrayList<Card>();
        String hokm = determineHakem();
        String shape = "";
        for(int i =0; i<players.size(); i++){
            Player player = players.get(i);
            Card playedCard;
            if(i == 0){
                playedCard = player.playCard(hokm);
                 shape = playedCard.getName();
            }else{
                playedCard = player.playCard(shape,hokm);
            }
            player.removeCard(playedCard);
            table.add(playedCard);
        }
        assessCards(shape,hokm);
        Player winner = table.get(0).getOwner();
        winner.setWonCards(table);
        winner.increamentWonRounds();
        return winner;
    }
}
