import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Ini {
		
	public static void ini(JButton a) {
		a.setOpaque(false);
		a.setContentAreaFilled(false);
		a.setBorderPainted(false);
		Font currentFont = a.getFont();
		Font newFont = currentFont.deriveFont(32f);
		a.setFont(newFont);
		a.setForeground(Color.BLACK);
	}
	
	public static void ini(JLabel a) {
		a.setOpaque(false);
		Font currentFont = a.getFont();
		Font newFont = currentFont.deriveFont(20f);
		a.setFont(newFont);
	}
	
}
