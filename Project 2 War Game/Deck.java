import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    // types and numbers
    private String[] types = {"♠", "♥", "♦", "♣"};
    private String[] numbers = {"ACE", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    // create a  deck as "Type Number", e.g., "Spade 10"
    private final List<String> cards = new ArrayList<>(52);

    public Deck() {
        for (String t : types) {
            for (String n : numbers) {
                cards.add(t + " " + n);
            }
        }
        Collections.shuffle(cards); // shuffle
    }

    // return a shuffled deck
    public List<String> getCards() {
        Collections.shuffle(cards);
        return cards;
    }
}

class TwoPlayerDeal {
    private final List<String> playerA;
    private final List<String> playerB;

    public TwoPlayerDeal(Deck deck) {
        List<String> d = new ArrayList<>(deck.getCards()); // already shuffled once per call
        // top half belongs to A, bottom to B
        this.playerA = new ArrayList<>(d.subList(0, 26));
        this.playerB = new ArrayList<>(d.subList(26, 52));
    }

    public List<String> getPlayerA() { return playerA; }
    public List<String> getPlayerB() { return playerB; }
}

class CardUtil {
    // extract the number part from "Type Number"
    public static String extractNumber(String card) {
    	// the index of space in the combination
        int idx = card.lastIndexOf(' ');
        // return the next one after the space till the end---- which is the number
        return card.substring(idx + 1);
    }

    // convert number string to comparable int (ACE high)
    public static int numberToValue(String num) {
        switch (num) {
            case "ACE": return 14;
            case "K":   return 13;
            case "Q":   return 12;
            case "J":   return 11;
            default:    return Integer.parseInt(num); // "2".."10"
        }
    }

    // compare two "Type Number" strings by rank only (ACE high)
    // >0 if a>b, 0 if equal, <0 if a<b
    public static int compareByNumber(String cardA, String cardB) {
        int va = numberToValue(extractNumber(cardA));
        int vb = numberToValue(extractNumber(cardB));
        return Integer.compare(va, vb);
    }
}