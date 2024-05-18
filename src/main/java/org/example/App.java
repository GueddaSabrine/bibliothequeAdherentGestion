package org.example;

import org.example.DAO.AdherentDAO;
import org.example.model.Adherent;

import java.util.List;

/**
 * Classe principale de l'application de gestion des adhérents.
 */
public class App {
    /**
     * Point d'entrée principal de l'application.
     *
     * @param args les arguments de la ligne de commande
     */
    public static void main(String[] args) {
        // Initialisation du DAO pour les adhérents
        AdherentDAO adherentDAO = new AdherentDAO();

        // Test de la connexion à la base de données
        AdherentDAO.testConnection();

        // Création de nouveaux adhérents
        Adherent newAdherent = new Adherent(1, "YIN", "Cécile", "Pontoise", "ABC1");
        Adherent newAdherent2 = new Adherent(2, "GUEDDA", "Sabrine", "Cergy", "AZERTY23");
        Adherent newAdherent3 = new Adherent(3, "SEOULOU", "Aimée", "Pontoise", "ABCDE123");
        adherentDAO.createAdherent(newAdherent);
        adherentDAO.createAdherent(newAdherent2);
        adherentDAO.createAdherent(newAdherent3);

        // Récupération de tous les adhérents
        List<Adherent> adherents = adherentDAO.getAllAdherents();
        adherents.forEach(adherent -> System.out.println("Nom : " + adherent.getNom() + " / Prénom : " + adherent.getPrenom() + " / Ville : " + adherent.getVille() + " / Code Adhérent : " + adherent.getCodeAdherent()));

        // Mise à jour d'un adhérent
        Adherent adherentToUpdate = adherents.get(0);
        adherentDAO.updateAdherent(adherentToUpdate);

        // Récupération d'un adhérent par ID
        Adherent adherent = adherentDAO.getAdherentById(adherentToUpdate.getId());
        System.out.println("Nom : " + adherent.getNom() + " / Prénom : " + adherent.getPrenom() + " / Ville : " + adherent.getVille() + " / Code Adhérent : " + adherent.getCodeAdherent());

        // Suppression d'un adhérent
        adherentDAO.deleteAdherent(adherentToUpdate.getId());

        // Vérification de la suppression de l'adhérent
        adherents = adherentDAO.getAllAdherents();
        adherents.forEach(ad -> System.out.println("Nom : " + ad.getNom() + " / Prénom : " + ad.getPrenom() + " / Ville : " + ad.getVille() + " / Code Adhérent : " + ad.getCodeAdherent()));
    }
}
