package org.example;

public class Adherent {
    private int id;
    private String nom;
    private String prenom;
    private String ville;

    public Adherent(int id, String nom, String prenom, String ville) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville;
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

    // Méthode pour enregistrer un emprunt
    public void enregistrerEmprunt(Livre livre) {
        // Code pour enregistrer l'emprunt dans une liste d'emprunts de l'adhérent,
        System.out.println("L'adhérent " + this.nom + " " + this.prenom + " a emprunté le livre : " + livre.getTitre());
    }
}
