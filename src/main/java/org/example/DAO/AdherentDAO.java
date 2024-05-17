package org.example.DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.example.model.Adherent;

public class AdherentDAO {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }

    // Method to test the connection
    public static void testConnection() {
        try (Connection conn = getConnection()) {
            if (conn != null) {
                System.out.println("Connection to SQLite has been established.");
            } else {
                System.out.println("Failed to establish connection.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to establish connection: " + e.getMessage());
        }
    }
    public static String url;

    public AdherentDAO() {
        try {
            Properties properties = new Properties();
            properties.load(getClass().getClassLoader().getResourceAsStream("database.properties"));
            this.url = properties.getProperty("jdbc.url");

            try (Connection conn = getConnection();
                 Statement stmt = conn.createStatement()) {
                String createTableSQL = "CREATE TABLE IF NOT EXISTS adherent (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "nom TEXT NOT NULL," +
                        "prenom TEXT NOT NULL," +
                        "ville TEXT NOT NULL," +
                        "codeAdherent TEXT NOT NULL)";
                stmt.execute(createTableSQL);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createAdherent(Adherent adherent) {
        String sql = "INSERT INTO adherent (nom, prenom, ville, codeAdherent) VALUES (?,?,?,?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, adherent.getNom());
            stmt.setString(2, adherent.getPrenom());
            stmt.setString(3, adherent.getVille());
            stmt.setString(4, adherent.getCodeAdherent());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Adherent getAdherentById(int id) {
        String sql = "SELECT * FROM adherent WHERE ID = ?";
        Adherent adherent = null;
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                adherent = new Adherent();
                adherent.setId(rs.getInt("ID"));
                adherent.setNom(rs.getString("NOM"));
                adherent.setPrenom(rs.getString("PRENOM"));
                adherent.setVille(rs.getString("VILLE"));
                adherent.setCodeAdherent(rs.getString("codeAdherent"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adherent;
    }

    public List<Adherent> getAllAdherents() {
        String sql = "SELECT * FROM ADHERENT";
        List<Adherent> adherents = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Adherent adherent = new Adherent();
                adherent.setId(rs.getInt("ID"));
                adherent.setNom(rs.getString("NOM"));
                adherent.setPrenom(rs.getString("PRENOM"));
                adherent.setVille(rs.getString("VILLE"));
                adherent.setCodeAdherent(rs.getString("codeAdherent"));
                adherents.add(adherent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adherents;
    }

    public void updateAdherent(Adherent adherent) {
        String sql = "UPDATE adherent SET nom = ?, prenom = ?, codeAdherent = ? WHERE ID = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, adherent.getNom());
            stmt.setString(2, adherent.getPrenom());
            stmt.setString(3, adherent.getVille());
            stmt.setString(4, adherent.getCodeAdherent());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAdherent(int id) {
        String sql = "DELETE FROM adherent WHERE ID = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
