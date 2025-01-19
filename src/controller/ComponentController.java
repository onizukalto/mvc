// controller/ComponentController.java
package controller;

import model.Cart;
import model.components.*;
import model.compatibility.CompatibilityChecker;
import model.data.DataLoader;
import view.ConsoleView;
import view.ComponentView;
import java.util.List;

public class ComponentController {
    private Cart cart;
    private ConsoleView consoleView;
    private ComponentView componentView;
    private DataLoader dataLoader;
    private List<GraphicsCard> graphicsCards;
    private List<Motherboard> motherboards;

    public ComponentController() {
        this.cart = new Cart();
        this.consoleView = new ConsoleView();
        this.componentView = new ComponentView();
        this.dataLoader = new DataLoader();
        loadData();
    }

    private void loadData() {
        try {
            graphicsCards = dataLoader.loadGraphicsCards();
            motherboards = dataLoader.loadMotherboards();
        } catch (Exception e) {
            consoleView.displayError("Erreur lors du chargement des données: " + e.getMessage());
        }
    }

    public void start() {
        consoleView.displayWelcome();
        boolean running = true;

        while (running) {
            consoleView.displayMainMenu();
            int choice = consoleView.getIntInput();

            switch (choice) {
                case 1:
                    handleGraphicsCards();
                    break;
                case 2:
                    handleMotherboards();
                    break;
                case 3:
                    displayCart();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    consoleView.displayError("Option invalide");
            }
        }
    }

    private void handleGraphicsCards() {
        componentView.displayComponents(graphicsCards);
        consoleView.displayMessage("\nEntrez le numéro de la carte graphique (0 pour revenir): ");
        int choice = consoleView.getIntInput();

        if (choice > 0 && choice <= graphicsCards.size()) {
            GraphicsCard selectedCard = graphicsCards.get(choice - 1);
            if (checkCompatibility(selectedCard)) {
                cart.addItem(selectedCard);
                consoleView.displayMessage("Carte graphique ajoutée au panier!");
            }
        }
    }

    private void handleMotherboards() {
        componentView.displayComponents(motherboards);
        consoleView.displayMessage("\nEntrez le numéro de la carte mère (0 pour revenir): ");
        int choice = consoleView.getIntInput();

        if (choice > 0 && choice <= motherboards.size()) {
            cart.addItem(motherboards.get(choice - 1));
            consoleView.displayMessage("Carte mère ajoutée au panier!");
        }
    }

    private boolean checkCompatibility(GraphicsCard card) {
        // Vérifier si une carte mère est déjà dans le panier
        for (Component item : cart.getItems()) {
            if (item instanceof Motherboard) {
                if (!CompatibilityChecker.isCompatible((Motherboard) item, card)) {
                    consoleView.displayError("Cette carte graphique n'est pas compatible avec la carte mère sélectionnée!");
                    return false;
                }
                return true;
            }
        }
        consoleView.displayMessage("Attention: Aucune carte mère n'est sélectionnée. Veuillez d'abord choisir une carte mère.");
        return false;
    }

    private void displayCart() {
        List<Component> items = cart.getItems();
        if (items.isEmpty()) {
            consoleView.displayMessage("\nLe panier est vide");
            return;
        }

        consoleView.displayMessage("\nContenu du panier:");
        for (int i = 0; i < items.size(); i++) {
            consoleView.displayMessage((i + 1) + ". " + items.get(i));
        }
        consoleView.displayMessage(String.format("\nTotal: %.2f€", cart.getTotal()));
    }
}