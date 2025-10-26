// classic way to test the game (without GUI)
public class WarGameTestClassic {
    public static void main(String[] args) {
        
        Deck deck = new Deck();

        
        TwoPlayerDeal deal = new TwoPlayerDeal(deck);
        WarGame game = new WarGame(deal.getPlayerA(), deal.getPlayerB());

       
        System.out.println("Initial situation (top card first):\n" + game);

        int round = 0;
        while (round < 10000 && game.getWinner() < 0) { // increased limit for longer games
            round++;
            game.playRound();
            if (game.getWinner() < 0) { 
                System.out.println("State after round " + round + ":\n" + game);
            }
        }

        System.out.println("Winner: " + game.getWinner());
    }
}
