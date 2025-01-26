package view;

import model.components.Component;
import java.util.List;

/**
 * Responsable de l'affichage d'une liste de composants à l'utilisateur.
 * Fournit un affichage console formatté pour les composants disponibles.
 */
public class ComponentView {
    /**
     * Affiche une liste numérotée des composants disponibles.
     * 
     * @param components Liste des composants à afficher
     */
    public void displayComponents(List<? extends Component> components) {
        System.out.println("\nComposants disponibles:");
        for (int i = 0; i < components.size() - 1; i++) {
            System.out.printf("%d. %s%n", i + 1, components.get(i));
        }
    }
}