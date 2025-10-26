import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class Lobby {

	public Lobby() {
		// Create the main menu window
		JFrame frame = new JFrame("War Game");
		frame.setSize(500, 691);               // Set window size
		frame.setLocation(200, 10);            // Set window position on screen
		frame.setResizable(false);             // Disable resizing
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit app when closed

		// Use layered pane for background + components
		JLayeredPane layeredPane = frame.getLayeredPane();

		// Load background image
		ImageIcon image = new ImageIcon("/Users/hallowelt/IdeaProjects/War Game Ultimate/images/1.jpg");
		JLabel bck = new JLabel(image);
		bck.setBounds(0, 0, 500, 691);
		layeredPane.add(bck, JLayeredPane.DEFAULT_LAYER); // Add to lowest layer

		int buttonWidth = 300;
		int buttonHeight = 40;
		int x = 100;
		int startY = 190;
		int gap = 60;


		// Create Start Game button
		JButton Start = new JButton("Start Game");
		Start.setBounds(100, 190, 300, 30);
		Ini.ini(Start); // Apply style
		Start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InGame.initGame();  // Initialize a new game
				InGame.InGame();    // Launch the game UI
				frame.dispose();    // Close the menu window
			}
		});

		// Create Load Game button
		JButton Load = new JButton("Load Game");
		Load.setBounds(100, 300, 300, 30);
		Ini.ini(Load); // Apply style
		Load.addActionListener(e -> {
			InGame.loadGame();     // Load game state and launch UI
			frame.dispose();       // Close the menu window
		});

		// Create Quit button
		JButton Quit = new JButton("Quit");
		Quit.setBounds(100, 410, 300, 30);
		Ini.ini(Quit); // Apply style
		Quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // Exit the program
			}
		});

		// Authors button
		JButton authors = new JButton("Authors");
		authors.setBounds(100, 330, 300, 30);
		Ini.ini(authors);
		authors.addActionListener(e -> {
			JTextArea textArea = new JTextArea(
					"Authors:\n\n" +
							"• Sohrab Dokmechin\n" +
							"• Yiwen Zhang\n" +
							"• Jingsen Huang\n" +
							"• Haochen Gao\n" +
							"From TU Berlin Summer School"
			);
			textArea.setFont(new Font("SansSerif", Font.BOLD, 20));
			textArea.setEditable(false);
			textArea.setBackground(new Color(240, 240, 240));
			JOptionPane.showMessageDialog(frame, textArea, "About the Authors", JOptionPane.PLAIN_MESSAGE);
		});

		Start.setBounds(x, startY, buttonWidth, buttonHeight);
		Load.setBounds(x, startY + gap, buttonWidth, buttonHeight);
		authors.setBounds(x, startY + gap * 2, buttonWidth, buttonHeight);
		Quit.setBounds(x, startY + gap * 3, buttonWidth, buttonHeight);

		// Add all buttons to the layered pane (above background)
		layeredPane.add(Start, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(Load, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(authors, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(Quit, JLayeredPane.PALETTE_LAYER);

		// Make the window visible
		frame.setVisible(true);
	}
}
