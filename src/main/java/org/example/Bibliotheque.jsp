<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestion des Livres</title>

    <style>
        /* Style de base pour les titres h2 */
        h2 {
            font-size: 24px;
            color: #333;
            margin-bottom: 20px;
            text-decoration: underline; /* Souligner les titres */
            text-align: center; /* Centrer les titres */
        }

        /* Style pour les formulaires */
        form {
            max-width: 400px; /* Limiter la largeur des formulaires */
            margin: 0 auto; /* Centrer les formulaires horizontalement */
            border: 2px solid #ccc; /* Ajouter un encadré autour des formulaires */
            padding: 20px;
            border-radius: 8px;
            box-sizing: border-box; /* Inclure le padding et la bordure dans la largeur */
        }

        /* Style pour les labels dans les formulaires */
        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }

        /* Style pour les champs de texte, les champs de sélection et les boutons dans les formulaires */
        input[type="text"],
        input[type="date"],
        select,
        button,
        input[type="submit"] {
            width: calc(100% - 22px); /* Prendre en compte la largeur du padding et de la bordure */
            padding: 8px; /* Réduire le rembourrage */
            margin-bottom: 10px; /* Réduire la marge inférieure */
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        /* Style pour les boutons */
        button,
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
            transition: background-color 0.3s ease; /* Transition douce pour le changement de couleur de fond */
        }

        /* Style pour les boutons au survol */
        button:hover,
        input[type="submit"]:hover {
            background-color: #45a049;
        }

        /* Style pour les messages d'alerte */
        .alert {
            padding: 15px;
            background-color: #f44336;
            color: white;
            margin-bottom: 15px;
        }

        /* Style pour les titres h1 */
        h1 {
            font-size: 28px;
            color: #333;
            margin-bottom: 20px;
            text-decoration: underline; /* Souligner les titres */
            text-align: center; /* Centrer les titres */
        }

        /* Style pour les boutons */
        .btn-container {
            max-width: 400px;
            margin: 0 auto;
            text-align: center; /* Centrer le contenu horizontalement */
        }

        /* Style pour les boutons */
        .btn-container button {
            width: auto; /* Largeur automatique pour s'adapter au contenu */
            margin: 10px; /* Ajouter un espace autour des boutons */
        }
    </style>
</head>
/**
* Cette classe représente une interface utilisateur pour gérer les livres, les adhérents et les emprunts.
* Elle utilise HTML pour la structure de la page et JavaScript pour gérer les interactions avec l'utilisateur.
*/
<body>
<h2>Ajouter un Livre</h2>
<form id="ajouterLivreForm" method="post">
    <label for="isbn">ISBN :</label><br>
    <input type="text" id="isbn" name="isbn"><br>
    <label for="titre">Titre :</label><br>
    <input type="text" id="titre" name="titre"><br>
    <label for="auteur">Auteur :</label><br>
    <input type="text" id="auteur" name="auteur"><br>
    <label for="etatLivre">État du Livre :</label><br>
    <select id="etatLivre" name="etatLivre">
        <option value="DISPONIBLE">Disponible</option>
        <option value="EMPRUNTE">Emprunté</option>
        <option value="PERDU">Perdu</option>
    </select><br>
    <label for="categorie">Catégorie :</label><br>
    <input type="text" id="categorie" name="categorie"><br>
    <button type="submit">Ajouter Livre</button>
</form>

<h2>Modifier un Livre</h2>
<form id="modifierLivreForm">
    <label for="id">ID du Livre :</label><br>
    <input type="text" id="id" name="id"><br>
    <label for="nouvelIsbn">Nouvel ISBN :</label><br>
    <input type="text" id="nouvelIsbn" name="nouvelIsbn"><br>
    <label for="nouveauTitre">Nouveau Titre :</label><br>
    <input type="text" id="nouveauTitre" name="nouveauTitre"><br>
    <label for="nouvelAuteur">Nouvel Auteur :</label><br>
    <input type="text" id="nouvelAuteur" name="nouvelAuteur"><br>
    <label for="nouvelEtatLivre">Nouvel État du Livre :</label><br>
    <select id="nouvelEtatLivre" name="nouvelEtatLivre">
        <option value="DISPONIBLE">Disponible</option>
        <option value="EMPRUNTE">Emprunté</option>
        <option value="PERDU">Perdu</option>
    </select><br>
    <button type="submit">Modifier Livre</button>
