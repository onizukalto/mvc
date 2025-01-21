package model.components;

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

    public int getWattage() { return wattage; }
    public String getCertification() { return certification; }
    public boolean isModular() { return modular; }
}