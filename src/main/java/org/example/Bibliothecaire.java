package org.example;

import java.util.jar.Attributes;

public class Bibliothecaire {
    private int id;
    private String nom;
    private String prenom;

    public Bibliothecaire(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
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

    public Adherent creerAdherent(Adherent nouvelAdherent) {
        // Code pour enregistrer l'adhérent dans la base de données
        return nouvelAdherent;
    }

    // Méthode pour modifier un livre
    public void modifierLivre(Livre livre, String isbn, String titre, String auteur, Livre.EtatLivre etatLivre) {
        livre.setIsbn(isbn);
        livre.setTitre(titre);
        livre.setAuteur(auteur);
        livre.setEtatLivre(etatLivre);
    }
}
