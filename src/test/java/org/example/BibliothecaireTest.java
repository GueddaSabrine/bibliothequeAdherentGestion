package org.example;

import org.example.model.Adherent;
import org.example.model.Bibliothecaire;
import org.example.model.Categorie;
import org.example.model.Livre;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BibliothecaireTest {

    private static Bibliothecaire bibliothecaire;
    private static List<Livre> listeLivres;

    @BeforeAll
    public static void setUp() {
        bibliothecaire = new Bibliothecaire(1, "Dupont", "Jean");
        listeLivres = new ArrayList<>();
    }

    @AfterAll
    public static void tearDown() {
        bibliothecaire = null;
        listeLivres = null;
    }

    @BeforeEach
    public void init() {
        // Ajouter des livres pour chaque test
        listeLivres.add(new Livre(1, "9781234567890", "Livre 1", "Auteur 1", Livre.EtatLivre.DISPONIBLE, new Categorie(1, "Roman")));
        listeLivres.add(new Livre(2, "9781234567891", "Livre 2", "Auteur 2", Livre.EtatLivre.EMPRUNTE, new Categorie(2, "Thriller")));
    }

    @AfterEach
    public void tearDownEach() {
        // Nettoyer la liste des livres après chaque test
        listeLivres.clear();
    }

    @Test
    public void testCreerAdherent() {
        Adherent nouvelAdherent = new Adherent(1, "Adherent", "Nouveau", "Ville", "001");
        Adherent adh = bibliothecaire.creerAdherent(nouvelAdherent);
        assertEquals(nouvelAdherent, adh);
    }

    @Test
    public void testModifierAdherent() {
        Adherent adherent = new Adherent(1, "Adherent", "Ancien", "Ville", "001");
        bibliothecaire.modifierAdherent(adherent, "Adherent", "Nouveau");
        assertEquals("Nouveau", adherent.getPrenom());
    }

    @Test
    public void testAjouterNouveauLivre() {
        Livre livre = new Livre(3, "9781234567892", "Nouveau Livre", "Auteur 3", Livre.EtatLivre.DISPONIBLE, new Categorie(1, "Roman"));
        bibliothecaire.ajouterNouveauLivre(listeLivres, livre);
        assertEquals(3, listeLivres.size());
    }

    @Test
    public void testModifierLivre() {
        Livre livre = new Livre(1, "9781234567890", "Livre 1", "Auteur 1", Livre.EtatLivre.DISPONIBLE, new Categorie(1, "Roman"));
        bibliothecaire.modifierLivre(livre, "1234567890123", "Nouveau Titre", "Nouvel Auteur", Livre.EtatLivre.PERDU);
        assertEquals("Nouveau Titre", livre.getTitre());
        assertEquals("Nouvel Auteur", livre.getAuteur());
        assertEquals(Livre.EtatLivre.PERDU, livre.getEtatLivre());
    }

    @Test
    public void testEnregistrerEmprunt() {
        Adherent adherent = new Adherent(1, "Adherent", "Nom", "Ville", "001");
        Livre livre = new Livre(1, "9781234567890", "Livre 1", "Auteur 1", Livre.EtatLivre.DISPONIBLE, new Categorie(1, "Roman"));
        adherent.enregistrerEmprunt(livre);
    }


}