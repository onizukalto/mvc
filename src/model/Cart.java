package model;

import model.components.Component;
import java.util.ArrayList;
import java.util.List;


/**
 * Représente le panier d'achat pour les composants PC.
 * Permet d'ajouter, supprimer et gérer les composants sélectionnés.
 */
public class Cart {
    private List<Component> items;
    
    /**
     * Constructeur par défaut.
     * Initialise un panier vide.
     */
    public Cart() {
        this.items = new ArrayList<>();
    }

    /**
     * Ajoute un composant au panier.
     * 
     * @param component Composant à ajouter
     */
    public void addItem(Component component) {
        items.add(component);
    }

    /**
     * Supprime un composant du panier à l'index spécifié.
     * 
     * @param index Index du composant à supprimer
     */
    public void removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
        }
    }

    /**
     * Récupère la liste des composants dans le panier.
     * 
     * @return Copie de la liste des composants
     */
    public List<Component> getItems() {
        return new ArrayList<>(items);
    }


    /**
     * Calcule le prix total des composants dans le panier.
     * 
     * @return Prix total
     */
    public double getTotal() {
        return items.stream()
                   .mapToDouble(Component::getPrice)
                   .sum();
    }

    /**
     * Vide complètement le panier.
     */
    public void clear() {
        items.clear();
    }
}