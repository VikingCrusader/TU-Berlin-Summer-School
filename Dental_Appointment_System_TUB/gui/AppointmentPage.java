package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class AppointmentPage {
	private static String loggedInUsername;
    /*public static void main(String[] args) {
        start();
    }*///This is just for testing. Just delete it if you don't like
    static void start(String username){
    	loggedInUsername = username;
        // Frame
        JFrame frame = new JFrame("Options");
        frame.setBounds(200, 120, 520, 420);
        frame.setResizable(false);

        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        // Button
        JButton myApm = new JButton("My appointments");
        JButton newApm = new JButton("New Appointment");
        JButton logout = new JButton("Logout");
        int bw = 320, bh = 50, gap = 30, startY = 90, x = (520 - bw) / 2;
        myApm.setBounds(x, startY + 0, bw, bh);
        newApm.setBounds(x, startY + (bh + gap), bw, bh);
        logout.setBounds(x, startY + 2 * (bh + gap), bw, bh);
        panel.add(myApm);
        panel.add(newApm);
        panel.add(logout);

        // Actions
        myApm.addActionListener(e -> {
            if (isDentist(loggedInUsername)) {
                openDentistAppointmentsWindow(frame);
            } else {
                openMyAppointmentWindow(frame);
            }
        });

        newApm.addActionListener(e -> {
            if (isDentist(loggedInUsername)) {
                openAddAppointmentForDentist(frame);
            } else {
                openNewAppointmentWindow(frame);
            }
        });

        // Logout button: close Options window a
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                WelcomePage.WelcomePageGUI();
            }
        });

        // Frame Settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void openNewAppointmentWindow(JFrame parent) {
        JFrame frame = new JFrame("Calendar");
        frame.setBounds(parent.getX() + 40, parent.getY() + 40, 520, 420);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

     // ---- Dentist drop down (from DB) ----
        JLabel dentistLbl = new JLabel("Dentist:");
        dentistLbl.setBounds(20, 55, 100, 25);
        panel.add(dentistLbl);

        JComboBox<String> dentistDropdown = new JComboBox<>();
        dentistDropdown.setBounds(120, 55, 200, 25);
        panel.add(dentistDropdown);

        // Load dentists into dropdown
        try (Connection con = database.Database.connect();
        	     PreparedStatement ps = con.prepareStatement(
        	         "SELECT name FROM users WHERE role='DENTIST' ORDER BY name")) {
        	    try (ResultSet rs = ps.executeQuery()) {
        	        while (rs.next()) {
        	            dentistDropdown.addItem(rs.getString("name"));
        	        }
        	    }
        	} catch (Exception ex) {
        	    ex.printStackTrace();
        	    dentistDropdown.addItem("(error loading)");
        	}


        // Top row: date field + "..." + "Ok"
        JTextField apmDate = new JTextField();
        JButton chooseDate = new JButton("...");
        JButton OK = new JButton("Ok");
        apmDate.setBounds(20, 20, 330, 30);
        chooseDate.setBounds(360, 20, 40, 30);
        OK.setBounds(410, 20, 90, 30);
        panel.add(apmDate);
        panel.add(chooseDate);
        panel.add(OK);

        // Time buttons
        String[] times = {"09:00", "10:00", "11:00", "14:00", "15:00", "16:00"};
        JButton button9 = new JButton(times[0]);
        JButton button10 = new JButton(times[1]);
        JButton button11 = new JButton(times[2]);
        JButton button14 = new JButton(times[3]);
        JButton button15 = new JButton(times[4]);
        JButton button16 = new JButton(times[5]);
        button9.setBounds(20, 80, 150, 40);
        button10.setBounds(190, 80, 150, 40);
        button11.setBounds(360, 80, 150, 40);
        button14.setBounds(20, 140, 150, 40);
        button15.setBounds(190, 140, 150, 40);
        button16.setBounds(360, 140, 150, 40);
        panel.add(button9); panel.add(button10); panel.add(button11);
        panel.add(button14); panel.add(button15); panel.add(button16);

        final JButton[] timeButtons = {button9, button10, button11, button14, button15, button16};
        final String[] selectedTime = {null};
        ActionListener timePick = ev -> {
            for (JButton b : timeButtons) b.setEnabled(true);
            JButton btChose = (JButton) ev.getSource();
            btChose.setEnabled(false);
            selectedTime[0] = btChose.getText();
        };
        for (JButton b : timeButtons) b.addActionListener(timePick);

        chooseDate.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(frame, "Enter date (YYYY-MM-DD):", LocalDate.now().toString());
            if (input == null) return;
            try {
                LocalDate.parse(input);
                apmDate.setText(input);
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid date format.");
            }
        });

        OK.addActionListener(e -> {
            String date = apmDate.getText().trim();
            if (date.isEmpty()) { JOptionPane.showMessageDialog(frame, "Pick a date"); return; }
            String selectedDentistName = (String) dentistDropdown.getSelectedItem();
            if (selectedDentistName == null || selectedDentistName.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Pick a dentist");
                return;
            }

            String dentist = (String) dentistDropdown.getSelectedItem();   // <-- from dropdown
            if (dentist == null || dentist.isBlank()) {
                JOptionPane.showMessageDialog(frame, "Pick a dentist"); 
                return;
            }

            try (java.sql.Connection con = database.Database.connect();
                 java.sql.PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO appointments (patient_id, dentist_id, start_time, end_time, status) " +
                    "VALUES ((SELECT id FROM users WHERE username=?), (SELECT id FROM users WHERE name=?), ?, ?, 'BOOKED')")) {

                int h = Integer.parseInt(selectedTime[0].substring(0, 2));
                java.time.LocalDate d = java.time.LocalDate.parse(date);
                java.time.LocalDateTime start = d.atTime(h, 0);
                java.time.LocalDateTime end   = start.plusHours(1);

                ps.setString(1, loggedInUsername);
                ps.setString(2, dentist);  
                ps.setTimestamp(3, java.sql.Timestamp.valueOf(start));
                ps.setTimestamp(4, java.sql.Timestamp.valueOf(end));
                ps.executeUpdate();

                JOptionPane.showMessageDialog(frame, "Booked " + start.toString().replace('T',' '));
                frame.dispose();
            } catch (java.sql.SQLIntegrityConstraintViolationException ex) {
                JOptionPane.showMessageDialog(frame, "Slot already taken.");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });


        JButton back = new JButton("Go back");
        back.setBounds((520 - 120) / 2, 300, 120, 40);
        back.addActionListener(e -> frame.dispose());
        panel.add(back);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void openMyAppointmentWindow(JFrame parent) {
        // Load your appointments (BOOKED) from DB for the logged-in user
        java.util.List<String[]> rows = new java.util.ArrayList<>(); // each: {id, label}
        try (java.sql.Connection con = database.Database.connect();
             java.sql.PreparedStatement ps = con.prepareStatement(
                 "SELECT a.id, a.start_time, a.end_time, d.name AS dentist " +
                 "FROM appointments a " +
                 "JOIN users p ON p.id=a.patient_id " +
                 "JOIN users d ON d.id=a.dentist_id " +
                 "WHERE p.username=? AND a.status='BOOKED' " +
                 "ORDER BY a.start_time")) {
            ps.setString(1, loggedInUsername);
            try (java.sql.ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String id = String.valueOf(rs.getLong("id"));
                    java.time.format.DateTimeFormatter fmt = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    String start = rs.getTimestamp("start_time").toLocalDateTime().format(fmt);
                    String end   = rs.getTimestamp("end_time").toLocalDateTime().format(fmt);
                    String dentist = rs.getString("dentist");
                    String label = start + " → " + end + "  with " + dentist; // or just start + " with " + dentist

                    rows.add(new String[]{ id, label });
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(parent, "Failed to load appointments: " + ex.getMessage());
            return;
        }

        String[] labels = rows.stream().map(a -> a[1]).toArray(String[]::new);

        JFrame frame = new JFrame("My Appointments");
        frame.setBounds(parent.getX() + 40, parent.getY() + 40, 520, 110 + labels.length * 40);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        final int[] selectedIndex = { -1 };

        java.awt.event.ActionListener pick = ev -> {
            for (java.awt.Component comp : panel.getComponents()) {
                if (comp instanceof JButton) ((JButton) comp).setEnabled(true);
            }
            JButton btn = (JButton) ev.getSource();
            btn.setEnabled(false);
            // find index
            for (int i = 0; i < labels.length; i++) {
                if (btn.getText().equals(labels[i])) { selectedIndex[0] = i; break; }
            }
        };

        int y = 20;
        for (String label : labels) {
            JButton b = new JButton(label);
            b.setBounds((520 - 400) / 2, y, 400, 30);
            b.addActionListener(pick);
            panel.add(b);
            y += 40;
        }

        JButton ok = new JButton("OK");
        ok.setBounds((520 - 120) / 4, 20 + labels.length * 40, 120, 40);
        ok.addActionListener(e -> frame.dispose());
        panel.add(ok);

        JButton cancel = new JButton("Cancel");
        cancel.setBounds((520 - 120) / 4 * 3, 20 + labels.length * 40, 120, 40);
        cancel.addActionListener(e -> {
            if (selectedIndex[0] == -1) {
                JOptionPane.showMessageDialog(frame, "Please choose an appointment.");
                return;
            }
            String apptId = rows.get(selectedIndex[0])[0];
            try (java.sql.Connection con = database.Database.connect();
                 java.sql.PreparedStatement ps = con.prepareStatement(
                     // HARD DELETE:
                     "DELETE a FROM appointments a " +
                     "JOIN users u ON u.id=a.patient_id " +
                     "WHERE a.id=? AND u.username=?")) {
                ps.setLong(1, Long.parseLong(apptId));
                ps.setString(2, loggedInUsername);
                int n = ps.executeUpdate();
                JOptionPane.showMessageDialog(frame, n > 0 ? "Appointment Canceled." : "Nothing Canceled.");
                frame.dispose();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Delete failed: " + ex.getMessage());
            }
        });
        panel.add(cancel);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
    
    private static void openDentistAppointmentsWindow(JFrame parent) {
        java.util.List<String[]> rows = new java.util.ArrayList<>(); // each: {id, label}
        try (java.sql.Connection con = database.Database.connect();
             java.sql.PreparedStatement ps = con.prepareStatement(
                 "SELECT a.id, a.start_time, a.end_time, p.name AS patient " +
                 "FROM appointments a " +
                 "JOIN users d ON d.id = a.dentist_id " +
                 "JOIN users p ON p.id = a.patient_id " +
                 "WHERE d.username = ? AND a.status = 'BOOKED' " +
                 "ORDER BY a.start_time")) {
            ps.setString(1, loggedInUsername);
            try (java.sql.ResultSet rs = ps.executeQuery()) {
                java.time.format.DateTimeFormatter fmt =
                    java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                while (rs.next()) {
                    String id = String.valueOf(rs.getLong("id"));
                    String start = rs.getTimestamp("start_time").toLocalDateTime().format(fmt);
                    String end   = rs.getTimestamp("end_time").toLocalDateTime().format(fmt);
                    String patient = rs.getString("patient");
                    String label = start + " → " + end + "  with " + patient;
                    rows.add(new String[]{ id, label });
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(parent, "Failed to load appointments: " + ex.getMessage());
            return;
        }

        String[] labels = rows.stream().map(a -> a[1]).toArray(String[]::new);

        JFrame frame = new JFrame("Appointments with Me");
        frame.setBounds(parent.getX() + 40, parent.getY() + 40, 520, 110 + labels.length * 40);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        final int[] selectedIndex = { -1 };
        java.awt.event.ActionListener pick = ev -> {
            for (java.awt.Component comp : panel.getComponents()) {
                if (comp instanceof JButton) ((JButton) comp).setEnabled(true);
            }
            JButton btn = (JButton) ev.getSource();
            btn.setEnabled(false);
            for (int i = 0; i < labels.length; i++) {
                if (btn.getText().equals(labels[i])) { selectedIndex[0] = i; break; }
            }
        };

        int y = 20;
        for (String label : labels) {
            JButton b = new JButton(label);
            b.setBounds((520 - 400) / 2, y, 400, 30);
            b.addActionListener(pick);
            panel.add(b);
            y += 40;
        }

        JButton ok = new JButton("OK");
        ok.setBounds((520 - 120) / 4, 20 + labels.length * 40, 120, 40);
        ok.addActionListener(e -> frame.dispose());
        panel.add(ok);

        JButton cancel = new JButton("Cancel");
        cancel.setBounds((520 - 120) / 4 * 3, 20 + labels.length * 40, 120, 40);
        cancel.addActionListener(e -> {
            if (selectedIndex[0] == -1) {
                JOptionPane.showMessageDialog(frame, "Please choose an appointment.");
                return;
            }
            String apptId = rows.get(selectedIndex[0])[0];
            try (java.sql.Connection con = database.Database.connect();
                 java.sql.PreparedStatement ps = con.prepareStatement(
                     "DELETE a FROM appointments a " +
                     "JOIN users d ON d.id = a.dentist_id " +
                     "WHERE a.id = ? AND d.username = ?")) {
                ps.setLong(1, Long.parseLong(apptId));
                ps.setString(2, loggedInUsername);
                int n = ps.executeUpdate();
                JOptionPane.showMessageDialog(frame, n > 0 ? "Appointment Canceled." : "Nothing Canceled.");
                frame.dispose();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Delete failed: " + ex.getMessage());
            }
        });
        panel.add(cancel);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private static boolean isDentist(String username) {
        try (Connection con = database.Database.connect();
             PreparedStatement ps = con.prepareStatement(
                 "SELECT role FROM users WHERE username=?")) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return "DENTIST".equalsIgnoreCase(rs.getString("role"));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false; // default: not dentist
    }
    
 // put it here ↓

    private static void openAddAppointmentForDentist(JFrame parent) {
        JFrame frame = new JFrame("Add appointment");
        frame.setBounds(parent.getX() + 40, parent.getY() + 40, 520, 420);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        // ---- Top row: Date field + "..." + "Ok" ----
        JTextField apmDate = new JTextField();
        JButton chooseDate = new JButton("...");
        JButton okBtn = new JButton("Ok");
        apmDate.setBounds(20, 20, 330, 30);
        chooseDate.setBounds(360, 20, 40, 30);
        okBtn.setBounds(410, 20, 90, 30);
        panel.add(apmDate);
        panel.add(chooseDate);
        panel.add(okBtn);

        // ---- Patient dropdown ----
        JLabel patientLbl = new JLabel("Patient:");
        patientLbl.setBounds(20, 55, 100, 25);
        panel.add(patientLbl);

        JComboBox<String> patientDropdown = new JComboBox<>();
        patientDropdown.setBounds(120, 55, 200, 25);
        panel.add(patientDropdown);

        // Load all patients from DB
        try (Connection con = database.Database.connect();
             PreparedStatement ps = con.prepareStatement(
                 "SELECT name FROM users WHERE role='PATIENT' ORDER BY name")) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    patientDropdown.addItem(rs.getString("name"));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            patientDropdown.addItem("(error loading)");
        }

        // ---- Time buttons ----
        String[] times = {"09:00", "10:00", "11:00", "14:00", "15:00", "16:00"};
        JButton[] timeButtons = new JButton[times.length];
        int[][] positions = {
            {20, 100}, {190, 100}, {360, 100},
            {20, 160}, {190, 160}, {360, 160}
        };
        final String[] selectedTime = {null};
        for (int i = 0; i < times.length; i++) {
            JButton btn = new JButton(times[i]);
            btn.setBounds(positions[i][0], positions[i][1], 150, 40);
            btn.addActionListener(e -> {
                for (JButton b : timeButtons) if (b != null) b.setEnabled(true);
                btn.setEnabled(false);
                selectedTime[0] = btn.getText();
            });
            timeButtons[i] = btn;
            panel.add(btn);
        }

        // ---- Choose date dialog ----
        chooseDate.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(frame, "Enter date (YYYY-MM-DD):", LocalDate.now().toString());
            if (input == null) return;
            try {
                LocalDate.parse(input);
                apmDate.setText(input);
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid date format.");
            }
        });

        // ---- Ok button to save appointment ----
        okBtn.addActionListener(e -> {
            String date = apmDate.getText().trim();
            if (date.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Pick a date");
                return;
            }
            String patientName = (String) patientDropdown.getSelectedItem();
            if (patientName == null || patientName.isBlank()) {
                JOptionPane.showMessageDialog(frame, "Pick a patient");
                return;
            }
            if (selectedTime[0] == null) {
                JOptionPane.showMessageDialog(frame, "Pick a time");
                return;
            }

            try (Connection con = database.Database.connect();
                 PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO appointments (patient_id, dentist_id, start_time, end_time, status) " +
                     "VALUES ((SELECT id FROM users WHERE name=?), (SELECT id FROM users WHERE username=?), ?, ?, 'BOOKED')")) {

                int h = Integer.parseInt(selectedTime[0].substring(0, 2));
                LocalDate d = LocalDate.parse(date);
                java.time.LocalDateTime start = d.atTime(h, 0);
                java.time.LocalDateTime end = start.plusHours(1);

                ps.setString(1, patientName);
                ps.setString(2, loggedInUsername); // dentist's username
                ps.setTimestamp(3, java.sql.Timestamp.valueOf(start));
                ps.setTimestamp(4, java.sql.Timestamp.valueOf(end));
                ps.executeUpdate();

                JOptionPane.showMessageDialog(frame, "Booked " + start.toString().replace('T', ' '));
                frame.dispose();
            } catch (java.sql.SQLIntegrityConstraintViolationException ex) {
                JOptionPane.showMessageDialog(frame, "Slot already taken.");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        // ---- Back button ----
        JButton back = new JButton("Go back");
        back.setBounds((520 - 120) / 2, 300, 120, 40);
        back.addActionListener(e -> frame.dispose());
        panel.add(back);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }



    
    



}

