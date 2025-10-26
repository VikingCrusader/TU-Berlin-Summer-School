package day9;

public class DealRunner {
    public static void main(String[] args) {
        Deck deck = new Deck();
        TwoPlayerDealCards deal = new TwoPlayerDealCards(deck);
        System.out.println("A: " + deal.getPlayerA());
        System.out.println("B: " + deal.getPlayerB());
    }
}
