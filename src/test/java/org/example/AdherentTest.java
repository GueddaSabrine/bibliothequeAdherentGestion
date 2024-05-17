package org.example;

import org.example.model.Adherent;
import org.example.model.Categorie;
import org.example.model.Livre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdherentTest {

    private Adherent adherent;
    private List<Livre> listeLivres;

    @BeforeEach
    public void setUp() {
        adherent = new Adherent(1, "Doe", "John", "Ville", "001");
        listeLivres = new ArrayList<>();
    }

    @Test
    public void testEnregistrerEmprunt() {
        Livre livre = new Livre(1, "9781234567890", "Livre 1", "Auteur 1", Livre.EtatLivre.DISPONIBLE, new Categorie(1, "Roman"));
        adherent.enregistrerEmprunt(livre);
        // Vérifier la sortie console ou vérifier le logiciel de gestion des emprunts si disponible
        // C'est difficile à tester directement dans un test unitaire sans modifier la méthode enregistrerEmprunt()
    }

    @Test
    public void testRechercherLivre_LivreTrouve() {
        Livre livre = new Livre(1, "9781234567890", "Livre 1", "Auteur 1", Livre.EtatLivre.DISPONIBLE, new Categorie(1, "Roman"));
        listeLivres.add(livre);
        Livre livreTrouve = adherent.rechercherLivre(listeLivres, "Livre 1");
        assertEquals("Livre 1", livreTrouve.getTitre());
    }

    @Test
    public void testRechercherLivre_LivreNonTrouve() {
        Livre livre = new Livre(1, "9781234567890", "Livre 1", "Auteur 1", Livre.EtatLivre.DISPONIBLE, new Categorie(1, "Roman"));
        listeLivres.add(livre);
        Livre livreNonTrouve = adherent.rechercherLivre(listeLivres, "Livre Inexistant");
        assertNull(livreNonTrouve);
    }

}