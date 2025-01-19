// view/ComponentView.java
package view;

import model.components.Component;
import java.util.List;

public class ComponentView {
    public void displayComponents(List<? extends Component> components) {
        System.out.println("\nComposants disponibles:");
        for (int i = 0; i < components.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, components.get(i));
        }
    }
}