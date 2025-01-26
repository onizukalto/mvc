// model/components/Ram.java
package model.components;

/**
 * Représente un module de mémoire RAM dans le système de configuration de PC.
 * Étend la classe abstraite Component avec des propriétés spécifiques à la RAM.
 */
public class Ram extends Component {
    private String type; // DDR4, DDR5, etc.
    private int capacity;
    private int speed;

    public Ram(String id, String name, double price, String componentType,
              String ramType, int capacity, int speed) {
        super(id, name, price, componentType);
        this.type = ramType;
        this.capacity = capacity;
        this.speed = speed;
    }

    /**
     * Récupère le type de RAM (DDR4, DDR5, etc.).
     * 
     * @return Type de RAM
     */
    public String getRamType() { return type; }

    /**
     * Récupère la capacité du module de RAM.
     * 
     * @return Capacité en Go
     */
    public int getCapacity() { return capacity; }

    /**
     * Récupère la vitesse du module de RAM.
     * 
     * @return Vitesse en MHz
     */
    public int getSpeed() { return speed; }
}