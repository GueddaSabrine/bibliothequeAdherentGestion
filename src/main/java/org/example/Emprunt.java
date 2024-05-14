package org.example;

import java.util.Date;

public class Emprunt {
    private int id;
    private Date dateRetour;
    private Date dateEmprunt;

    public Emprunt(int id, Date dateRetour, Date dateEmprunt) {
        this.id = id;
        this.dateRetour = dateRetour;
        this.dateEmprunt = dateEmprunt;
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
}
