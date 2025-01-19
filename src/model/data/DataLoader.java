// model/data/DataLoader.java
package model.data;

import model.components.*;
import utils.JsonHandler;
import java.util.*;
import java.io.IOException;

public class DataLoader {
    private final JsonHandler jsonHandler;

    public DataLoader() {
        this.jsonHandler = new JsonHandler();
    }

    public List<GraphicsCard> loadGraphicsCards() throws IOException {
        List<GraphicsCard> cards = new ArrayList<>();
        List<Map<String, String>> data = jsonHandler.readJsonArray("resources/data/graphics_cards.json");
        
        for (Map<String, String> obj : data) {
            cards.add(new GraphicsCard(
                obj.get("id"),
                obj.get("name"),
                Double.parseDouble(obj.get("price")),
                obj.get("type"),
                obj.get("compatibleMotherboards"),
                Integer.parseInt(obj.get("powerRequirement"))
            ));
        }
        return cards;
    }

    public List<Motherboard> loadMotherboards() throws IOException {
        List<Motherboard> motherboards = new ArrayList<>();
        List<Map<String, String>> data = jsonHandler.readJsonArray("resources/data/motherboards.json");
        
        for (Map<String, String> obj : data) {
            motherboards.add(new Motherboard(
                obj.get("id"),
                obj.get("name"),
                Double.parseDouble(obj.get("price")),
                obj.get("type"),
                obj.get("socketType"),
                obj.get("formFactor")
            ));
        }
        return motherboards;
    }
}