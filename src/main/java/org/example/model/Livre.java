package org.example.model;

/**
 * Classe représentant un livre dans une bibliothèque.
 */
public class Livre {
    private int id;
    private String isbn;
    private String titre;
    private String auteur;
    private EtatLivre etatLivre;
    private Categorie categorie;

    /**
     * Obtient la catégorie du livre.
     *
     * @return la catégorie du livre
     */
    public Categorie getCategorie() {
        return categorie;
    }

    /**
     * Enumération représentant l'état d'un livre.
     */
    public enum EtatLivre {
        DISPONIBLE,
        EMPRUNTE,
        PERDU
    }

    /**
     * Constructeur avec paramètres pour créer un livre.
     *
     * @param id l'identifiant du livre
     * @param isbn le code ISBN du livre
     * @param titre le titre du livre
     * @param auteur l'auteur du livre
     * @param etatLivre l'état actuel du livre
     * @param categorie la catégorie du livre
     */
    public Livre(int id, String isbn, String titre, String auteur, EtatLivre etatLivre, Categorie categorie) {
        this.id = id;
        this.isbn = isbn;
        this.titre = titre;
        this.auteur = auteur;
        this.etatLivre = etatLivre;
        this.categorie = categorie;
    }

    /**
     * Obtient l'identifiant du livre.
     *
     * @return l'identifiant du livre
     */
    public int getId() {
        return id;
    }

    /**
     * Définit l'identifiant du livre.
     *
     * @param id l'identifiant du livre
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtient le code ISBN du livre.
     *
     * @return le code ISBN du livre
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Définit le code ISBN du livre.
     *
     * @param isbn le code ISBN du livre
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Obtient le titre du livre.
     *
     * @return le titre du livre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Définit le titre du livre.
     *
     * @param titre le titre du livre
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * Obtient l'auteur du livre.
     *
     * @return l'auteur du livre
     */
    public String getAuteur() {
        return auteur;
    }

    /**
     * Définit l'auteur du livre.
     *
     * @param auteur l'auteur du livre
     */
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    /**
     * Obtient l'état actuel du livre.
     *
     * @return l'état actuel du livre
     */
    public EtatLivre getEtatLivre() {
        return etatLivre;
    }

    /**
     * Définit l'état actuel du livre.
     *
     * @param etatLivre l'état actuel du livre
     */
    public void setEtatLivre(EtatLivre etatLivre) {
        this.etatLivre = etatLivre;
    }

    /**
     * Définit la catégorie du livre.
     *
     * @param categorie la catégorie du livre
     */
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    /**
     * Ajoute un nouveau livre (méthode statique, cette méthode semble plus appropriée dans une classe de gestion de bibliothèque).
     *
     * @param id l'identifiant du livre
     * @param isbn le code ISBN du livre
     * @param titre le titre du livre
     * @param auteur l'auteur du livre
     * @param etatLivre l'état actuel du livre
     * @param categorie la catégorie du livre
     * @return le nouveau livre ajouté
     */
    public static Livre ajouterLivre(int id, String isbn, String titre, String auteur, EtatLivre etatLivre, Categorie categorie) {
        Livre nouveauLivre = new Livre(id, isbn, titre, auteur, etatLivre, categorie);
        System.out.println("Nouveau livre ajouté : " + nouveauLivre);
        return nouveauLivre;
    }

    /**
     * Modifie les détails d'un livre.
     *
     * @param isbn le nouveau code ISBN du livre
     * @param titre le nouveau titre du livre
     * @param auteur le nouvel auteur du livre
     * @param etatLivre le nouvel état du livre
     */
    public void modifierLivre(String isbn, String titre, String auteur, EtatLivre etatLivre) {
        this.isbn = isbn;
        this.titre = titre;
        this.auteur = auteur;
        this.etatLivre = etatLivre;
        System.out.println("Livre modifié : " + this);
    }

    /**
     * Affiche les informations d'un livre.
     */
    public void afficherLivre() {
        System.out.println("Informations du livre : ");
        System.out.println("ID : " + id);
        System.out.println("ISBN : " + isbn);
        System.out.println("Titre : " + titre);
        System.out.println("Auteur : " + auteur);
        System.out.println("État du livre : " + etatLivre);
        System.out.println("Categorie : " + categorie);
    }

    /**
     * Vérifie si le livre est disponible.
     *
     * @return true si le livre est disponible, false sinon
     */
    public boolean etatLivre() {
        if (etatLivre == null) {
            System.out.println("L'état du livre est null, impossible de vérifier la disponibilité.");
            return false;
        }
        boolean disponible = etatLivre.equals(EtatLivre.DISPONIBLE);
        System.out.println("Le livre " + (disponible ? "est" : "n'est pas") + " disponible.");
        return disponible;
    }
}
