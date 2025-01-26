// view/MenuView.java
package view;

/**
 * Gère l'affichage des différents menus de l'application de configuration de PC.
 * Fournit des méthodes pour afficher les menus principaux et de sous-menus.
 */
public class MenuView {
    /**
     * Affiche le menu principal de l'application.
     */
    public void displayMainMenu() {
        System.out.println("\n=== Menu Principal ===");
        System.out.println("1. Voir les composants disponibles");
        System.out.println("2. Voir le panier");
        System.out.println("3. Vérifier la compatibilité");
        System.out.println("4. Finaliser la commande");
        System.out.println("5. Quitter");
        System.out.print("Votre choix : ");
    }

    /**
     * Affiche le menu de sélection des types de composants.
     */
    public void displayComponentMenu() {
        System.out.println("\n=== Types de Composants ===");
        System.out.println("1. Cartes Graphiques");
        System.out.println("2. Cartes Mères");
        System.out.println("3. Processeurs");
        System.out.println("4. RAM");
        System.out.println("5. Retour");
        System.out.print("Votre choix : ");
    }

    /**
     * Affiche le menu des options du panier.
     */
    public void displayCartMenu() {
        System.out.println("\n=== Options du Panier ===");
        System.out.println("1. Voir le contenu");
        System.out.println("2. Supprimer un article");
        System.out.println("3. Vider le panier");
        System.out.println("4. Retour");
        System.out.print("Votre choix : ");
    }
}