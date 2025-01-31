// model/components/Motherboard.java
package model.components;

/**
 * Représente une carte mère dans le système de configuration de PC.
 * Étend la classe abstraite Component avec des propriétés spécifiques aux cartes mères.
 */
public class Motherboard extends Component {
    private String socketType;
    private String formFactor;

    public Motherboard(String id, String name, double price, String type,
                      String socketType, String formFactor) {
        super(id, name, price, type);
        this.socketType = socketType;
        this.formFactor = formFactor;
    }

    /**
     * Récupère le type de socket de la carte mère.
     * 
     * @return Type de socket (ex: LGA1200, AM4)
     */
    public String getSocketType() { return socketType; }

    /**
     * Récupère le facteur de forme de la carte mère.
     * 
     * @return Facteur de forme (ex: ATX, micro-ATX)
     */
    public String getFormFactor() { return formFactor; }

    @Override
    public String toString() {
        return String.format("%s - Socket : %s\n Type de carte mère : %s - (%.2f€)\n\n", name, socketType, formFactor, price);
    }
}