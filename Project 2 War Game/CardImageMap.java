import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class CardImageMap {
    private static final Map<String, ImageIcon> cardImages = new HashMap<>();

    static {
        String basePath = "/Users/hallowelt/IdeaProjects/War Game Ultimate/images/cards/";

        // Map suit symbols to file suffix letters
        Map<String, String> suitMap = new HashMap<>();
        suitMap.put("♠", "S");
        suitMap.put("♥", "H");
        suitMap.put("♦", "D");
        suitMap.put("♣", "C");

        // Map ranks to file name parts
        String[] ranks = {"ACE", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        Map<String, String> rankMap = new HashMap<>();
        rankMap.put("ACE", "A");
        rankMap.put("J", "J");
        rankMap.put("Q", "Q");
        rankMap.put("K", "K");
        // Numbers (2..10) stay the same, so they aren't added here

        // Load all 52 images into the map
        for (String suitSymbol : suitMap.keySet()) {
            for (String rank : ranks) {
                String key = suitSymbol + " " + rank; // matches your Deck strings
                String rankShort = rankMap.getOrDefault(rank, rank); // A, 2..10, J, Q, K
                String fileName = rankShort + "-" + suitMap.get(suitSymbol) + ".png";
                String fullPath = basePath + fileName;

                // Load and scale image
                ImageIcon icon = new ImageIcon(fullPath);
                Image scaled = icon.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH);
                cardImages.put(key, new ImageIcon(scaled));
            }
        }
    }

    public static ImageIcon getImage(String cardKey) {
        return cardImages.get(cardKey);
    }
}
