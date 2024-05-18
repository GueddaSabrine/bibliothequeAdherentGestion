package org.example.model;

import java.util.List;

/**
 * Classe représentant un bibliothécaire avec des informations personnelles et des méthodes pour gérer les adhérents et les livres.
 */
public class Bibliothecaire {
    private int id;
    private String nom;
    private String prenom;

    /**
     * Constructeur avec paramètres pour créer un bibliothécaire.
     *
     * @param id l'identifiant du bibliothécaire
     * @param nom le nom du bibliothécaire
     * @param prenom le prénom du bibliothécaire
     */
    public Bibliothecaire(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    /**
     * Obtient l'identifiant du bibliothécaire.
     *
     * @return l'identifiant du bibliothécaire
     */
    public int getId() {
        return id;
    }

    /**
     * Définit l'identifiant du bibliothécaire.
     *
     * @param id l'identifiant du bibliothécaire
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtient le nom du bibliothécaire.
     *
     * @return le nom du bibliothécaire
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom du bibliothécaire.
     *
     * @param nom le nom du bibliothécaire
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtient le prénom du bibliothécaire.
     *
     * @return le prénom du bibliothécaire
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Définit le prénom du bibliothécaire.
     *
     * @param prenom le prénom du bibliothécaire
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Crée un nouvel adhérent et l'enregistre dans la base de données.
     *
     * @param nouvelAdherent le nouvel adhérent à créer
     * @return le nouvel adhérent créé
     */
    public Adherent creerAdherent(Adherent nouvelAdherent) {
        // Code pour enregistrer l'adhérent dans la base de données
        System.out.println("Nouvel adhérent créé : " + nouvelAdherent.getNom() + " " + nouvelAdherent.getPrenom());
        return nouvelAdherent;
    }

    /**
     * Modifie les informations d'un adhérent.
     *
     * @param adherent l'adhérent à modifier
     * @param nom le nouveau nom de l'adhérent
     * @param prenom le nouveau prénom de l'adhérent
     */
    public void modifierAdherent(Adherent adherent, String nom, String prenom) {
        adherent.setNom(nom);
        adherent.setPrenom(prenom);
        System.out.println("Adhérent " + adherent.getNom() + " " + adherent.getPrenom() + " modifié.");
    }

    /**
     * Modifie les informations d'un livre.
     *
     * @param livre le livre à modifier
     * @param isbn le nouvel ISBN du livre
     * @param titre le nouveau titre du livre
     * @param auteur le nouvel auteur du livre
     * @param etatLivre le nouvel état du livre
     */
    public void modifierLivre(Livre livre, String isbn, String titre, String auteur, Livre.EtatLivre etatLivre) {
        livre.setIsbn(isbn);
        livre.setTitre(titre);
        livre.setAuteur(auteur);
        livre.setEtatLivre(etatLivre);
        System.out.println("Livre " + livre.getTitre() + " modifié.");
    }

    /**
     * Ajoute un nouveau livre à la liste des livres si la catégorie du livre est valide.
     *
     * @param listeLivres la liste des livres existants
     * @param livre le nouveau livre à ajouter
     */
    public void ajouterNouveauLivre(List<Livre> listeLivres, Livre livre) {
        if (livre.getCategorie().estLibelleValide()) { // Utilisation de la méthode estLibelleValide pour valider la catégorie
            listeLivres.add(livre);
            System.out.println("Nouveau livre ajouté : " + livre.getTitre());
        } else {
            System.out.println("La catégorie du livre n'est pas valide. Le livre n'a pas été ajouté.");
        }
    }
}
