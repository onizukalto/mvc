// view/MenuView.java
package view;

public class MenuView {
    public void displayMainMenu() {
        System.out.println("\n=== Menu Principal ===");
        System.out.println("1. Voir les composants disponibles");
        System.out.println("2. Voir le panier");
        System.out.println("3. Vérifier la compatibilité");
        System.out.println("4. Finaliser la commande");
        System.out.println("5. Quitter");
        System.out.print("Votre choix : ");
    }

    public void displayComponentMenu() {
        System.out.println("\n=== Types de Composants ===");
        System.out.println("1. Cartes Graphiques");
        System.out.println("2. Cartes Mères");
        System.out.println("3. Processeurs");
        System.out.println("4. RAM");
        System.out.println("5. Retour");
        System.out.print("Votre choix : ");
    }

    public void displayCartMenu() {
        System.out.println("\n=== Options du Panier ===");
        System.out.println("1. Voir le contenu");
        System.out.println("2. Supprimer un article");
        System.out.println("3. Vider le panier");
        System.out.println("4. Retour");
        System.out.print("Votre choix : ");
    }
}