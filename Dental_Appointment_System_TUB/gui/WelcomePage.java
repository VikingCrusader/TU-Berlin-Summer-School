package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;


import javax.swing.*;

import database.Database;
import logic.PasswordAuth;

public class WelcomePage {
	private static final Pattern EMAIL_PATTERN = Pattern.compile(
	        "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}$",
	        Pattern.CASE_INSENSITIVE
	);

	private static boolean isValidEmail(String email) {
	    return email != null && EMAIL_PATTERN.matcher(email.trim()).matches();
	}
    // This main is only a test
    public static void main(String[] args) {
        WelcomePageGUI();
    }

    public static void WelcomePageGUI() {
    	
        JFrame frame = new JFrame("DenSys");
        frame.setBounds(200, 100, 500, 500);
        frame.setResizable(false);
        List<JLabel> JLabels = new ArrayList<>();
        JLabels.add(new JLabel(""));
        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);
        
     // Add near your other fields:
        JCheckBox dentistCheck = new JCheckBox("I'm a dentist");
        dentistCheck.setBounds(200, 345, 200, 20);
        panel.add(dentistCheck);

        JLabel codeLbl = new JLabel("Dentist code");
        codeLbl.setBounds(80, 365, 100, 25);
        panel.add(codeLbl);
        JTextField dentistCodeField = new JTextField();  // optional
        dentistCodeField.setBounds(200, 365, 200, 25);
        panel.add(dentistCodeField);

        // Images
        ImageIcon Icon = new ImageIcon("/Users/sohrabdokmechin/Desktop/TU/2. Semester/Summer School/Summer_School_Workspace/Appointment/src/images/WelcomeImage.png");
        JLabel bck = new JLabel(Icon);
        bck.setBounds(0, 0, 500, 250);
        panel.add(bck);

        // Username
        JLabel username = new JLabel("Username");
        username.setBounds(80, 250, 100, 50);
        panel.add(username);
        JTextField usernameField = new JTextField();
        usernameField.setBounds(200, 265, 200, 25);
        panel.add(usernameField);
        // Password
        JLabel password = new JLabel("Password");
        password.setBounds(80, 300, 100, 50);
        panel.add(password);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(200, 315, 200, 25);
        panel.add(passwordField);

