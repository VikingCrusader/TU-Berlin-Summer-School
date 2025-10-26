package logic;

import java.sql.*;
import java.util.Base64;
import java.security.SecureRandom;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import database.Database;

public class PasswordAuth {
    // small + simple defaults
    private static final int SALT_BYTES = 16;
    private static final int ITER = 50_000;
    private static final int KEY_BITS = 256;
    private static final SecureRandom RNG = new SecureRandom();

    public static String newSaltB64() {
        byte[] s = new byte[SALT_BYTES];
        RNG.nextBytes(s);
        return Base64.getEncoder().encodeToString(s);
    }

    public static String hash(String password, String saltB64) {
        try {
            byte[] salt = Base64.getDecoder().decode(saltB64);
            PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITER, KEY_BITS);
            byte[] out = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256")
                                         .generateSecret(spec).getEncoded();
            return Base64.getEncoder().encodeToString(out);
        } catch (Exception e) { throw new RuntimeException(e); }
    }

    // ---- PUBLIC: create user (stores hash + salt) ----
    public static void createUser(String name, String username, String plainPassword,
                                  String email, String phone, String address, String role) throws Exception {
        String salt = newSaltB64();
        String h = hash(plainPassword, salt);
        try (Connection con = Database.connect();
             PreparedStatement ps = con.prepareStatement(
                "INSERT INTO users (name, username, password_hash, password_salt, email, phone, address, role) " +
                "VALUES (?,?,?,?,?,?,?,?)")) {
            ps.setString(1, name);
            ps.setString(2, username);
            ps.setString(3, h);
            ps.setString(4, salt);
            ps.setString(5, email);
            ps.setString(6, phone);
            ps.setString(7, address);
            ps.setString(8, role);
            ps.executeUpdate();
        }
    }

    // ---- PUBLIC: check login (true/false) ----
    public static boolean checkLogin(String username, String plainPassword) {
        String dbHash = null, dbSalt = null;
        try (Connection con = Database.connect();
             PreparedStatement ps = con.prepareStatement(
                "SELECT password_hash, password_salt FROM users WHERE username=?")) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    dbHash = rs.getString(1);
                    dbSalt = rs.getString(2);
                } else {
                    return false;
                }
            }
        } catch (Exception e) { e.printStackTrace(); return false; }

        if (dbHash == null || dbSalt == null) return false;
        String tryHash = hash(plainPassword, dbSalt);
        return tryHash.equals(dbHash);
    }
}
