package org.example.model;

import java.util.Date;

/**
 * Classe représentant un emprunt de livre par un adhérent avec des informations sur les dates d'emprunt et de retour.
 */
public class Emprunt {
    private int id;
    private Date dateRetour;
    private Date dateEmprunt;
    private Livre livre;
    private Adherent adherent;

    /**
     * Constructeur avec paramètres pour créer un emprunt.
     *
     * @param id l'identifiant de l'emprunt
     * @param dateRetour la date de retour prévue du livre
     * @param dateEmprunt la date d'emprunt du livre
     * @param livre le livre emprunté
     * @param adherent l'adhérent qui emprunte le livre
     */
    public Emprunt(int id, Date dateRetour, Date dateEmprunt, Livre livre, Adherent adherent) {
        this.id = id;
        this.dateRetour = dateRetour;
        this.dateEmprunt = dateEmprunt;
        this.livre = livre;
        this.adherent = adherent;
    }

    /**
     * Obtient l'identifiant de l'emprunt.
     *
     * @return l'identifiant de l'emprunt
     */
    public int getId() {
        return id;
    }

    /**
     * Définit l'identifiant de l'emprunt.
     *
     * @param id l'identifiant de l'emprunt
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtient la date de retour prévue du livre.
     *
     * @return la date de retour du livre
     */
    public Date getDateRetour() {
        return dateRetour;
    }

    /**
     * Définit la date de retour prévue du livre.
     *
     * @param dateRetour la date de retour du livre
     */
    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    /**
     * Obtient la date d'emprunt du livre.
     *
     * @return la date d'emprunt du livre
     */
    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    /**
     * Définit la date d'emprunt du livre.
     *
     * @param dateEmprunt la date d'emprunt du livre
     */
    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    /**
     * Obtient le livre emprunté.
     *
     * @return le livre emprunté
     */
    public Livre getLivre() {
        return livre;
    }

    /**
     * Définit le livre emprunté.
     *
     * @param livre le livre emprunté
     */
    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    /**
     * Obtient l'adhérent qui a emprunté le livre.
     *
     * @return l'adhérent qui a emprunté le livre
     */
    public Adherent getAdherent() {
        return adherent;
    }

    /**
     * Définit l'adhérent qui a emprunté le livre.
     *
     * @param adherent l'adhérent qui a emprunté le livre
     */
    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }

    /**
     * Enregistre un emprunt d'un livre par un adhérent.
     *
     * @param id l'identifiant de l'emprunt
     * @param dateEmprunt la date d'emprunt du livre
     * @param dateRetour la date de retour prévue du livre
     * @param livre le livre emprunté
     * @param adherent l'adhérent qui emprunte le livre
     * @return un nouvel objet Emprunt
     */
    public static Emprunt enregistrerEmprunt(int id, Date dateEmprunt, Date dateRetour, Livre livre, Adherent adherent) {
        return new Emprunt(id, dateRetour, dateEmprunt, livre, adherent);
    }

    /**
     * Enregistre le retour d'un livre emprunté.
     */
    public void enregistrerRetour() {
        if (getDateEmprunt() == null) {
            System.out.println("Ce livre n'a pas été emprunté.");
        } else {
            setDateRetour(new Date());
            System.out.println("Le livre " + livre.getTitre() + " a été retourné par " + adherent.getNom() + " " + adherent.getPrenom());
        }
    }

    /**
     * Enregistre la date d'emprunt d'un livre.
     */
    public void enregistrerEmprunt() {
        setDateEmprunt(new Date());
        System.out.println("Le livre " + livre.getTitre() + " a été emprunté par " + adherent.getNom() + " " + adherent.getPrenom());
    }
}
