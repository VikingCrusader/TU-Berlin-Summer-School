import java.util.ArrayList;
import java.util.List;

public class WarGame {
    private List<String> playerA;
    private List<String> playerB;
    private int winner = -1;

    public WarGame(List<String> playerA, List<String> playerB) {
        this.playerA = new ArrayList<>(playerA);
        this.playerB = new ArrayList<>(playerB);
    }


    public void playRound() {
        List<String> openPileA = new ArrayList<>();
        List<String> openPileB = new ArrayList<>();

        while (winner == -1) {
            // Check win conditions
            if (playerA.isEmpty() && playerB.isEmpty()) { 
            	winner = 0; return; 
            }
            if (playerA.isEmpty()) { 
            	winner = 2; return; 
            }
            if (playerB.isEmpty()) { 
            	winner = 1; return; 
            }

            // Draw top card face-up
            String cardA = playerA.remove(0);
            String cardB = playerB.remove(0);
            openPileA.add(cardA);
            openPileB.add(cardB);

            int cmp = CardUtil.compareByNumber(cardA, cardB);

            if (cmp == 0) {
                // Tie rule: place 3 face-down cards + 1 face-up (if possible)
                for (int i = 0; i < 3; i++) {
                    if (!playerA.isEmpty()) 
                    	openPileA.add(playerA.remove(0));
                    if (!playerB.isEmpty()) 
                    	openPileB.add(playerB.remove(0));
                }
                // If a player can't continue, decide winner immediately
                if (playerA.isEmpty()) { 
                	winner = 2; return; 
                }
                if (playerB.isEmpty()) { 
                	winner = 1; return; 
                }
                // Continue loop: next draw will be the face-up card to compare
                continue;
            } 
            else if (cmp < 0) { // Player B wins
                List<String> roundCards = new ArrayList<>();
                roundCards.addAll(openPileB); // B's cards first
                roundCards.addAll(openPileA); // then A's cards
                playerB.addAll(roundCards);
                return;
            } 
            else { // Player A wins
                List<String> roundCards = new ArrayList<>();
                roundCards.addAll(openPileA); // A's cards first
                roundCards.addAll(openPileB); // then B's cards
                playerA.addAll(roundCards);
                return;
            }
        }
    }

    public int getWinner() { return winner; }
    
    @Override
    public String toString() {
        return "Player A: " + playerA + "\nPlayer B: " + playerB;
    }
    
}
