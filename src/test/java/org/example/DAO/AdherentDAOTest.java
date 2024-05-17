package org.example.DAO;

import org.example.model.Adherent;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.example.DAO.AdherentDAO.url;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AdherentDAOTest {

    private AdherentDAO adherentDAO;

    @BeforeAll
    public void setup() {
        adherentDAO = new AdherentDAO();
        url = "jdbc:sqlite::memory:";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            String createTableSQL = "CREATE TABLE adherent (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nom TEXT NOT NULL," +
                    "prenom TEXT NOT NULL," +
                    "ville TEXT NOT NULL," +
                    "codeAdherent TEXT NOT NULL)";
            stmt.execute(createTableSQL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConnection() {
        try (Connection conn = DriverManager.getConnection(url)) {
            assertNotNull(conn, "Connection should not be null");
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Failed to establish connection: " + e.getMessage());
        }
    }

    @BeforeEach
    public void clearDatabase() {
        try (Connection conn = adherentDAO.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute("DELETE FROM adherent");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreateAdherent() {
        Adherent adherent = new Adherent(5, "Doe", "John", "Paris", "12345");
        adherentDAO.createAdherent(adherent);

        assertNotNull(adherent.getId());
    }

    @Test
    public void testDeleteAdherent() {
        Adherent adherent = new Adherent(7, "Doe", "John", "Paris", "12345");
        adherentDAO.createAdherent(adherent);

        adherentDAO.deleteAdherent(adherent.getId());

        Adherent deletedAdherent = adherentDAO.getAdherentById(adherent.getId());
        assertNull(deletedAdherent);
    }

}