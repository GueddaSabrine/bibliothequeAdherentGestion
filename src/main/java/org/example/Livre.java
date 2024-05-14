package org.example;

public class Livre {
    private int id;
    private String isbn;
    private String auteur;
    private Enum etatLivre;

    public enum EtatLivre {
        DISPONIBLE,
        EMPRUNTE,
        PERDU
    }

    public Livre(int id, String isbn, String auteur, Enum etatLivre) {
        this.id = id;
        this.isbn = isbn;
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
}