</form>

<h2>Afficher les Informations d'un Livre</h2>
<form id="afficherLivreForm">
    <label for="idAffichage">ID du Livre :</label><br>
    <input type="text" id="idAffichage" name="idAffichage"><br>
    <button type="button" onclick="afficherLivre()">Afficher Livre</button>
</form>
<div id="informationsLivre"></div>

<h2>Vérifier la Disponibilité d'un Livre</h2>
<form id="verifierDisponibiliteForm">
    <label for="idVerification">ID du Livre :</label><br>
    <input type="text" id="idVerification" name="idVerification"><br>
    <button type="button" onclick="verifierDisponibilite()">Vérifier Disponibilité</button>
</form>
<div id="resultatVerification"></div>

<h2>Créer un Adhérent</h2>
<form id="creerAdherentForm">
    <label for="nomAdherent">Nom :</label><br>
    <input type="text" id="nomAdherent" name="nomAdherent"><br>
    <label for="prenomAdherent">Prénom :</label><br>
    <input type="text" id="prenomAdherent" name="prenomAdherent"><br>
    <button type="submit">Créer Adhérent</button>
</form>

<h2>Modifier un Adhérent</h2>
<form id="modifierAdherentForm">
    <label for="nomAdherentAModifier">Nom de l'Adhérent à Modifier :</label><br>
    <input type="text" id="nomAdherentAModifier" name="nomAdherentAModifier"><br>
    <label for="prenomAdherentAModifier">Prénom de l'Adhérent à Modifier :</label><br>
    <input type="text" id="prenomAdherentAModifier" name="prenomAdherentAModifier"><br>
    <label for="nouveauNom">Nouveau Nom :</label><br>
    <input type="text" id="nouveauNom" name="nouveauNom"><br>
    <label for="nouveauPrenom">Nouveau Prénom :</label><br>
    <input type="text" id="nouveauPrenom" name="nouveauPrenom"><br>
    <button type="submit">Modifier Adhérent</button>
</form>

<h2>Ajouter un Nouveau Livre</h2>
<form id="ajouterNouveauLivreForm">
    <label for="isbnNouveauLivre">ISBN du Livre :</label><br>
    <input type="text" id="isbnNouveauLivre" name="isbnNouveauLivre"><br>
    <label for="titreNouveauLivre">Titre du Livre :</label><br>
    <input type="text" id="titreNouveauLivre" name="titreNouveauLivre"><br>
    <label for="auteurNouveauLivre">Auteur du Livre :</label><br>
    <input type="text" id="auteurNouveauLivre" name="auteurNouveauLivre"><br>
    <label for="etatNouveauLivre">État du Livre :</label><br>
    <select id="etatNouveauLivre" name="etatNouveauLivre">
        <option value="DISPONIBLE">Disponible</option>
        <option value="EMPRUNTE">Emprunté</option>
        <option value="PERDU">Perdu</option>
    </select><br>
    <label for="categorieNouveauLivre">Catégorie du Livre :</label><br>
    <input type="text" id="categorieNouveauLivre" name="categorieNouveauLivre"><br>
    <button type="submit">Ajouter Livre</button>
</form>

<h1>Adherent Interface</h1>
<!-- Form to search for a livre -->
<h2>Rechercher un Livre</h2>
<form id="rechercherLivreForm">
    <label for="titreRecherche">Titre du Livre à rechercher:</label><br>
    <input type="text" id="titreRecherche" name="titreRecherche"><br>
    <input type="submit" value="Rechercher Livre">
</form>

<h1>Categorie Interface</h1>

<!-- Form to input and validate a libelle -->
<h2>Validation de Libellé de Catégorie</h2>
<form id="validerLibelleForm">
    <label for="libelleCategorie">Libellé de Catégorie:</label><br>
    <input type="text" id="libelleCategorie" name="libelleCategorie"><br>
    <input type="submit" value="Valider Libellé">
</form>

