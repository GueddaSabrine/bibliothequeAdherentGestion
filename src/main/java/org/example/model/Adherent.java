package org.example.model;

import java.util.List;

/**
 * Classe représentant un adhérent avec des informations personnelles et des méthodes pour gérer les emprunts de livres.
 */
public class Adherent {
    private int id;
    private String nom;
    private String prenom;
    private String ville;
    private String codeAdherent;

    /**
     * Constructeur avec paramètres pour créer un adhérent.
     *
     * @param id l'identifiant de l'adhérent
     * @param nom le nom de l'adhérent
     * @param prenom le prénom de l'adhérent
     * @param ville la ville de résidence de l'adhérent
     * @param codeAdherent le code unique de l'adhérent
     */
    public Adherent(int id, String nom, String prenom, String ville, String codeAdherent) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville;
        this.codeAdherent = codeAdherent;
    }

    /**
     * Constructeur par défaut pour créer un adhérent sans initialiser les attributs.
     */
    public Adherent() {
        // Initialisation par défaut
        this.id = 0;
        this.nom = "";
        this.prenom = "";
        this.ville = "";
        this.codeAdherent = "";
    }

    /**
     * Obtient l'identifiant de l'adhérent.
     *
     * @return l'identifiant de l'adhérent
     */
    public int getId() {
        return id;
    }

    /**
     * Définit l'identifiant de l'adhérent.
     *
     * @param id l'identifiant de l'adhérent
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtient le nom de l'adhérent.
     *
     * @return le nom de l'adhérent
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom de l'adhérent.
     *
     * @param nom le nom de l'adhérent
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtient le prénom de l'adhérent.
     *
     * @return le prénom de l'adhérent
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Définit le prénom de l'adhérent.
     *
     * @param prenom le prénom de l'adhérent
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Obtient la ville de résidence de l'adhérent.
     *
     * @return la ville de résidence de l'adhérent
     */
    public String getVille() {
        return ville;
    }

    /**
     * Définit la ville de résidence de l'adhérent.
     *
     * @param ville la ville de résidence de l'adhérent
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

    /**
     * Obtient le code unique de l'adhérent.
     *
     * @return le code unique de l'adhérent
     */
    public String getCodeAdherent() {
        return codeAdherent;
    }

    /**
     * Définit le code unique de l'adhérent.
     *
     * @param codeAdherent le code unique de l'adhérent
     */
    public void setCodeAdherent(String codeAdherent) {
        this.codeAdherent = codeAdherent;
    }

    /**
     * Enregistre un emprunt pour l'adhérent.
     *
     * @param livre le livre emprunté par l'adhérent
     */
    public void enregistrerEmprunt(Livre livre) {
        // Code pour enregistrer l'emprunt dans une liste d'emprunts de l'adhérent
        System.out.println("L'adhérent " + this.nom + " " + this.prenom + " (Code : " + this.codeAdherent + ") a emprunté le livre : " + livre.getTitre());
    }

    /**
     * Recherche un livre dans une liste de livres.
     *
     * @param listeLivres la liste des livres disponibles
     * @param titre le titre du livre à rechercher
     * @return le livre trouvé ou null si le livre n'est pas trouvé
     */
    public Livre rechercherLivre(List<Livre> listeLivres, String titre) {
        for (Livre livre : listeLivres) {
            if (livre.getTitre().equalsIgnoreCase(titre)) {
                System.out.println("Livre trouvé par l'adhérent (Code : " + this.codeAdherent + ")");
                return livre;
            }
        }
        System.out.println("Livre non trouvé par l'adhérent (Code : " + this.codeAdherent + ")");
        return null; // Retourne null si le livre n'est pas trouvé
    }
}
