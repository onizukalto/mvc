package controller;

import model.Cart;
import utils.Constants;
import model.components.*;
import model.compatibility.CompatibilityChecker;
import model.data.DataLoader;
import view.ConsoleView;
import view.ComponentView;
import java.util.List;

/**
 * Contrôleur principal de l'application de configuration de PC.
 * Gère le chargement des données, les interactions utilisateur et la logique de sélection des composants.
 */
public class ComponentController {
    private Cart cart;
    private ConsoleView consoleView;
    private ComponentView componentView;
    private DataLoader dataLoader;
    private List<GraphicsCard> graphicsCards;
    private List<Motherboard> motherboards;
    private List<Processor> processors;
    private List<Ram> rams;
    private List<PowerSupply> powerSupplies;


     /**
        * Contrôleur pour gérer les opérations sur les composants.
        * Initialise les vues, le panier et charge les données nécessaires.
    */
    public ComponentController() {
        this.cart = new Cart();
        this.consoleView = new ConsoleView();
        this.componentView = new ComponentView();
        this.dataLoader = new DataLoader();
        loadData();
    }

    /**
     * Charge les données des différents composants à partir des fichiers.
     * Gère les exceptions de chargement de données.
     */
    private void loadData() {
        try {
            graphicsCards = dataLoader.loadGraphicsCards();
            motherboards = dataLoader.loadMotherboards();
            processors = dataLoader.loadProcessors();
            rams = dataLoader.loadRam();
            powerSupplies = dataLoader.loadPowerSupplies();
        } catch (Exception e) {
            consoleView.displayError("Erreur lors du chargement des données: " + e.getMessage());
        }
    }

    /**
     * Démarre l'application et gère la boucle principale du menu.
     */
    public void start() {
        consoleView.displayWelcome();
        boolean running = true;

        while (running) {
            displayMainMenu();
            int choice = consoleView.getIntInput();

            switch (choice) {
                case 1: handleGraphicsCards(); break;
                case 2: handleMotherboards(); break;
                case 3: handleProcessors(); break;
                case 4: handleRam(); break;
                case 5: handlePowerSupplies(); break;
                case 6: displayCart(); break;
                case 7: checkCompatibility(); break;
                case 8: running = false; break;
                default: consoleView.displayError("Option invalide");
            }
        }
        consoleView.displayMessage(Constants.GOODBYE_MESSAGE);
    }

    private void displayMainMenu() {
        consoleView.displayMessage("\nMenu Principal:");
        consoleView.displayMessage("1. Voir les cartes graphiques");
        consoleView.displayMessage("2. Voir les cartes mères");
        consoleView.displayMessage("3. Voir les processeurs");
        consoleView.displayMessage("4. Voir les RAM");
        consoleView.displayMessage("5. Voir les alimentations");
        consoleView.displayMessage("6. Voir le panier");
        consoleView.displayMessage("7. Vérifier la compatibilité");
        consoleView.displayMessage("8. Valider le panier et acheter");
        consoleView.displayMessage("Votre choix: ");
    }

    /**
     * Gère la sélection et l'ajout des cartes graphiques au panier.
     */
    private void handleGraphicsCards() {
        componentView.displayComponents(graphicsCards);
        consoleView.displayMessage("\nEntrez le numéro de la carte graphique (0 pour revenir): ");
        int choice = consoleView.getIntInput();

        if (choice > 0 && choice <= graphicsCards.size()) {
            GraphicsCard selectedCard = graphicsCards.get(choice - 1);
            if (checkCompatibilityBeforeAdding(selectedCard)) {
                cart.addItem(selectedCard);
                consoleView.displayMessage("Carte graphique ajoutée au panier!");
            }
        }
    }

    /**
     * Gère la sélection et l'ajout des cartes mères au panier.
     */
    private void handleMotherboards() {
        componentView.displayComponents(motherboards);
        consoleView.displayMessage("\nEntrez le numéro de la carte mère (0 pour revenir): ");
        int choice = consoleView.getIntInput();

        if (choice > 0 && choice <= motherboards.size()) {
            cart.addItem(motherboards.get(choice - 1));
            consoleView.displayMessage("Carte mère ajoutée au panier!");
        }
    }

