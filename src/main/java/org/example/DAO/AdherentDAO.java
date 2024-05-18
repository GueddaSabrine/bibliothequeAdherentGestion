package org.example.DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.example.model.Adherent;

/**
 * Classe AdherentDAO permettant d'interagir avec la base de données SQLite pour les opérations CRUD sur les adhérents.
 */
public class AdherentDAO {

    /**
     * Obtient une connexion à la base de données.
     *
     * @return une connexion à la base de données
     * @throws SQLException si une erreur survient lors de la connexion
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }

    /**
     * Méthode pour tester la connexion à la base de données.
     */
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

    /**
     * URL de la base de données.
     */
    public static String url;

    /**
     * Constructeur de la classe AdherentDAO. Initialise la connexion à la base de données et crée la table des adhérents si elle n'existe pas.
     */
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

    /**
     * Crée un nouvel adhérent dans la base de données.
     *
     * @param adherent l'adhérent à créer
     */
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

    /**
     * Récupère un adhérent à partir de son identifiant.
     *
     * @param id l'identifiant de l'adhérent
     * @return l'adhérent correspondant à l'identifiant ou null s'il n'est pas trouvé
     */
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

    /**
     * Récupère tous les adhérents de la base de données.
     *
     * @return une liste de tous les adhérents
     */
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

    /**
     * Met à jour les informations d'un adhérent dans la base de données.
     *
     * @param adherent l'adhérent à mettre à jour
     */
    public void updateAdherent(Adherent adherent) {
        String sql = "UPDATE adherent SET nom = ?, prenom = ?, ville = ?, codeAdherent = ? WHERE ID = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, adherent.getNom());
            stmt.setString(2, adherent.getPrenom());
            stmt.setString(3, adherent.getVille());
            stmt.setString(4, adherent.getCodeAdherent());
            stmt.setInt(5, adherent.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Supprime un adhérent de la base de données.
     *
     * @param id l'identifiant de l'adhérent à supprimer
     */
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
