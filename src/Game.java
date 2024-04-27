import java.util.*;

public class Game {
    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<String> names = new ArrayList<String>(List.of("ali","jafar","hossein","mamad"));

    public Game(){
        for(int i =0; i<4; i++) {
            ArrayList<Card> initialCards = new ArrayList<Card>();
            Player player = new Player(initialCards,names.get(i));
            players.add(player);
        }
       int round = 1;
        while (round <= 25){
            AllCards allCards = new AllCards();
            Round newRound = new Round(allCards.getShuffledCards(),players);
            Player winner = newRound.playRound();
            System.out.println("the winner of " + round + " is " + winner.getName());
            round++;
            if(winner.getWonRounds() == 7){
                System.out.println("the winner of all game is " + winner.getName());
                break;
            }
        }
    }


    @Override
    public String toString() {
        return "Game{" +
                "players=" + players +
                '}';
    }
}