        // Button
        JButton login = new JButton("Login");
        login.setBounds(100, 400, 100, 30);
        panel.add(login);
        login.addActionListener(e -> {
            String Username = usernameField.getText();
            String Password = new String(passwordField.getPassword());
            boolean isDentistLogin = dentistCheck.isSelected();
            String dentistCode = dentistCodeField.getText().trim();

            String role = null;
            if (PasswordAuth.checkLogin(Username, Password)) {
                try (Connection con = Database.connect();
                     PreparedStatement ps = con.prepareStatement("SELECT role FROM users WHERE username=?")) {
                    ps.setString(1, Username);
                    try (ResultSet rs = ps.executeQuery()) {
                        if (rs.next()) role = rs.getString("role");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                Responce(JLabels, panel, "Username or password is incorrect.", 120, 415);
                return;
            }

            // If they ticked dentist, verify they are a dentist (and optional code)
            if (isDentistLogin) {
                boolean ok = false;
                try (Connection con = Database.connect()) {
                    try (PreparedStatement ps = con.prepareStatement(
                            "SELECT 1 FROM dentists d JOIN users u ON u.id=d.id " +
                            "WHERE u.username=? AND d.code=?")) {
                        ps.setString(1, Username);
                        ps.setString(2, dentistCode);
                        try (ResultSet rs = ps.executeQuery()) { ok = rs.next(); }
                    }
                } catch (Exception ex) { ex.printStackTrace(); }

                if (!ok) {
                    Responce(JLabels, panel, "Dentist verification failed.", 165, 415);
                    return;
                }
                frame.dispose();
                DentistPage.start(Username);
                return;
            }

            // Otherwise: route by role
            if ("PATIENT".equals(role)) {
                frame.dispose();
                AppointmentPage.start(Username);
            } else if ("DENTIST".equals(role)) {
                frame.dispose();
                DentistPage.start(Username);
            } else {
                Responce(JLabels, panel, "Your role has no screen yet.", 165, 415);
            }
        });


        JButton regis = new JButton("Register");
        regis.setBounds(300, 400, 100, 30);
        panel.add(regis);
        regis.addActionListener(ae -> {
            String Username = usernameField.getText();
            boolean exists = false;

            try (Connection con = Database.connect();
                 PreparedStatement ps = con.prepareStatement("SELECT 1 FROM users WHERE username=?")) {
                ps.setString(1, Username);
                try (ResultSet rs = ps.executeQuery()) {
                    exists = rs.next();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            if (exists) {
                Responce(JLabels, panel, "You have already registered.", 165, 415);
            } else {
                Registration(Username, passwordField.getText());
            }
        });

        // frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    static void Registration(String first, String second) {
        List<JLabel> JLabels = new ArrayList<>();
        JLabels.add(new JLabel(""));
        JFrame frame = new JFrame("Registration");
        frame.setBounds(200, 100, 500, 300);
        frame.setResizable(false);
        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        // Name
        JLabel name = new JLabel("Name");
        name.setBounds(80, 10, 100, 50);
        panel.add(name);
        JTextField nameField = new JTextField();
        nameField.setBounds(200, 25, 200, 25);
        panel.add(nameField);
        // Username
        JLabel username = new JLabel("Username");
        username.setBounds(80, 40, 100, 50);
        panel.add(username);
        JTextField usernameField = new JTextField();
        usernameField.setBounds(200, 55, 200, 25);
        panel.add(usernameField);
        // Password
        JLabel password = new JLabel("Password");
        password.setBounds(80, 70, 100, 50);
        panel.add(password);
        JTextField passwordField = new JTextField();
        passwordField.setBounds(200, 85, 200, 25);
        panel.add(passwordField);
        // Email
        JLabel email = new JLabel("Email");
        email.setBounds(80, 100, 100, 50);
        panel.add(email);
        JTextField emailField = new JTextField();
        emailField.setBounds(200, 115, 200, 25);
        panel.add(emailField);
        // Address
        JLabel address = new JLabel("Address");
        address.setBounds(80, 130, 100, 50);
        panel.add(address);
        JTextField addressField = new JTextField();
        addressField.setBounds(200, 145, 200, 25);
        panel.add(addressField);
        // Phone Number
        JLabel phone = new JLabel("Phone Number");
        phone.setBounds(80, 160, 100, 50);
        panel.add(phone);
        JTextField phoneField = new JTextField();
        phoneField.setBounds(200, 175, 200, 25);
        panel.add(phoneField);

        usernameField.setText(first);
        passwordField.setText(second);

        // Button
        JButton register = new JButton("Register");
        register.setBounds(190, 215, 100, 30);
        panel.add(register);
        register.addActionListener(e -> {
            String Name = nameField.getText();
            String Username = usernameField.getText();
            String Password = new String(passwordField.getText());
            String Email = emailField.getText();
            String Address = addressField.getText();
            String Phone = phoneField.getText();

            if (Name.isEmpty() || Username.isEmpty() || Password.isEmpty() ||
                Email.isEmpty() || Address.isEmpty() || Phone.isEmpty()) {
                Responce(JLabels, panel, "Please fill all fields.", 310, 205);
                return;
            }
            
            if (!isValidEmail(Email)) {
                Responce(JLabels, panel, "Enter a valid email address.", 295, 205);
                return;
            }
            
            try {
                PasswordAuth.createUser(Name, Username, Password, Email, Phone, Address, "PATIENT");
                frame.dispose();
            } catch (Exception ex) {
                ex.printStackTrace();
                Responce(JLabels, panel, "Error: " + ex.getMessage(), 170, 205);
            }
        });

        // frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

   /* static String[] Readfile() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("users.txt"));
            String[] Users = lines.toArray(new String[0]);
            return Users;
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    static void Writefile(String a) {
        String newline = a;
        try {
            Files.write(Paths.get("users.txt"), Collections.singletonList(newline), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    
    static JTextField addField(JPanel panel, String label, int y) {
        JLabel l = new JLabel(label);
        l.setBounds(80, y, 100, 50);
        panel.add(l);
        JTextField field = new JTextField();
        field.setBounds(200, y + 15, 200, 25);
        panel.add(field);
        return field;
    }

    static void Responce(List<JLabel> l, JPanel p, String txt, int x, int y) {
        JLabel lastLabel = l.get(l.size()-1);
        p.remove(lastLabel);
        p.revalidate();
        p.repaint();
        JLabel regisAlready = new JLabel(txt);
        regisAlready.setBounds(x, y, 500, 50);
        p.add(regisAlready);
        p.revalidate();
        p.repaint();
        l.add(regisAlready);
    }

}
