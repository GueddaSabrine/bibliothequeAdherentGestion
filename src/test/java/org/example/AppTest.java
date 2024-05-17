package org.example;

import org.example.DAO.AdherentDAO;
import org.example.model.Adherent;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AppTest {
    private AdherentDAO adherentDAO;

    @BeforeAll
    public void setup() {
        adherentDAO = new AdherentDAO();

        // Utilisez une base de données en mémoire pour les tests
        AdherentDAO.url = "jdbc:sqlite::memory:";
        try (Connection conn = DriverManager.getConnection(AdherentDAO.url);
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
    public void testConnection() {
        try (Connection conn = adherentDAO.getConnection()) {
            assertNotNull(conn, "Connection should not be null");
            System.out.println("Connection to SQLite has been established.");
        } catch (Exception e) {
            fail("Failed to establish connection: " + e.getMessage());
        }
    }

}