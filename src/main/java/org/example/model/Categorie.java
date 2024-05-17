package org.example.model;

import java.util.Objects;

public class Categorie {
    private int id;
    private String libelle;

    /**
     *
     * @param id
     * @param libelle
     */
    public Categorie(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Categorie categorie = (Categorie) obj;
        return Objects.equals(libelle, categorie.libelle);
    }

    /**
     *
     */
    // Méthode pour afficher le libellé
    public void afficherLibelle() {
        System.out.println("Libellé de la catégorie : " + libelle);
    }

    /**
     *
     * @return
     */
    // Méthode pour valider le libellé d'une catégorie
    public boolean estLibelleValide() {
        String[] categoriesValides = {"dictionnaire", "roman", "nouvelle", "poème"};
        for (String categorieValide : categoriesValides) {
            if (categorieValide.equalsIgnoreCase(libelle)) {
                return true;
            }
        }
        return false;
    }
}