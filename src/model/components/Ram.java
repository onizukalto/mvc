// model/components/Ram.java
package model.components;

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

    public String getRamType() { return type; }
    public int getCapacity() { return capacity; }
    public int getSpeed() { return speed; }
}