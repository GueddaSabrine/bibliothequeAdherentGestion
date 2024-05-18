package org.example.model;

import java.util.Objects;

/**
 * Classe représentant une catégorie de livre avec des informations sur son identifiant et son libellé.
 */
public class Categorie {
    private int id;
    private String libelle;

    /**
     * Constructeur avec paramètres pour créer une catégorie.
     *
     * @param id l'identifiant de la catégorie
     * @param libelle le libellé de la catégorie
     */
    public Categorie(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    /**
     * Obtient l'identifiant de la catégorie.
     *
     * @return l'identifiant de la catégorie
     */
    public int getId() {
        return id;
    }

    /**
     * Définit l'identifiant de la catégorie.
     *
     * @param id l'identifiant de la catégorie
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtient le libellé de la catégorie.
     *
     * @return le libellé de la catégorie
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Définit le libellé de la catégorie.
     *
     * @param libelle le libellé de la catégorie
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    /**
     * Vérifie si deux objets Categorie sont égaux en comparant leurs libellés.
     *
     * @param obj l'objet à comparer
     * @return true si les objets sont égaux, false sinon
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Categorie categorie = (Categorie) obj;
        return Objects.equals(libelle, categorie.libelle);
    }

    /**
     * Affiche le libellé de la catégorie.
     */
    public void afficherLibelle() {
        System.out.println("Libellé de la catégorie : " + libelle);
    }

    /**
     * Valide le libellé de la catégorie en vérifiant s'il appartient à une liste de libellés valides.
     *
     * @return true si le libellé est valide, false sinon
     */
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
