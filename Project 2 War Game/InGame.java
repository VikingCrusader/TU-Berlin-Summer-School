import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class InGame {
    private static WarGame game;
    private static JLabel youCardLabel;
    private static JLabel compCardLabel;
    private static JLabel youLabel;
    private static JLabel compLabel;

    public static void initGame() {
        Deck deck = new Deck();
        TwoPlayerDeal deal = new TwoPlayerDeal(deck);
        game = new WarGame(deal.getPlayerA(), deal.getPlayerB());
    }

    public static void InGame() {
        // Prepare the game
        if (game == null) {
            JOptionPane.showMessageDialog(null, "Game not initialized.");
            return;
        }

        // Create frame
        JFrame frame = new JFrame("War Game");
        frame.setSize(727, 432);
        frame.setLocation(200, 10);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Background
        ImageIcon backgroundImage = new ImageIcon(
            "/Users/hallowelt/IdeaProjects/War Game Ultimate/images/2.png"
        );
        JLabel bck = new JLabel(backgroundImage);
        bck.setBounds(0, 0, 727, 432);
        frame.setContentPane(bck);
        bck.setLayout(null);

        // Labels for players with counters (moved more to center)
        youLabel = new JLabel("You: " + gameDeckSize(game, 1));
        youLabel.setBounds(220, 90, 200, 30);
        youLabel.setForeground(Color.WHITE);
        bck.add(youLabel);

        compLabel = new JLabel("Computer: " + gameDeckSize(game, 2));
        compLabel.setBounds(380, 90, 200, 30);
        compLabel.setForeground(Color.WHITE);
        bck.add(compLabel);

        // Card back image (scaled)
        ImageIcon backIcon = new ImageIcon(
            new ImageIcon("/Users/hallowelt/IdeaProjects/War Game Ultimate/images/cards/BACK.png")
                .getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH)
        );

        // Face-up labels
        youCardLabel = new JLabel();
        compCardLabel = new JLabel();

        // Layered panes for cards (closer together + more back visible)
        JLayeredPane youCardPane = createCardPane(backIcon, youCardLabel);
        youCardPane.setBounds(230, 130, 100, 170); // moved closer to center
        bck.add(youCardPane);

        JLayeredPane compCardPane = createCardPane(backIcon, compCardLabel);
        compCardPane.setBounds(370, 130, 100, 170); // moved closer to center
        bck.add(compCardPane);

        // Buttons evenly spread
        JButton save = new JButton("Save Game");
        JButton go = new JButton("GO");
        JButton quit = new JButton("Quit");

        go.addActionListener((ActionEvent e) -> drawCards());
        save.addActionListener(e -> saveGame());


        quit.addActionListener(e -> {
            new Lobby();
            frame.dispose();
        });

        // Spread buttons evenly across frame width
        int buttonWidth = 150;
        int buttonHeight = 30;
        int yPos = 350;
        int space = (727 - (buttonWidth * 3)) / 4; // equal spacing

        save.setBounds(space, yPos, buttonWidth, buttonHeight);
        go.setBounds(space * 2 + buttonWidth, yPos, buttonWidth, buttonHeight);
        quit.setBounds(space * 3 + buttonWidth * 2, yPos, buttonWidth, buttonHeight);

        bck.add(save);
        bck.add(go);
        bck.add(quit);

        frame.setVisible(true);
    }

    // Create layered pane with card back & face-up shifted more down
    private static JLayeredPane createCardPane(ImageIcon backIcon, JLabel faceLabel) {
        JLayeredPane pane = new JLayeredPane();
        pane.setPreferredSize(new Dimension(100, 170));

        JLabel backLabel = new JLabel(backIcon);
        backLabel.setBounds(0, 0, 100, 150);

        faceLabel.setBounds(0, 20, 100, 150); // shifted down more for more back visible

        pane.add(backLabel, Integer.valueOf(0));  // back layer
        pane.add(faceLabel, Integer.valueOf(1)); // face-up layer

        return pane;
    }

    private static void drawCards() {
        if (game.getWinner() >= 0) {
            if (game.getWinner() == 1) {
                SoundPlayer.play("audios/victorysound.wav");
                JOptionPane.showMessageDialog(null, "Great! Victory belongs to you!", "Victory", JOptionPane.INFORMATION_MESSAGE);
            } else {
                SoundPlayer.play("audios/gameoversound.wav");
                JOptionPane.showMessageDialog(null, "Defeat... you need more luck next time.", "Defeat", JOptionPane.INFORMATION_MESSAGE);
            }
            return;
        }



        String cardYou = getTopCard(game, 1);
        String cardComp = getTopCard(game, 2);

        game.playRound();
        SoundPlayer.play("audios/cardsound.wav");


        if (cardYou != null) youCardLabel.setIcon(CardImageMap.getImage(cardYou));
        if (cardComp != null) compCardLabel.setIcon(CardImageMap.getImage(cardComp));

        youLabel.setText("You: " + gameDeckSize(game, 1));
        compLabel.setText("Computer: " + gameDeckSize(game, 2));
    }

    private static String getTopCard(WarGame game, int player) {
        try {
            java.lang.reflect.Field deckField = WarGame.class.getDeclaredField(player == 1 ? "playerA" : "playerB");
            deckField.setAccessible(true);
            java.util.List<String> deck = (java.util.List<String>) deckField.get(game);
            return deck.isEmpty() ? null : deck.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static int gameDeckSize(WarGame game, int player) {
        try {
            java.lang.reflect.Field deckField = WarGame.class.getDeclaredField(player == 1 ? "playerA" : "playerB");
            deckField.setAccessible(true);
            java.util.List<String> deck = (java.util.List<String>) deckField.get(game);
            return deck.size();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static void saveGame() {
        if (game == null) {
            JOptionPane.showMessageDialog(null, "No game to save.");
            return;
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("saved_game.dat"))) {
            GameState state = new GameState(getDeck(game, 1), getDeck(game, 2));
            oos.writeObject(state);
            JOptionPane.showMessageDialog(null, "Game saved!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to save game.");
        }
    }


    public static void loadGame() {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("saved_game.dat"))) {
            GameState state = (GameState) ois.readObject();
            game = new WarGame(state.getPlayerA(), state.getPlayerB());
            System.out.println("Loaded A size = " + state.getPlayerA().size());
            InGame();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to load game.");
        }
    }


    private static List<String> getDeck(WarGame game, int player) {
        try {
            Field deckField = WarGame.class.getDeclaredField(player == 1 ? "playerA" : "playerB");
            deckField.setAccessible(true);
            return new ArrayList<>((List<String>) deckField.get(game));
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
