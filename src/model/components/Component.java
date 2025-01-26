// model/components/Component.java
package model.components;

/**
 * Classe abstraite représentant un composant générique.
 * Sert de base pour tous les types de composants PC.
 */
public abstract class Component {
    protected String id;
    protected String name;
    protected double price;
    protected String type;

    public Component(String id, String name, double price, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }
    
    /**
     * Récupère l'identifiant unique du composant.
     * 
     * @return Identifiant du composant
     */
    public String getId() { return id; }

    /**
     * Récupère le nom du composant.
     * 
     * @return Nom du composant
     */
    public String getName() { return name; }

    /**
     * Récupère le prix du composant.
     * 
     * @return Prix du composant
     */
    public double getPrice() { return price; }

    /**
     * Récupère le type du composant.
     * 
     * @return Type du composant
     */
    public String getType() { return type; }

    @Override
    public String toString() {
        return String.format("%s - %s (%.2f€)", name, type, price);
    }
}