    /**
     * Gère la sélection et l'ajout des processeurs au panier.
     */
    private void handleProcessors() {
        componentView.displayComponents(processors);
        consoleView.displayMessage("\nEntrez le numéro du processeur (0 pour revenir): ");
        int choice = consoleView.getIntInput();

        if (choice > 0 && choice <= processors.size()) {
            Processor selectedCPU = processors.get(choice - 1);
            if (checkCompatibilityBeforeAdding(selectedCPU)) {
                cart.addItem(selectedCPU);
                consoleView.displayMessage("Processeur ajouté au panier!");
            }
        }
    }

    /**
     * Gère la sélection et l'ajout des modules RAM au panier.
     */
    private void handleRam() {
        componentView.displayComponents(rams);
        consoleView.displayMessage("\nEntrez le numéro de la RAM (0 pour revenir): ");
        int choice = consoleView.getIntInput();

        if (choice > 0 && choice <= rams.size()) {
            cart.addItem(rams.get(choice - 1));
            consoleView.displayMessage("RAM ajoutée au panier!");
        }
    }

    /**
     * Gère la sélection et l'ajout des alimentations au panier.
     */
    private void handlePowerSupplies() {
        componentView.displayComponents(powerSupplies);
        consoleView.displayMessage("\nEntrez le numéro de l'alimentation (0 pour revenir): ");
        int choice = consoleView.getIntInput();

        if (choice > 0 && choice <= powerSupplies.size()) {
            cart.addItem(powerSupplies.get(choice - 1));
            consoleView.displayMessage("Alimentation ajoutée au panier!");
        }
    }

    /**
     * Vérifie la compatibilité des composants avant leur ajout au panier.
     * 
     * @param component Le composant à vérifier
     * @return Vrai si le composant est compatible, faux sinon
     */
    private boolean checkCompatibilityBeforeAdding(Component component) {
        List<Component> tempCart = cart.getItems();
        tempCart.add(component);
        
        String issues = CompatibilityChecker.getCompatibilityIssues(tempCart);
        if (!issues.isEmpty()) {
            consoleView.displayError("Problèmes de compatibilité détectés:");
            consoleView.displayError(issues);
            return false;
        }
        return true;
    }

    /**
     * Vérifie la compatibilité globale des composants du panier.
     */
    private void checkCompatibility() {
        if (cart.getItems().isEmpty()) {
            consoleView.displayMessage("Le panier est vide.");
            return;
        }

        String issues = CompatibilityChecker.getCompatibilityIssues(cart.getItems());
        if (issues.isEmpty()) {
            consoleView.displayMessage("Tous les composants sont compatibles!");
        } else {
            consoleView.displayError("Problèmes de compatibilité détectés:");
            consoleView.displayError(issues);
        }
    }

    /**
     * Affiche le contenu du panier et propose des options de gestion.
     */
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

        // Option pour supprimer un article
        consoleView.displayMessage("\n1. Supprimer un article");
        consoleView.displayMessage("2. Vider le panier");
        consoleView.displayMessage("3. Retour");
        consoleView.displayMessage("Votre choix: ");

        int choice = consoleView.getIntInput();
        switch (choice) {
            case 1:
                removeItemFromCart();
                break;
            case 2:
                cart.clear();
                consoleView.displayMessage("Panier vidé!");
                break;
        }
    }

    /**
     * Permet de supprimer un article spécifique du panier.
     */
    private void removeItemFromCart() {
        consoleView.displayMessage("Entrez le numéro de l'article à supprimer: ");
        int choice = consoleView.getIntInput();
        if (choice > 0 && choice <= cart.getItems().size()) {
            cart.removeItem(choice - 1);
            consoleView.displayMessage("Article supprimé!");
        } else {
            consoleView.displayError("Numéro d'article invalide");
        }
    }
}