// Main.java
import controller.ComponentController;

/**
 * Point d'entrée principal de l'application de validation de composants PC.
 * Initialise le contrôleur de composants et démarre l'application.
 */
public class Main {
    public static void main(String[] args) {
        ComponentController controller = new ComponentController();
        controller.start();
    }
}