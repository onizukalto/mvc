// model/components/Processor.java
package model.components;

/**
 * Représente un processeur dans le système de configuration de PC.
 * Étend la classe abstraite Component avec des propriétés spécifiques aux processeurs.
 */
public class Processor extends Component {
    private String socketType;
    private int tdp;
    private double frequency;

    public Processor(String id, String name, double price, String type,
                    String socketType, int tdp, double frequency) {
        super(id, name, price, type);
        this.socketType = socketType;
        this.tdp = tdp;
        this.frequency = frequency;
    }

    /**
     * Récupère le type de socket du processeur.
     * 
     * @return Type de socket compatible
     */
    public String getSocketType() { return socketType; }

    /**
     * Récupère la dissipation thermique du processeur.
     * 
     * @return Puissance thermique en watts
     */
    public int getTdp() { return tdp; }

    /**
     * Récupère la fréquence du processeur.
     * 
     * @return Fréquence du processeur en GHz
     */
    public double getFrequency() { return frequency; }

    @Override
    public String toString() {
        return String.format("%s - %s\nFréquence : %.2fGHz - Type de socket : %s - (%.2f€)\n\n", name, type, frequency, socketType, price);
    }
}