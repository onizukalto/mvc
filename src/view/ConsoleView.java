// view/ConsoleView.java
package view;

import java.util.List;
import java.util.Scanner;

import model.components.Component;

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
        System.out.println("                                                                                     ,---,\r\n" + //
                        "                                                                                  ,`--.' |     ,----..              ____\r\n" + //
                        "  ,----..                                                          ,--,           |   :  :    /   /   \\           ,'  , `.                   ___\r\n" + //
                        " /   /   \\                            .--.,    ,--,                |'. \\          |   |  '   /   .     :       ,-+-,.' _ |                 ,--.'|_     ,--,\r\n" + //
                        "|   :     :    ,---.         ,---,  ,--.'  \\ ,--.'|                ; \\ `\\         '   :  |  .   /   ;.  \\   ,-+-. ;   , ||                 |  | :,'  ,--.'|\r\n" + //
                        ".   |  ;. /   '   ,'\\    ,-+-. /  | |  | /\\/ |  |,       ,----._,. `. \\  \\        ;   |.'  .   ;   /  ` ;  ,--.'|'   |  ;|                 :  : ' :  |  |,\r\n" + //
                        ".   ; /--`   /   /   |  ,--.'|'   | :  : :   `--'_      /   /  ' /  \\  \\  \\       '---'    ;   |  ; \\ ; | |   |  ,', |  ':    ,--.--.    .;__,'  /   `--'_        ,---.\r\n" + //
                        ";   | ;     .   ; ,. : |   |  ,\"' | :  | |-, ,' ,'|    |   :     |   \\  \\ '\\               |   :  | ; | ' |   | /  | |  ||   /       \\   |  |   |    ,' ,'|      /     \\\r\n" + //
                        "|   : |     '   | |: : |   | /  | | |  : :/| '  | |    |   | .\\  .    \\  ;  ;              .   |  ' ' ' : '   | :  | :  |,  .--.  .-. |  :__,'| :    '  | |     /    / '\r\n" + //
                        ".   | '___  '   | .; : |   | |  | | |  |  .' |  | :    .   ; ';  |     \\  \\  \\             '   ;  \\; /  | ;   . |  ; |--'    \\__\\/: . .    '  : |__  |  | :    .    ' /\r\n" + //
                        "'   ; : .'| |   :    | |   | |  |/  '  : '   '  : |__  '   .   . |      \\  ;  \\             \\   \\  ',  /  |   : |  | ,       ,\" .--.; |    |  | '.'| '  : |__  '   ; :__\r\n" + //
                        "'   | '/  :  \\   \\  /  |   | |--'   |  | |   |  | '.'|  `---`-'| |       \\  \\__;,            ;   :    /   |   : '  |/       /  /  ,.  |    ;  :    ; |  | '.'| '   | '.'|\r\n" + //
                        "|   :    /    `----'   |   |/       |  : \\   ;  :    ;  .'__/\\_: |        \\ |   :             \\   \\ .'    ;   | |`-'       ;  :   .'   \\   |  ,   /  ;  :    ; |   :    :\r\n" + //
                        " \\   \\ .'              '---'        |  |,'   |  ,   /   |   :    :         \\;   |              `---`      |   ;/           |  ,     .-./    ---`-'   |  ,   /   \\   \\  /\r\n" + //
                        "  `---`                             `--'      ---`-'     \\   \\  /           `---'                         '---'             `--`---'                  ---`-'     `----'\r\n" + //
                        "                                                          `--`-'\r\n" + //
                        "");  

        System.out.println("Bienvenue dans notre système de vente de composants PC");
    }

    /**
     * Affiche les options du menu principal à l'utilisateur.
     */
    public void displayMainMenu() {
        displayMessage("\n=== Menu Principal ===");
        displayMessage("1. Voir les cartes graphiques");
        displayMessage("2. Voir les cartes mères");
        displayMessage("3. Voir les processeurs");
        displayMessage("4. Voir les RAM");
        displayMessage("5. Voir les alimentations");
        displayMessage("6. Voir le panier");
        displayMessage("7. Vérifier la compatibilité");
        displayMessage("8. Valider le panier et acheter");
        displayMessage("Votre choix: ");
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

    /**
     * Affiche le contenu du panier et propose des options d'interaction.
     *
     * @param items Liste des composants dans le panier.
     * @param total Montant total du panier.
     * @return L'option choisie par l'utilisateur :
     *         -1 si le panier est vide,
     *         1 pour supprimer un article,
     *         2 pour vider le panier,
     *         3 pour retourner.
     */
    public int displayCart(List<Component> items, double total) {
        if (items.isEmpty()) {
            displayMessage("\nLe panier est vide");
            return -1;
        }

        displayMessage("\nContenu du panier:");
        for (int i = 0; i < items.size(); i++) {
            displayMessage((i + 1) + ". " + items.get(i));
        }
        displayMessage(String.format("\nTotal: %.2f€", total));

        // Option pour supprimer un article
        displayMessage("\n=== Options du Panier ===");
        displayMessage("\n1. Supprimer un article");
        displayMessage("2. Vider le panier");
        displayMessage("3. Retour");
        displayMessage("Votre choix: ");

        int choice = getIntInput();
        return choice;
    }
}