<h1>Emprunt Interface</h1>
<h2>Enregistrer un Emprunt</h2>
<form id="enregistrerEmpruntForm">
    <label for="dateEmprunt">Date d'Emprunt:</label><br>
    <input type="date" id="dateEmprunt" name="dateEmprunt"><br>
    <label for="dateRetour">Date de Retour:</label><br>
    <input type="date" id="dateRetour" name="dateRetour"><br>
    <label for="titreLivre">Titre du Livre:</label><br>
    <input type="text" id="titreLivre" name="titreLivre"><br>
    <label for="nomAdherentEmprunt">Nom de l'Adherent:</label><br>
    <input type="text" id="nomAdherentEmprunt" name="nomAdherentEmprunt"><br>
    <input type="submit" value="Enregistrer Emprunt">
</form>


<div class="btn-container">
    <!-- Button to register the return of a livre -->
    <h2>Enregistrer le Retour d'un Livre</h2>
    <button id="enregistrerRetourBtn">Enregistrer Retour</button>

    <!-- Button to register the date of emprunt of a livre -->
    <h2>Enregistrer la Date d'Emprunt d'un Livre</h2>
    <button id="enregistrerDateEmpruntBtn">Enregistrer Date d'Emprunt</button>
</div>

<script>
    /**
     * Cette méthode est appelée lorsqu'on clique sur le bouton pour afficher les informations d'un livre.
     * Elle récupère l'ID du livre à afficher et envoie une requête AJAX pour récupérer les informations du livre.
     * Les informations du livre sont ensuite affichées dans la page.
     */
    function afficherLivre() {
        var id = document.getElementById("idAffichage").value;
        fetch("/afficherLivre?id=" + id)
            .then(response => response.json())
            .then(data => {
                document.getElementById("informationsLivre").innerHTML = "<pre>" + JSON.stringify(data, null, 2) + "</pre>";
            })
            .catch(error => console.error("Erreur :", error));
    }

    /**
     * Cette méthode est appelée lorsqu'on clique sur le bouton pour vérifier la disponibilité d'un livre.
     * Elle récupère l'ID du livre à vérifier et envoie une requête AJAX pour vérifier sa disponibilité.
     * Le résultat de la vérification est affiché dans la page.
     */
    function verifierDisponibilite() {
        var id = document.getElementById("idVerification").value;
        fetch("/verifierDisponibilite?id=" + id)
            .then(response => response.text())
            .then(data => {
                document.getElementById("resultatVerification").innerText = data;
            })
            .catch(error => console.error("Erreur :", error));
    }

    document.addEventListener("DOMContentLoaded", function() {
        // Form submission handlers
        document.getElementById("creerAdherentForm").addEventListener("submit", function(event) {
            event.preventDefault(); // Prevent the default form submission
            var nom = document.getElementById("nomAdherent").value;
            var prenom = document.getElementById("prenomAdherent").value;
            creerAdherent(nom, prenom);
        });

        document.getElementById("modifierAdherentForm").addEventListener("submit", function(event) {
            event.preventDefault(); // Prevent the default form submission
            var nomAModifier = document.getElementById("nomAdherentAModifier").value;
            var prenomAModifier = document.getElementById("prenomAdherentAModifier").value;
            var nouveauNom = document.getElementById("nouveauNom").value;
            var nouveauPrenom = document.getElementById("nouveauPrenom").value;
            modifierAdherent(nomAModifier, prenomAModifier, nouveauNom, nouveauPrenom);
        });

        document.getElementById("modifierLivreForm").addEventListener("submit", function(event) {
            event.preventDefault(); // Prevent the default form submission
            var isbnLivre = document.getElementById("isbnLivre").value;
            var nouvelIsbn = document.getElementById("nouvelIsbn").value;
            var nouveauTitre = document.getElementById("nouveauTitre").value;
            var nouvelAuteur = document.getElementById("nouvelAuteur").value;
            var nouvelEtatLivre = document.getElementById("nouvelEtatLivre").value;
            modifierLivre(isbnLivre, nouvelIsbn, nouveauTitre, nouvelAuteur, nouvelEtatLivre);
        });

        document.getElementById("ajouterNouveauLivreForm").addEventListener("submit", function(event) {
            event.preventDefault(); // Prevent the default form submission
            var isbnNouveauLivre = document.getElementById("isbnNouveauLivre").value;
            var titreNouveauLivre = document.getElementById("titreNouveauLivre").value;
            var auteurNouveauLivre = document.getElementById("auteurNouveauLivre").value;
            var etatNouveauLivre = document.getElementById("etatNouveauLivre").value;
            var categorieNouveauLivre = document.getElementById("categorieNouveauLivre").value;
            ajouterNouveauLivre(isbnNouveauLivre, titreNouveauLivre, auteurNouveauLivre, etatNouveauLivre, categorieNouveauLivre);
        });

        /**
         * Cette méthode est appelée lorsqu'on soumet le formulaire pour créer un nouvel adhérent.
         * Elle récupère le nom et le prénom de l'adhérent à créer et envoie une requête AJAX pour l'ajouter à la base de données.
         * Une alerte est affichée pour indiquer si l'opération a réussi ou échoué.
         */
        // Function to create an adherent
        function creerAdherent(nom, prenom) {
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "/creerAdherent", true);
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.onreadystatechange = function() {
                if (xhr.readyState === XMLHttpRequest.DONE) {
                    if (xhr.status === 200) {
                        alert("Nouvel adhérent créé avec succès !");
                    } else {
                        alert("Erreur lors de la création de l'adhérent.");
                    }
                }
            };
            var data = JSON.stringify({ "nom": nom, "prenom": prenom });
            xhr.send(data);
        }

        // Function to modify an adherent
        function modifierAdherent(nomAModifier, prenomAModifier, nouveauNom, nouveauPrenom) {
            // Send AJAX request to modify an adherent
            var xhr = new XMLHttpRequest();
            xhr.open("PUT", "/modifierAdherent", true);
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.onreadystatechange = function() {
                if (xhr.readyState === XMLHttpRequest.DONE) {
                    if (xhr.status === 200) {
                        alert("Adhérent modifié avec succès !");
                    } else {
                        alert("Erreur lors de la modification de l'adhérent.");
                    }
                }
            };
            var data = JSON.stringify({ "nomAModifier": nomAModifier, "prenomAModifier": prenomAModifier, "nouveauNom": nouveauNom, "nouveauPrenom": nouveauPrenom });
            xhr.send(data);
        }

        // Function to modify a book
        function modifierLivre(isbnLivre, nouvelIsbn, nouveauTitre, nouvelAuteur, nouvelEtatLivre) {
            // Send AJAX request to modify a book
            var xhr = new XMLHttpRequest();
            xhr.open("PUT", "/modifierLivre", true);
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.onreadystatechange = function() {
                if (xhr.readyState === XMLHttpRequest.DONE) {
                    if (xhr.status === 200) {
                        alert("Livre modifié avec succès !");
                    } else {
                        alert("Erreur lors de la modification du livre.");
                    }
                }
            };
            var data = JSON.stringify({ "isbnLivre": isbnLivre, "nouvelIsbn": nouvelIsbn, "nouveauTitre": nouveauTitre, "nouvelAuteur": nouvelAuteur, "nouvelEtatLivre": nouvelEtatLivre });
            xhr.send(data);
        }

        // Function to add a new book
        function ajouterNouveauLivre(isbnNouveauLivre, titreNouveauLivre, auteurNouveauLivre, etatNouveauLivre, categorieNouveauLivre) {
            // Send AJAX request to add a new book
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "/ajouterNouveauLivre", true);
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.onreadystatechange = function() {
                if (xhr.readyState === XMLHttpRequest.DONE) {
                    if (xhr.status === 200) {
                        alert("Nouveau livre ajouté avec succès !");
                    } else {
                        alert("Erreur lors de l'ajout du nouveau livre.");
                    }
                }
            };
            var data = JSON.stringify({ "isbnNouveauLivre": isbnNouveauLivre, "titreNouveauLivre": titreNouveauLivre, "auteurNouveauLivre": auteurNouveauLivre, "etatNouveauLivre": etatNouveauLivre, "categorieNouveauLivre": categorieNouveauLivre });
            xhr.send(data);
        }
    });

    document.addEventListener("DOMContentLoaded", function() {
        // Form submission handlers
        document.getElementById("enregistrerEmpruntForm").addEventListener("submit", function(event) {
            event.preventDefault(); // Prevent the default form submission
            var titreLivre = document.getElementById("titreLivre").value;
            enregistrerEmprunt(titreLivre);
        });

        document.getElementById("rechercherLivreForm").addEventListener("submit", function(event) {
            event.preventDefault(); // Prevent the default form submission
            var titreRecherche = document.getElementById("titreRecherche").value;
            rechercherLivre(titreRecherche);
        });

        // Function to register an emprunt
        function enregistrerEmprunt(titreLivre) {
            // Send AJAX request to register an emprunt
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "/enregistrerEmprunt", true);
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.onreadystatechange = function() {
                if (xhr.readyState === XMLHttpRequest.DONE) {
                    if (xhr.status === 200) {
                        alert("Emprunt enregistré avec succès !");
                    } else {
                        alert("Erreur lors de l'enregistrement de l'emprunt.");
                    }
                }
            };
            var data = JSON.stringify({ "titreLivre": titreLivre });
            xhr.send(data);
        }

        // Function to search for a livre
        function rechercherLivre(titreRecherche) {
            // Send AJAX request to search for a livre
            var xhr = new XMLHttpRequest();
            xhr.open("GET", "/rechercherLivre?titre=" + titreRecherche, true);
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.onreadystatechange = function() {
                if (xhr.readyState === XMLHttpRequest.DONE) {
                    if (xhr.status === 200) {
                        var livre = JSON.parse(xhr.responseText);
                        alert("Livre trouvé : " + livre.titre);
                    } else {
                        alert("Livre non trouvé.");
                    }
                }
            };
            xhr.send();
        }
    });

    document.addEventListener("DOMContentLoaded", function() {
        // Form submission handler
        document.getElementById("validerLibelleForm").addEventListener("submit", function(event) {
            event.preventDefault(); // Prevent the default form submission
            var libelleCategorie = document.getElementById("libelleCategorie").value;
            validerLibelle(libelleCategorie);
        });

        // Function to validate a libelle
        function validerLibelle(libelleCategorie) {
            // Send AJAX request to validate the libelle
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "/validerLibelle", true);
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.onreadystatechange = function() {
                if (xhr.readyState === XMLHttpRequest.DONE) {
                    if (xhr.status === 200) {
                        alert("Le libellé de la catégorie est valide !");
                    } else {
                        alert("Le libellé de la catégorie n'est pas valide.");
                    }
                }
            };
            var data = JSON.stringify({ "libelleCategorie": libelleCategorie });
            xhr.send(data);
        }
    });

    document.addEventListener("DOMContentLoaded", function() {
        // Form submission handler for enregistrerEmpruntForm
        document.getElementById("enregistrerEmpruntForm").addEventListener("submit", function(event) {
            event.preventDefault(); // Prevent the default form submission
            var dateEmprunt = document.getElementById("dateEmprunt").value;
            var dateRetour = document.getElementById("dateRetour").value;
            var titreLivre = document.getElementById("titreLivre").value;
            var nomAdherent = document.getElementById("nomAdherent").value;
            enregistrerEmprunt(dateEmprunt, dateRetour, titreLivre, nomAdherent);
        });

        // Button click handler for enregistrerRetourBtn
        document.getElementById("enregistrerRetourBtn").addEventListener("click", function() {
            enregistrerRetour();
        });

        // Button click handler for enregistrerDateEmpruntBtn
        document.getElementById("enregistrerDateEmpruntBtn").addEventListener("click", function() {
            enregistrerDateEmprunt();
        });

        // Function to register a new emprunt
        function enregistrerEmprunt(dateEmprunt, dateRetour, titreLivre, nomAdherent) {
            alert("Emprunt enregistré avec succès !");
        }

        // Function to register the return of a livre
        function enregistrerRetour() {
            alert("Le retour du livre a été enregistré !");
        }

        // Function to register the date of emprunt of a livre
        function enregistrerDateEmprunt() {
            alert("La date d'emprunt du livre a été enregistrée !");
        }
    });

</script>
</body>
</html>
