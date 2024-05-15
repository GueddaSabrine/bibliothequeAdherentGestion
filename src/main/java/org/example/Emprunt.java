package org.example;

import java.util.Date;

public class Emprunt {
    private int id;
    private Date dateRetour;
    private Date dateEmprunt;
    private Livre livre;
    private Adherent adherent;

    public Emprunt(int id, Date dateRetour, Date dateEmprunt, Livre livre, Adherent adherent) {
        this.id = id;
        this.dateRetour = dateRetour;
        this.dateEmprunt = dateEmprunt;
        this.livre = livre;
        this.adherent = adherent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Adherent getAdherent() {
        return adherent;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }

    // Méthode pour enregistrer un emprunt d'un livre
    public static Emprunt enregistrerEmprunt(int id, Date dateEmprunt, Date dateRetour, Livre livre, Adherent adherent) {
        return new Emprunt(id, dateRetour, dateEmprunt, livre, adherent);
    }

    // Méthode pour enregistrer le retour d'un livre
    public void enregistrerRetour() {
        if (getDateEmprunt() == null) {
            System.out.println("Ce livre n'a pas été emprunté.");
        } else {
            setDateRetour(new Date());
            System.out.println("Le livre " + livre.getTitre() + " a été retourné par " + adherent.getNom() + " " + adherent.getPrenom());
        }
    }

    // Méthode pour enregistrer la date d'emprunt d'un livre
    public void enregistrerEmprunt() {
        setDateEmprunt(new Date());
        System.out.println("Le livre " + livre.getTitre() + " a été emprunté par " + adherent.getNom() + " " + adherent.getPrenom());
    }

}
