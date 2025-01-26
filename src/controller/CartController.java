// controller/CartController.java
package controller;

import model.Cart;
import model.components.Component;
import view.ConsoleView;
import java.util.List;

/**
 * Contrôleur gérant les opérations sur le panier.
 * Permet d'ajouter, supprimer et afficher les articles du panier.
 */
public class CartController {
    private Cart cart;
    private ConsoleView consoleView;

    /**
     * Constructeur de la classe CartController.
     * 
     * @param cart Panier d'achat à gérer
     * @param consoleView Vue de la console pour l'interaction avec l'utilisateur
     */
    public CartController(Cart cart, ConsoleView consoleView) {
        this.cart = cart;
        this.consoleView = consoleView;
    }

    /**
     * Ajoute un composant au panier.
     * 
     * @param component Le composant à ajouter
     */
    public void addToCart(Component component) {
        cart.addItem(component);
        consoleView.displayMessage("Article ajouté au panier : " + component.getName());
    }

    /**
     * Supprime un composant du panier à l'index spécifié.
     * 
     * @param index L'index du composant à supprimer
     */
    public void removeFromCart(int index) {
        if (index >= 0 && index < cart.getItems().size()) {
            Component removed = cart.getItems().get(index);
            cart.removeItem(index);
            consoleView.displayMessage("Article retiré du panier : " + removed.getName());
        } else {
            consoleView.displayError("Index invalide");
        }
    }

    /**
     * Affiche le contenu actuel du panier.
     */
    public void displayCart() {
        List<Component> items = cart.getItems();
        if (items.isEmpty()) {
            consoleView.displayMessage("Le panier est vide");
            return;
        }

        consoleView.displayMessage("\n=== Contenu du Panier ===");
        for (int i = 0; i < items.size(); i++) {
            consoleView.displayMessage((i + 1) + ". " + items.get(i).toString());
        }
        consoleView.displayMessage("\nTotal : " + String.format("%.2f€", cart.getTotal()));
    }

    /**
     * Vide complètement le panier.
     */
    public void clearCart() {
        cart.clear();
        consoleView.displayMessage("Le panier a été vidé");
    }
}