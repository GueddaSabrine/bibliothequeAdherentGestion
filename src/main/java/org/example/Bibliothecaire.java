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

    public Adherent creerAdherent(int id, String nom, String prenom, String ville) {
//        Adherent nouvelAdherent = new Adherent();
//        nouvelAdherent.setId(id);
//        nouvelAdherent.setNom(nom);
//        nouvelAdherent.setPrenom(prenom);
//        nouvelAdherent.setVille(ville);
//        // Code supplémentaire pour enregistrer l'adhérent dans la base de données, par exemple
//        return nouvelAdherent;
    }
}