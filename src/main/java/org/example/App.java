package org.example;
import org.example.DAO.AdherentDAO;
import org.example.model.Adherent;

import java.util.List;

public class App 
{
//    public static void main( String[] args )
//    {
//        System.out.println( "Hello World!" );
//    }
public static void main(String[] args) {
    AdherentDAO adherentDAO = new AdherentDAO();
    AdherentDAO.testConnection();

    // Create a new user
    Adherent newAdherent = new Adherent(1, "YIN", "Cécile", "Pontoise", "ABC1");
    Adherent newAdherent2 = new Adherent(2, "GUEDDA", "Sabrine", "Cergy", "AZERTY23");
    Adherent newAdherent3 = new Adherent(3, "SEOULOU", "Aimée", "Pontoise", "ABCDE123");
    adherentDAO.createAdherent(newAdherent);
    adherentDAO.createAdherent(newAdherent2);
    adherentDAO.createAdherent(newAdherent3);

    // Get all users
    List<Adherent> adherents = adherentDAO.getAllAdherents();
    adherents.forEach(adherent -> System.out.println("Nom : " + adherent.getNom() + " / Prénom : " + adherent.getPrenom() + " / Ville :  " + adherent.getVille() + " / Code Adhérent :  " + adherent.getCodeAdherent()));

    // Update user
    Adherent adherentToUpdate = adherents.get(0);
/*    adherentToUpdate.setNom("Sabrine");
    adherentToUpdate.setPrenom("Aimée");
    adherentToUpdate.setVille("Cergy");
    adherentToUpdate.setCodeAdherent("ABC123");*/
    adherentDAO.updateAdherent(adherentToUpdate);

    // Get user by ID
    Adherent adherent = adherentDAO.getAdherentById(adherentToUpdate.getId());
    System.out.println("Nom : " + adherent.getNom() + " / Prénom : " + adherent.getPrenom() + " / Ville :  " + adherent.getVille() + " / Code Adhérent :  " + adherent.getCodeAdherent());

    // Delete user
    adherentDAO.deleteAdherent(adherentToUpdate.getId());

    // Verify user deletion
    adherents = adherentDAO.getAllAdherents();
    adherents.forEach(ad -> System.out.println("Nom : " + adherent.getNom() + " Prénom : " + adherent.getPrenom() + "  Ville :  " + adherent.getVille() + " Code Adhérent :  " + adherent.getCodeAdherent()));
// Création de quelques livres
//    Livre livre1 = new Livre(1, "1234567890", "Titre 1", "Auteur 1", Livre.EtatLivre.DISPONIBLE);
//    Livre livre2 = new Livre(2, "0987654321", "Titre 2", "Auteur 2", Livre.EtatLivre.DISPONIBLE);
//
//    // Création d'un adhérent
////    Adherent adherent = new Adherent(1, "John", "Doe", "Ville");
//
//    // Création d'un bibliothécaire
//    Bibliothecaire bibliothecaire = new Bibliothecaire(1, "Jane", "Smith");
//
//    // Exemple d'emprunt de livre par l'adhérent
//    adherent.enregistrerEmprunt(livre1);
//
//    // Exemple de modification d'un livre par le bibliothécaire
//    bibliothecaire.modifierLivre(livre2, "0987654321", "Nouveau Titre", "Nouvel Auteur", Livre.EtatLivre.DISPONIBLE);
//
//    // Affichage des informations sur les livres
//    livre1.afficherLivre();
//    livre2.afficherLivre();
}
}
