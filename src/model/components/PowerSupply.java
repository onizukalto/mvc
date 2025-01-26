package model.components;

/**
 * Représente une alimentation dans le système de configuration de PC.
 * Étend la classe abstraite Component avec des propriétés spécifiques aux alimentations.
 */
public class PowerSupply extends Component {
    private int wattage;
    private String certification; // 80+ Bronze, Gold, etc.
    private boolean modular;

    public PowerSupply(String id, String name, double price, String type,
                      int wattage, String certification, boolean modular) {
        super(id, name, price, type);
        this.wattage = wattage;
        this.certification = certification;
        this.modular = modular;
    }

    /**
     * Récupère la puissance nominale de l'alimentation.
     * 
     * @return Puissance en watts
     */
    public int getWattage() { return wattage; }

    /**
     * Récupère la certification de l'alimentation.
     * 
     * @return Niveau de certification (ex: 80+ Bronze, Gold)
     */
    public String getCertification() { return certification; }

    /**
     * Vérifie si l'alimentation est modulaire.
     * 
     * @return Vrai si l'alimentation est modulaire, faux sinon
     */
    public boolean isModular() { return modular; }
}