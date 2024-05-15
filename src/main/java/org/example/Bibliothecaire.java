package org.example;

import java.util.List;

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
        System.out.println("Nouvel adhérent créé : " + nouvelAdherent.getNom() + " " + nouvelAdherent.getPrenom());
        return nouvelAdherent;
    }

    // Méthode pour modifier un adhérent
    public void modifierAdherent(Adherent adherent, String nom, String prenom) {
        adherent.setNom(nom);
        adherent.setPrenom(prenom);
        System.out.println("Adhérent " + adherent.getNom() + " " + adherent.getPrenom() + " modifié.");
    }

    // Méthode pour modifier un livre
    public void modifierLivre(Livre livre, String isbn, String titre, String auteur, Livre.EtatLivre etatLivre) {
        livre.setIsbn(isbn);
        livre.setTitre(titre);
        livre.setAuteur(auteur);
        livre.setEtatLivre(etatLivre);
        System.out.println("Livre " + livre.getTitre() + " modifié.");
    }

    // Méthode pour ajouter un nouveau livre
    public void ajouterNouveauLivre(List<Livre> listeLivres, Livre livre) {
        if (livre.getCategorie().estLibelleValide()) { // Utilisation de la méthode estLibelleValide pour valider la catégorie
            listeLivres.add(livre);
            System.out.println("Nouveau livre ajouté : " + livre.getTitre());
        } else {
            System.out.println("La catégorie du livre n'est pas valide. Le livre n'a pas été ajouté.");
        }
    }
}
