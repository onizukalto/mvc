// controller/CartController.java
package controller;

import model.Cart;
import model.components.Component;
import view.ConsoleView;
import java.util.List;

public class CartController {
    private Cart cart;
    private ConsoleView consoleView;

    public CartController(Cart cart, ConsoleView consoleView) {
        this.cart = cart;
        this.consoleView = consoleView;
    }

    public void addToCart(Component component) {
        cart.addItem(component);
        consoleView.displayMessage("Article ajouté au panier : " + component.getName());
    }

    public void removeFromCart(int index) {
        if (index >= 0 && index < cart.getItems().size()) {
            Component removed = cart.getItems().get(index);
            cart.removeItem(index);
            consoleView.displayMessage("Article retiré du panier : " + removed.getName());
        } else {
            consoleView.displayError("Index invalide");
        }
    }

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

    public void clearCart() {
        cart.clear();
        consoleView.displayMessage("Le panier a été vidé");
    }
}