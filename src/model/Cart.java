// model/Cart.java
package model;

import model.components.Component;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Component> items;
    
    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Component component) {
        items.add(component);
    }

    public void removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
        }
    }

    public List<Component> getItems() {
        return new ArrayList<>(items);
    }

    public double getTotal() {
        return items.stream()
                   .mapToDouble(Component::getPrice)
                   .sum();
    }

    public void clear() {
        items.clear();
    }
}