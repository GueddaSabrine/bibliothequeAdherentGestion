package org.example;

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
    public void testAjouterNouveauLivre_CategorieValide() {
        Livre livre = new Livre(3, "9781234567892", "Nouveau Livre", "Auteur 3", Livre.EtatLivre.DISPONIBLE, new Categorie(1, "Roman"));
        bibliothecaire.ajouterNouveauLivre(listeLivres, livre);
        assertEquals(3, listeLivres.size());
        assertTrue(listeLivres.contains(livre));
        System.out.println("Test ajout nouveau livre avec catégorie valide réussi.");
    }

    @Test
    public void testAjouterNouveauLivre_CategorieNonValide() {
        Livre livre = new Livre(3, "9781234567892", "Nouveau Livre", "Auteur 3", Livre.EtatLivre.DISPONIBLE, new Categorie(0, ""));
        bibliothecaire.ajouterNouveauLivre(listeLivres, livre);
        assertEquals(2, listeLivres.size());
        System.out.println("Test ajout nouveau livre avec catégorie non valide réussi.");
    }

    @Test
    public void testModifierLivre() {
        Livre livre = new Livre(1, "9781234567890", "Livre 1", "Auteur 1", Livre.EtatLivre.DISPONIBLE, new Categorie(1, "Roman"));
        bibliothecaire.modifierLivre(livre, "1234567890123", "Nouveau Titre", "Nouvel Auteur", Livre.EtatLivre.PERDU);
        assertEquals("Nouveau Titre", livre.getTitre());
        assertEquals("Nouvel Auteur", livre.getAuteur());
        assertEquals(Livre.EtatLivre.PERDU, livre.getEtatLivre());
        System.out.println("Test modification livre réussi.");
    }

    @Test
    public void testCreerAdherent_InformationsCorrectes() {
        Adherent adherent = new Adherent(1, "Doe", "John", "Ville", "001");
        assertEquals(1, adherent.getId());
        assertEquals("Doe", adherent.getNom());
        assertEquals("John", adherent.getPrenom());
        assertEquals("Ville", adherent.getVille());
        assertEquals("001", adherent.getCodeAdherent());
        System.out.println("Test création adhérent avec informations correctes réussi.");
    }

    @Test
    public void testModifierAdherent() {
        Adherent adherent = new Adherent(1, "Doe", "John", "Ville", "001");
        bibliothecaire.modifierAdherent(adherent, "Smith", "Jane");
        assertEquals("Smith", adherent.getNom());
        assertEquals("Jane", adherent.getPrenom());
        System.out.println("Test modification adhérent réussi.");
    }

    @Test
    public void testEnregistrerEmprunt() {
        Adherent adherent = new Adherent(1, "Adherent", "Nom", "Ville", "001");
        Livre livre = new Livre(1, "9781234567890", "Livre 1", "Auteur 1", Livre.EtatLivre.DISPONIBLE, new Categorie(1, "Roman"));
        adherent.enregistrerEmprunt(livre);
        System.out.println("Test enregistrement emprunt réussi.");
    }

    @Test
    public void testCreerAdherent_InformationsManquantes() {
        // Création d'un adhérent avec une information manquante
        Adherent adherent = new Adherent(1, "Doe", "", "Ville", "001");
        assertNotNull(bibliothecaire.creerAdherent(adherent));
        System.out.println("Test création adhérent avec informations manquantes réussi.");
    }


}