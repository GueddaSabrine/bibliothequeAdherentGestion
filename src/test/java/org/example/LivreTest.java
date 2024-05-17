package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LivreTest {

    @Test
    public void testAjouterLivre() {
        Categorie categorie = new Categorie(1, "Roman");
        Livre livre = Livre.ajouterLivre(1, "9781234567890", "Test Livre", "Test Auteur", Livre.EtatLivre.DISPONIBLE, categorie);

        assertNotNull(livre);
        assertEquals(1, livre.getId());
        assertEquals("9781234567890", livre.getIsbn());
        assertEquals("Test Livre", livre.getTitre());
        assertEquals("Test Auteur", livre.getAuteur());
        assertEquals(Livre.EtatLivre.DISPONIBLE, livre.getEtatLivre());
        assertEquals(categorie, livre.getCategorie());
    }

    @Test
    public void testModifierLivre() {
        Livre livre = new Livre(1, "9781234567890", "Test Livre", "Test Auteur", Livre.EtatLivre.DISPONIBLE, new Categorie(1, "Roman"));
        livre.modifierLivre("1234567890123", "Nouveau Titre", "Nouvel Auteur", Livre.EtatLivre.EMPRUNTE);

        assertEquals("1234567890123", livre.getIsbn());
        assertEquals("Nouveau Titre", livre.getTitre());
        assertEquals("Nouvel Auteur", livre.getAuteur());
        assertEquals(Livre.EtatLivre.EMPRUNTE, livre.getEtatLivre());
    }

    @Test
    public void testEstDisponible() {
        Livre livreDisponible = new Livre(1, "9781234567890", "Test Livre", "Test Auteur", Livre.EtatLivre.DISPONIBLE, new Categorie(1, "Roman"));
        Livre livreEmprunte = new Livre(2, "1234567890123", "Test Livre 2", "Test Auteur 2", Livre.EtatLivre.EMPRUNTE, new Categorie(2, "Thriller"));

        assertTrue(livreDisponible.estDisponible());
        assertFalse(livreEmprunte.estDisponible());
    }

}