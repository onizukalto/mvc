// model/components/GraphicsCard.java
package model.components;

/**
 * Représente une carte graphique dans le système de configuration de PC.
 * Étend la classe abstraite Component avec des propriétés spécifiques aux cartes graphiques.
 */
public class GraphicsCard extends Component {
    private String compatibleMotherboards;
    private int powerRequirement;

    public GraphicsCard(String id, String name, double price, String type, 
                       String compatibleMotherboards, int powerRequirement) {
        super(id, name, price, type);
        this.compatibleMotherboards = compatibleMotherboards;
        this.powerRequirement = powerRequirement;
    }

    /**
     * Récupère les types de cartes mères compatibles avec cette carte graphique.
     * 
     * @return Chaîne représentant les types de cartes mères compatibles
     */
    public String getCompatibleMotherboards() { return compatibleMotherboards; }

    /**
     * Récupère la puissance requise par la carte graphique.
     * 
     * @return Puissance requise en watts
     */
    public int getPowerRequirement() { return powerRequirement; }

    @Override
    public String toString() {
        return String.format("%s\nPuissance requise : %dW - (%.2f€)\n", name, powerRequirement, price);
    }
}