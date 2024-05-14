package org.example;

public class Livre {
    private int id;
    private String isbn;
    private String titre;
    private String auteur;
    private Enum etatLivre;

    public enum EtatLivre {
        DISPONIBLE,
        EMPRUNTE,
        PERDU
    }

    public Livre(int id, String isbn, String titre, String auteur, Enum etatLivre) {
        this.id = id;
        this.isbn = isbn;
        this.titre = titre;
        this.auteur = auteur;
        this.etatLivre = etatLivre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public Enum getEtatLivre() {
        return etatLivre;
    }

    public void setEtatLivre(Enum etatLivre) {
        this.etatLivre = etatLivre;
    }

    // Méthode pour modifier un livre
    public void modifierLivre(String isbn, String titre, String auteur, EtatLivre etatLivre) {
        this.isbn = isbn;
        this.titre = titre;
        this.auteur = auteur;
        this.etatLivre = etatLivre;
    }

    // Méthode pour afficher les informations d'un livre
    public void afficherLivre() {
        System.out.println("ID : " + id);
        System.out.println("ISBN : " + isbn);
        System.out.println("Titre : " + titre);
        System.out.println("Auteur : " + auteur);
        System.out.println("État du livre : " + etatLivre);
    }

    // Méthode pour vérifier la disponibilité du livre
    public boolean estDisponible() {
        return etatLivre == EtatLivre.DISPONIBLE;
    }
}

