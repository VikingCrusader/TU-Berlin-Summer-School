package logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import database.Database;

public class DentistCreator {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try (Connection con = Database.connect()) {

            System.out.print("Name: ");
            String name = in.nextLine().trim();

            String username;
            while (true) {
                System.out.print("Username: ");
                username = in.nextLine().trim();

                // check if username already exists
                try (PreparedStatement check = con.prepareStatement(
                        "SELECT 1 FROM users WHERE username=?")) {
                    check.setString(1, username);
                    try (ResultSet rs = check.executeQuery()) {
                        if (rs.next()) {
                            System.out.println("⚠ Username already exists, try another.");
                        } else {
                            break; // good to go
                        }
                    }
                }
            }

            System.out.print("Password: ");
            String plainPassword = in.nextLine();

            System.out.print("Email: ");
            String email = in.nextLine().trim();

            System.out.print("Phone: ");
            String phone = in.nextLine().trim();

            System.out.print("Address: ");
            String address = in.nextLine().trim();

            System.out.print("Dentist code: ");
            String code = in.nextLine().trim();

            // make salt + hash
            String salt = PasswordAuth.newSaltB64();
            String hash = PasswordAuth.hash(plainPassword, salt);

            // insert into DB
            try {
                con.setAutoCommit(false);

                // 1) insert dentist into users
                try (PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO users (name, username, password_hash, password_salt, email, phone, address, role) " +
                                "VALUES (?, ?, ?, ?, ?, ?, ?, 'DENTIST')")) {
                    ps.setString(1, name);
                    ps.setString(2, username);
                    ps.setString(3, hash);
                    ps.setString(4, salt);
                    ps.setString(5, email);
                    ps.setString(6, phone);
                    ps.setString(7, address);
                    ps.executeUpdate();
                }

                // 2) link to dentists table with code
                try (PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO dentists (id, code) " +
                                "SELECT id, ? FROM users WHERE username=?")) {
                    ps.setString(1, code);
                    ps.setString(2, username);
                    ps.executeUpdate();
                }

                con.commit();
                System.out.println("Dentist added: " + name + " (" + username + ")");
            } catch (Exception dbEx) {
                con.rollback();
                dbEx.printStackTrace();
                System.out.println("Failed to add dentist.");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            in.close();
        }
    }
}
