package org.example.model;

import org.apache.http.annotation.Contract;

import java.util.List;

public class Adherent {
    private int id;
    private String nom;
    private String prenom;
    private String ville;
    private String codeAdherent;


    public Adherent(int id, String nom, String prenom, String ville, String codeAdherent) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville;
        this.codeAdherent = codeAdherent;
    }

    public Adherent() {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville;
        this.codeAdherent = codeAdherent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodeAdherent() {
        return codeAdherent;
    }
    public void setCodeAdherent(String codeAdherent) {
        this.codeAdherent = codeAdherent;
    }

    /**
     *
     * @param livre
     */
    // Méthode pour enregistrer un emprunt
    public void enregistrerEmprunt(Livre livre) {
        // Code pour enregistrer l'emprunt dans une liste d'emprunts de l'adhérent
        System.out.println("L'adhérent " + this.nom + " " + this.prenom + " (Code : " + this.codeAdherent + ") a emprunté le livre : " + livre.getTitre());
    }

    /**
     *
     * @param listeLivres
     * @param titre
     * @return
     */
    // Méthode pour rechercher un livre
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
