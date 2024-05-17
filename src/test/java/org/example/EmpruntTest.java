package org.example;

import org.example.model.Adherent;
import org.example.model.Categorie;
import org.example.model.Emprunt;
import org.example.model.Livre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EmpruntTest {

    private Emprunt emprunt;
    private Livre livre;
    private Adherent adherent;

    @BeforeEach
    public void setUp() {
        livre = new Livre(1, "9781234567890", "Livre 1", "Auteur 1", Livre.EtatLivre.DISPONIBLE, new Categorie(1, "Roman"));
        adherent = new Adherent(1, "Doe", "John", "Ville", "001");
        emprunt = new Emprunt(1, null, null, livre, adherent);
    }

    @Test
    public void testGetters() {
        assertEquals(1, emprunt.getId());
        assertNull(emprunt.getDateRetour());
        assertNull(emprunt.getDateEmprunt());
        assertEquals(livre, emprunt.getLivre());
        assertEquals(adherent, emprunt.getAdherent());
    }

    @Test
    public void testSetters() {
        emprunt.setId(2);
        assertEquals(2, emprunt.getId());

        Date dateRetour = new Date();
        emprunt.setDateRetour(dateRetour);
        assertEquals(dateRetour, emprunt.getDateRetour());

        Date dateEmprunt = new Date();
        emprunt.setDateEmprunt(dateEmprunt);
        assertEquals(dateEmprunt, emprunt.getDateEmprunt());

        Livre livre2 = new Livre(2, "9780987654321", "Livre 2", "Auteur 2", Livre.EtatLivre.DISPONIBLE, new Categorie(2, "Dictionnaire"));
        emprunt.setLivre(livre2);
        assertEquals(livre2, emprunt.getLivre());

        Adherent adherent2 = new Adherent(2, "Smith", "Jane", "Autre Ville", "002");
        emprunt.setAdherent(adherent2);
        assertEquals(adherent2, emprunt.getAdherent());
    }

    @Test
    public void testEnregistrerEmprunt() {
        emprunt.enregistrerEmprunt();
        assertNotNull(emprunt.getDateEmprunt());
    }

    @Test
    public void testEnregistrerRetour_LivreNonEmprunte() {
        emprunt.setDateEmprunt(null); // Simule un livre non emprunté
        emprunt.enregistrerRetour();
        assertNull(emprunt.getDateRetour());
    }

    @Test
    public void testEnregistrerRetour_LivreEmprunte() {
        Date dateEmprunt = new Date();
        emprunt.setDateEmprunt(dateEmprunt);
        emprunt.enregistrerRetour();
        assertNotNull(emprunt.getDateRetour());
    }


}