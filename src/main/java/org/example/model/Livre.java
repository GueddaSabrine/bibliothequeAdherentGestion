package org.example.model;

public class Livre {
    private int id;
    private String isbn;
    private String titre;
    private String auteur;
    private EtatLivre etatLivre;
    private Categorie categorie;

    public Categorie getCategorie() {
        return categorie;
    }

    public enum EtatLivre {
        DISPONIBLE,
        EMPRUNTE,
        PERDU
    }

    public Livre(int id, String isbn, String titre, String auteur, EtatLivre etatLivre, Categorie categorie) {
        this.id = id;
        this.isbn = isbn;
        this.titre = titre;
        this.auteur = auteur;
        this.etatLivre = etatLivre;
        this.categorie = categorie;
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

    public EtatLivre getEtatLivre() {
        return etatLivre;
    }

    public void setEtatLivre(EtatLivre etatLivre) {
        this.etatLivre = etatLivre;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    // Méthode pour ajouter un nouveau livre (remarque : cette méthode semble plus appropriée dans une classe de gestion de bibliothèque)
    public static Livre ajouterLivre(int id, String isbn, String titre, String auteur, EtatLivre etatLivre, Categorie categorie) {
        Livre nouveauLivre = new Livre(id, isbn, titre, auteur, etatLivre, categorie);
        System.out.println("Nouveau livre ajouté : " + nouveauLivre);
        return nouveauLivre;
    }

    // Méthode pour modifier un livre
    public void modifierLivre(String isbn, String titre, String auteur, EtatLivre etatLivre) {
        this.isbn = isbn;
        this.titre = titre;
        this.auteur = auteur;
        this.etatLivre = etatLivre;
        this.categorie = categorie;
        System.out.println("Livre modifié : " + this);
    }

    // Méthode pour afficher les informations d'un livre
    public void afficherLivre() {
        System.out.println("Informations du livre : ");
        System.out.println("ID : " + id);
        System.out.println("ISBN : " + isbn);
        System.out.println("Titre : " + titre);
        System.out.println("Auteur : " + auteur);
        System.out.println("État du livre : " + etatLivre);
        System.out.println("Categorie : " + categorie);
    }

    // Méthode pour vérifier la disponibilité du livre
    public boolean estDisponible() {
        System.out.println("Vérification de la disponibilité du livre : ");
        return etatLivre.equals(EtatLivre.DISPONIBLE);
    }
}

