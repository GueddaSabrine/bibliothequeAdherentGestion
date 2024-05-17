package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LivreTest {

    private Livre livre;
    private static int testCounter;
    private List<Livre> listeLivres;

    @BeforeEach
    public void setUp() {
//        System.out.println("Initialisation avant chaque test");
        // Création d'une liste de livres avec des données fictives
        listeLivres = new ArrayList<>();
        listeLivres.add(new Livre(101, "FAKE-ISBN-001", "Livre 1", "Auteur 1", Livre.EtatLivre.DISPONIBLE, null));
        listeLivres.add(new Livre(102, "FAKE-ISBN-002", "Livre 2", "Auteur 2", Livre.EtatLivre.EMPRUNTE, null));
        listeLivres.add(new Livre(103, "FAKE-ISBN-003", "Livre 3", "Auteur 3", Livre.EtatLivre.PERDU, null));
        // Initialisation d'un livre spécifique pour le test testModifierLivre()
        livre = listeLivres.get(0); // Sélectionnez le premier livre de la liste
        testCounter++;
    }

    @Test
    public void testEtatLivre_LivreNull() {
        Livre livre = new Livre(101, "FAKE-ISBN-001", "Livre 1", "Auteur 1", null, null);
        assertFalse(livre.etatLivre());
    }

    @Test
    public void testEtatLivre_LivreDisponible() {
        Livre livre = listeLivres.get(0); // Sélectionne le premier livre de la liste fictive
        assertTrue(livre.etatLivre());
    }

    @Test
    public void testEtatLivre_LivreNonDisponible() {
        Livre livre = listeLivres.get(2); // Sélectionne le troisième livre de la liste fictive
        assertFalse(livre.etatLivre());
    }

    @Test
    public void testEtatLivre() {
        Livre livre = new Livre(101, "FAKE-ISBN-001", "Livre 1", "Auteur 1", Livre.EtatLivre.EMPRUNTE, null);

        System.out.println("Vérification de l'état initial du livre...");
        // Vérifie si l'état initial du livre est EMPRUNTE
        assertEquals(Livre.EtatLivre.EMPRUNTE, livre.getEtatLivre(), "L'état initial du livre devrait être EMPRUNTE");

        System.out.println("Rendre le livre disponible...");
        // Change l'état du livre en DISPONIBLE
        livre.setEtatLivre(Livre.EtatLivre.DISPONIBLE);

        System.out.println("Vérification de l'état du livre après avoir été rendu disponible...");
        // Vérifie si l'état du livre est devenu DISPONIBLE
        assertEquals(Livre.EtatLivre.DISPONIBLE, livre.getEtatLivre(), "L'état du livre devrait être DISPONIBLE après avoir été rendu disponible");
    }

    @Test
    public void testEtatActuelLivre() {
        // Création d'un livre avec un état initial
        Livre livre = new Livre(101, "FAKE-ISBN-001", "Livre 1", "Auteur 1", Livre.EtatLivre.DISPONIBLE, null);

        // Vérification de l'état actuel du livre
        assertEquals(Livre.EtatLivre.DISPONIBLE, livre.getEtatLivre(), "L'état actuel du livre devrait être DISPONIBLE");
    }

    @Test
    public void testAjouterLivre() {
        Livre nouveauLivre = Livre.ajouterLivre(200, "FAKE-ISBN-222", "Autre Titre Fictif", "Autre Auteur Fictif", Livre.EtatLivre.PERDU, null);
        assertEquals(200, nouveauLivre.getId());
        assertEquals("FAKE-ISBN-222", nouveauLivre.getIsbn());
        assertEquals("Autre Titre Fictif", nouveauLivre.getTitre());
        assertEquals("Autre Auteur Fictif", nouveauLivre.getAuteur());
        assertEquals(Livre.EtatLivre.PERDU, nouveauLivre.getEtatLivre());
    }

    @Test
    public void testModifierLivre() {
        // Assurez-vous que "livre" est non nul avant d'appeler des méthodes sur elle
        assertNotNull(livre);

        livre.modifierLivre("FAKE-ISBN-456", "Nouveau Titre Fictif", "Nouvel Auteur Fictif", Livre.EtatLivre.EMPRUNTE);
        assertEquals("FAKE-ISBN-456", livre.getIsbn());
        assertEquals("Nouveau Titre Fictif", livre.getTitre());
        assertEquals("Nouvel Auteur Fictif", livre.getAuteur());
        assertEquals(Livre.EtatLivre.EMPRUNTE, livre.getEtatLivre());
    }

    @Test
    public void testAfficherListeLivres() {
        System.out.println("Affichage de la liste de livres : ");
        for (Livre livre : listeLivres) {
            livre.afficherLivre();
            System.out.println(); // Ajout d'une ligne vide pour séparer les livres affichés
        }
    }

}