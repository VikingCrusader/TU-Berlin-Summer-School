package day9;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OkORCancel {
	public static void main(String[] args) {
		// set window
		JFrame frame = new JFrame("Hello World!");
		frame.setSize(300, 400); // Pixel
		
		//panel
		JPanel panel = new JPanel ();
		frame.add(panel);
		
		//label 
		JLabel label1 = new JLabel("Click OK to confirm");
		label1.setBounds(20,20,200,50);
		panel.add(label1);
		System.out.println();

		
		// buttons
		JButton button1 = new JButton("OK");
		button1.setBounds(20, 100, 100, 50);
		panel.add(button1);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label1.setText("OK is clicked");
		}
		});
		
		System.out.println();

		JButton button2 = new JButton("Cancel");
		button2.setBounds(20, 140, 120, 30);
		panel.add(button2);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label1.setText("Cancel is clicked");
			}
		});
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Shut down the exe after closing the window
		frame.setVisible(true);
	}
}
