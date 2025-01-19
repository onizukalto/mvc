// model/components/Component.java
package model.components;

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

    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getType() { return type; }

    @Override
    public String toString() {
        return String.format("%s - %s (%.2f€)", name, type, price);
    }
}