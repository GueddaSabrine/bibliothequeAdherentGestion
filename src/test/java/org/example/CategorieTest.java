package org.example;

import org.example.model.Categorie;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CategorieTest {

    @Test
    public void testGettersAndSetters() {
        // Création d'une instance de Categorie
        Categorie categorie = new Categorie(1, "Roman");

        // Test des getters
        assertEquals(1, categorie.getId());
        assertEquals("Roman", categorie.getLibelle());

        // Modification des valeurs via les setters
        categorie.setId(2);
        categorie.setLibelle("Dictionnaire");

        // Vérification des modifications
        assertEquals(2, categorie.getId());
        assertEquals("Dictionnaire", categorie.getLibelle());
    }

    @Test
    public void testEquals() {
        // Création de deux instances de Categorie avec le même libelle
        Categorie categorie1 = new Categorie(1, "Roman");
        Categorie categorie2 = new Categorie(2, "Roman");

        // Les instances sont égales car elles ont le même libelle
        assertTrue(categorie1.equals(categorie2));

        // Modification du libelle de la deuxième catégorie
        categorie2.setLibelle("Nouvelle");

        // Maintenant, les instances ne sont plus égales
        assertFalse(categorie1.equals(categorie2));
    }

}