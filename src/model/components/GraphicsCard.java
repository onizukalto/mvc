// model/components/GraphicsCard.java
package model.components;

public class GraphicsCard extends Component {
    private String compatibleMotherboards;
    private int powerRequirement;

    public GraphicsCard(String id, String name, double price, String type, 
                       String compatibleMotherboards, int powerRequirement) {
        super(id, name, price, type);
        this.compatibleMotherboards = compatibleMotherboards;
        this.powerRequirement = powerRequirement;
    }

    public String getCompatibleMotherboards() { return compatibleMotherboards; }
    public int getPowerRequirement() { return powerRequirement; }
}