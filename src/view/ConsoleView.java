// view/ConsoleView.java
package view;

import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public void displayWelcome() {
        System.out.println("=== PC Parts Validator ===");
        System.out.println("Bienvenue dans notre système de vente de composants PC");
    }

    public void displayMainMenu() {
        System.out.println("\nMenu Principal:");
        System.out.println("1. Voir les cartes graphiques disponibles");
        System.out.println("2. Voir les cartes mères disponibles");
        System.out.println("3. Voir le panier");
        System.out.println("4. Quitter");
        System.out.print("Votre choix: ");
    }

    public int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Veuillez entrer un nombre valide.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public String getStringInput() {
        return scanner.nextLine();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayError(String message) {
        System.out.println("Erreur: " + message);
    }
}