package day9;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUIEx2 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("My First GUI");
		frame.setSize(500, 400); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout(new BorderLayout());
		
		//panel
		JPanel wPanel = new JPanel ();
		wPanel.setBackground(Color.blue);
		JPanel nPanel = new JPanel ();
		nPanel.setBackground(Color.cyan);
		JPanel ePanel = new JPanel ();
		ePanel.setBackground(Color.gray);
		JPanel sPanel = new JPanel ();
		sPanel.setBackground(Color.green);
		JPanel cPanel = new JPanel ();
		cPanel.setBackground(Color.red);
		
		frame.add(wPanel, BorderLayout.WEST);
		frame.add(nPanel, BorderLayout.NORTH);
		frame.add(ePanel, BorderLayout.EAST);
		frame.add(sPanel, BorderLayout.SOUTH);
		frame.add(cPanel, BorderLayout.CENTER);
		
		
		frame.setVisible(true);
	}

}
