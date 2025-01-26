// view/ConsoleView.java
package view;

import java.util.Scanner;

/**
 * Gère les entrées et sorties console pour l'application de validation de composants PC.
 * Gère les interactions utilisateur, les affichages de menu et la validation des entrées.
 */
public class ConsoleView {
    private Scanner scanner;

    /**
     * Construit une ConsoleView avec un nouveau Scanner pour les entrées utilisateur.
     */
    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Affiche le message de bienvenue de l'application.
     */
    public void displayWelcome() {
        System.out.println("=== PC Parts Validator ===");
        System.out.println("Bienvenue dans notre système de vente de composants PC");
    }

    /**
     * Affiche les options du menu principal à l'utilisateur.
     */
    public void displayMainMenu() {
        System.out.println("\nMenu Principal:");
        System.out.println("1. Voir les cartes graphiques disponibles");
        System.out.println("2. Voir les cartes mères disponibles");
        System.out.println("3. Voir le panier");
        System.out.println("4. Quitter");
        System.out.print("Votre choix: ");
    }

    /**
     * Lit et valide une entrée entière de l'utilisateur.
     * 
     * @return Une entrée entière valide
     */
    public int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Veuillez entrer un nombre valide.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    /**
     * Lit une entrée de chaîne de caractères de l'utilisateur.
     * 
     * @return La chaîne de caractères saisie
     */
    public String getStringInput() {
        return scanner.nextLine();
    }

    /**
     * Affiche un message général à l'utilisateur.
     * 
     * @param message Le message à afficher
     */
    public void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Affiche un message d'erreur à l'utilisateur.
     * 
     * @param message Le message d'erreur à afficher
     */
    public void displayError(String message) {
        System.out.println("Erreur: " + message);
    }
}