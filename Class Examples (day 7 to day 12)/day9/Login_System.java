package day9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Login_System {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);               
        frame.add(panel);

        JLabel label1 = new JLabel("User:");
        label1.setBounds(30, 30, 80, 25);
        panel.add(label1);

        JTextField userField = new JTextField(20);
        userField.setBounds(120, 30, 200, 25);
        panel.add(userField);

        JLabel label2 = new JLabel("Password:");
        label2.setBounds(30, 70, 80, 25);
        panel.add(label2);

        JPasswordField passField = new JPasswordField(20);
        passField.setBounds(120, 70, 200, 25);
        panel.add(passField);

        JLabel msg = new JLabel(" ");
        msg.setBounds(30, 110, 300, 25);
        panel.add(msg);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(220, 150, 100, 30);
        panel.add(loginBtn);
        
        String username = "Yiwen Zhang";
        String password = "114514";
        
        loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if()
			}
		});

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);             
    }
}
