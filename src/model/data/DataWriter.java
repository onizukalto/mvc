package model.data;

import model.components.Component;
import utils.JsonHandler;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class DataWriter {
    private final JsonHandler jsonHandler;

    public DataWriter() {
        this.jsonHandler = new JsonHandler();
    }

    public void saveCart(List<Component> items, String filepath) throws IOException {
        List<Map<String, String>> jsonData = new ArrayList<>();
        
        for (Component item : items) {
            Map<String, String> componentData = new HashMap<>();
            componentData.put("id", item.getId());
            componentData.put("name", item.getName());
            componentData.put("price", String.valueOf(item.getPrice()));
            componentData.put("type", item.getType());
            jsonData.add(componentData);
        }

        jsonHandler.writeJsonArray(jsonData, filepath);
    }
}