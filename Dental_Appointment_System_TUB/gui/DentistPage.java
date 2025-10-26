package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class DentistPage {

    // we remember who is logged in (the dentist)
    private static String dentistUsername;

    // ========= entry point for this page =========
    public static void start(String username) {
        dentistUsername = username;

        // main window
        JFrame frame = new JFrame("Dentist – " + username);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // simple vertical menu with 3 buttons
        JPanel root = new JPanel();
        root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));
        root.setBorder(BorderFactory.createEmptyBorder(24, 24, 24, 24));
        frame.setContentPane(root);

        JButton btnMyAppts = new JButton("Booked appointments");
        JButton btnAddAppt = new JButton("Add appointment for a patient");
        JButton btnLogout  = new JButton("Logout");

        Dimension bigBtn = new Dimension(360, 48);
        btnMyAppts.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnAddAppt.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnLogout.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnMyAppts.setMaximumSize(bigBtn);
        btnAddAppt.setMaximumSize(bigBtn);
        btnLogout.setMaximumSize(bigBtn);

        root.add(Box.createVerticalStrut(12));
        root.add(btnMyAppts);
        root.add(Box.createVerticalStrut(18));
        root.add(btnAddAppt);
        root.add(Box.createVerticalStrut(18));
        root.add(btnLogout);
        root.add(Box.createVerticalStrut(12));

        // button actions (kept very explicit)
        btnMyAppts.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                openMyAppointments(frame);
            }
        });

        btnAddAppt.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                openAddForPatient(frame);
            }
        });

        btnLogout.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                frame.dispose();
                WelcomePage.WelcomePageGUI();
            }
        });

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // ========= 3.1 See all appointments booked with me (as dentist) =========
    private static void openMyAppointments(JFrame parent) {
        // rows will hold small arrays: { id, labelForButton }
        List<String[]> rows = new ArrayList<>();

        // load from DB
        try (Connection con = database.Database.connect();
             PreparedStatement ps = con.prepareStatement(
                 "SELECT a.id, a.start_time, a.end_time, p.name AS patient " +
                 "FROM appointments a " +
                 "JOIN users d ON d.id = a.dentist_id " +
                 "JOIN users p ON p.id = a.patient_id " +
                 "WHERE d.username = ? " +
                 "ORDER BY a.start_time"
             )) {

            ps.setString(1, dentistUsername);

            try (ResultSet rs = ps.executeQuery()) {
                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                while (rs.next()) {
                    String id      = String.valueOf(rs.getLong("id"));
                    String start   = rs.getTimestamp("start_time").toLocalDateTime().format(fmt);
                    String end     = rs.getTimestamp("end_time").toLocalDateTime().format(fmt);
                    String patient = rs.getString("patient");
                    String label   = start + " → " + end + "   with " + patient;
                    rows.add(new String[] { id, label });
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(parent, "Load failed: " + ex.getMessage());
            return;
        }

        if (rows.isEmpty()) {
            JOptionPane.showMessageDialog(parent, "No appointments.");
            return;
        }

        // make the window
        JFrame frame = new JFrame("My appointments");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel root = new JPanel();
        root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));
        root.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));
        frame.setContentPane(root);

        // where we remember which index is selected
        final int[] selectedIndex = new int[] { -1 };

        // create one button per appointment
        for (int i = 0; i < rows.size(); i++) {
            String label = rows.get(i)[1];
            JButton b = new JButton(label);
            b.setAlignmentX(Component.CENTER_ALIGNMENT);
            b.setMaximumSize(new Dimension(460, 32));

            final int idx = i; // capture
            b.addActionListener(new ActionListener() {
                @Override public void actionPerformed(ActionEvent e) {
                    // re-enable all buttons
                    for (Component c : root.getComponents()) {
                        if (c instanceof JButton) {
                            c.setEnabled(true);
                        }
                    }
                    // disable the one we clicked and remember its index
                    b.setEnabled(false);
                    selectedIndex[0] = idx;
                }
            });

            root.add(b);
            root.add(Box.createVerticalStrut(8));
        }

        // cancel button
        JButton cancel = new JButton("Cancel selected");
        cancel.setAlignmentX(Component.CENTER_ALIGNMENT);
        cancel.setMaximumSize(new Dimension(200, 40));
        cancel.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                if (selectedIndex[0] == -1) {
                    JOptionPane.showMessageDialog(frame, "Pick an appointment.");
                    return;
                }
                String apptId = rows.get(selectedIndex[0])[0];

                try (Connection con = database.Database.connect();
                     PreparedStatement ps = con.prepareStatement(
                         "DELETE a FROM appointments a " +
                         "JOIN users d ON d.id = a.dentist_id " +
                         "WHERE a.id = ? AND d.username = ?"
                     )) {
                    ps.setLong(1, Long.parseLong(apptId));
                    ps.setString(2, dentistUsername);
                    int n = ps.executeUpdate();
                    JOptionPane.showMessageDialog(frame, n > 0 ? "Canceled." : "Nothing deleted.");
                    frame.dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Delete failed: " + ex.getMessage());
                }
            }
        });

        root.add(Box.createVerticalStrut(10));
        root.add(cancel);

        frame.pack();
        frame.setLocationRelativeTo(parent);
        frame.setVisible(true);
    }

    // ========= 3.2 Add appointment for a PATIENT (dentist chooses patient) =========
    private static void openAddForPatient(JFrame parent) {
        JFrame frame = new JFrame("Calendar");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);

        // we use GridBagLayout but step-by-step and simple
        JPanel root = new JPanel(new GridBagLayout());
        root.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(8, 8, 8, 8);
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 1;
        gc.fill = GridBagConstraints.HORIZONTAL;

        // row 0: date field, ... button, Ok button
        JTextField dateField = new JTextField();        // type here: YYYY-MM-DD
        JButton btnBrowse = new JButton("...");
        JButton btnOk = new JButton("Ok");

        root.add(dateField, gc);                        // column 0

        gc.gridx = 1;
        gc.weightx = 0;
        gc.fill = GridBagConstraints.NONE;
        root.add(btnBrowse, gc);                        // column 1

        gc.gridx = 2;
        root.add(btnOk, gc);                            // column 2

        // row 1: "Patient:" label + combo box
        gc.gridy = 1;
        gc.gridx = 0;
        gc.gridwidth = 1;
        gc.anchor = GridBagConstraints.WEST;
        JLabel patientLabel = new JLabel("Patient:");
        root.add(patientLabel, gc);

        gc.gridx = 1;
        gc.gridwidth = 2;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.weightx = 1;
        JComboBox<String> patientBox = new JComboBox<>();
        root.add(patientBox, gc);

        // load patients (role = PATIENT) by name
        try (Connection con = database.Database.connect();
             PreparedStatement ps = con.prepareStatement(
                 "SELECT name FROM users WHERE role='PATIENT' ORDER BY name")) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    patientBox.addItem(name);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            patientBox.addItem("(failed)");
        }

        // row 2: 2x3 grid with time buttons
        gc.gridy = 2;
        gc.gridx = 0;
        gc.gridwidth = 3;
        gc.weightx = 1;
        gc.fill = GridBagConstraints.HORIZONTAL;

        JPanel timesPanel = new JPanel(new GridLayout(2, 3, 24, 24));
        String[] times = new String[] { "09:00", "10:00", "11:00", "14:00", "15:00", "16:00" };
        JButton[] timeButtons = new JButton[times.length];
        final String[] pickedTime = new String[] { null };

        for (int i = 0; i < times.length; i++) {
            String caption = times[i];
            JButton b = new JButton(caption);
            timeButtons[i] = b;

            b.addActionListener(new ActionListener() {
                @Override public void actionPerformed(ActionEvent e) {
                    // enable all buttons first
                    for (int j = 0; j < timeButtons.length; j++) {
                        if (timeButtons[j] != null) {
                            timeButtons[j].setEnabled(true);
                        }
                    }
                    // disable the one we clicked and remember its text
                    b.setEnabled(false);
                    pickedTime[0] = b.getText();
                }
            });

            timesPanel.add(b);
        }
        root.add(timesPanel, gc);

        // row 3: spacer (pushes "Go back" to the bottom)
        gc.gridy = 3;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.BOTH;
        root.add(Box.createVerticalGlue(), gc);

        // row 4: Go back button
        gc.gridy = 4;
        gc.weighty = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.CENTER;
        JButton btnBack = new JButton("Go back");
        root.add(btnBack, gc);

        // === small actions ===

        // date input helper (simple dialog, like your other pages)
        btnBrowse.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                String today = LocalDate.now().toString();
                String input = JOptionPane.showInputDialog(frame, "Enter date (YYYY-MM-DD):", today);
                if (input == null) return;
                try {
                    LocalDate.parse(input); // just to validate
                    dateField.setText(input);
                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid date format.");
                }
            }
        });

        // create the appointment
        btnOk.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                String patientName = (String) patientBox.getSelectedItem();
                String dateText = dateField.getText().trim();

                if (patientName == null || patientName.startsWith("(")) {
                    JOptionPane.showMessageDialog(frame, "Choose patient");
                    return;
                }
                if (dateText.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Enter date YYYY-MM-DD");
                    return;
                }
                if (pickedTime[0] == null) {
                    JOptionPane.showMessageDialog(frame, "Pick a time");
                    return;
                }

                // build start and end times
                int hour = Integer.parseInt(pickedTime[0].substring(0, 2));
                LocalDate date = LocalDate.parse(dateText);
                java.time.LocalDateTime start = date.atTime(hour, 0);
                java.time.LocalDateTime end   = start.plusHours(1);

                try (Connection con = database.Database.connect();
                     PreparedStatement ps = con.prepareStatement(
                         "INSERT INTO appointments (patient_id, dentist_id, start_time, end_time, status) " +
                         "VALUES ((SELECT id FROM users WHERE name=?), " +
                                 "        (SELECT id FROM users WHERE username=?), ?, ?, 'BOOKED')"
                     )) {
                    ps.setString(1, patientName);              // patient by NAME
                    ps.setString(2, dentistUsername);          // dentist by USERNAME (logged in)
                    ps.setTimestamp(3, Timestamp.valueOf(start));
                    ps.setTimestamp(4, Timestamp.valueOf(end));
                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(frame,
                        "Booked " + start.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
                    frame.dispose();
                } catch (SQLIntegrityConstraintViolationException ex) {
                    JOptionPane.showMessageDialog(frame, "Slot taken.");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                }
            }
        });

        // go back
        btnBack.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.setContentPane(root);
        frame.pack();
        frame.setLocationRelativeTo(parent);
        frame.setVisible(true);
    }
}
