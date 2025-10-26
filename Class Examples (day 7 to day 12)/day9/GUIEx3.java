package day9;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*; 

public class GUIEx3 {
public static void main(String[] args) {
		
		//设置窗口
		JFrame frame = new JFrame("My First GUI");
		frame.setSize(300, 400); // Pixel
		
		//panel
		JPanel panel = new JPanel ();
		//panel.setLayout(null);
		frame.add(panel);
		
		//Menu Object
		JMenuBar menuBar = new JMenuBar ();
		
		
		//设置标签 分层的，后面的Layer会覆盖前面的
		JLabel label1 = new JLabel("This is my first GUI");
		label1.setBounds(20,20,200,50); //using null layout
		panel.add(label1);
		
		JLabel label2 = new JLabel("This is my second line of text");
		panel.add(label2);
		label1.setBounds(20,60,200,50);
		
		System.out.println();

		// buttons
		JButton button1 = new JButton("Click Me!");
		button1.setBounds(20, 100, 100, 50);
		panel.add(button1);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Button Pressed");
			}
		});
		JButton button2 = new JButton("Cancel");
		button2.setBounds(20, 140, 120, 30);
		panel.add(button2);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setBackground(Color.black);
			}
		});
		
		// Text Field
		JTextField textField = new JTextField ("Please enter your notes");
		textField.setBounds(20, 140, 200, 100);
		panel.add(textField);
		
		//radio buttons
		JRadioButton r1 = new JRadioButton("V1");
		JRadioButton r2 = new JRadioButton("V2");
		
		
		frame.setJMenuBar(menuBar);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //关闭窗口就终止程序
		
		//File Menu
		JMenu file = new JMenu("File");
		menuBar.add(file);
		JMenu edit = new JMenu("Edit");
		menuBar.add(edit);
		
		//Menu Items
		JMenuItem open = new JMenuItem ("Open");
		JMenuItem New = new JMenuItem ("New");
		JMenuItem save = new JMenuItem ("Save");
		file.add(open);
		file.add(New);
		file.add(save);
		
		frame.setVisible(true);
	}
}
