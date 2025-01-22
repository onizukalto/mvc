package model.data;

import model.components.*;
import utils.JsonHandler;
import utils.Constants;
import java.util.*;
import java.io.IOException;

public class DataLoader {
    private final JsonHandler jsonHandler;

    public DataLoader() {
        this.jsonHandler = new JsonHandler();
    }

    public List<GraphicsCard> loadGraphicsCards() throws IOException {
        List<GraphicsCard> cards = new ArrayList<>();
        List<Map<String, String>> data = jsonHandler.readJsonArray(Constants.GRAPHICS_CARDS_PATH);
        
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

     public List<Processor> loadProcessors() throws IOException {
        List<Processor> processors = new ArrayList<>();
        List<Map<String, String>> data = jsonHandler.readJsonArray(Constants.PROCESSORS_PATH);
        
        for (Map<String, String> obj : data) {
            processors.add(new Processor(
                obj.get("id"),
                obj.get("name"),
                Double.parseDouble(obj.get("price")),
                obj.get("type"),
                obj.get("socketType"),
                Integer.parseInt(obj.get("tdp")),
                Double.parseDouble(obj.get("frequency"))
            ));
        }
        return processors;
    }

    public List<Ram> loadRam() throws IOException {
        List<Ram> rams = new ArrayList<>();
        List<Map<String, String>> data = jsonHandler.readJsonArray(Constants.RAM_PATH);
        
        for (Map<String, String> obj : data) {
            rams.add(new Ram(
                obj.get("id"),
                obj.get("name"),
                Double.parseDouble(obj.get("price")),
                obj.get("type"),
                obj.get("ramType"),
                Integer.parseInt(obj.get("capacity")),
                Integer.parseInt(obj.get("speed"))
            ));
        }
        return rams;
    }

    public List<PowerSupply> loadPowerSupplies() throws IOException {
        List<PowerSupply> psus = new ArrayList<>();
        List<Map<String, String>> data = jsonHandler.readJsonArray(Constants.POWER_SUPPLIES_PATH);
        
        for (Map<String, String> obj : data) {
            psus.add(new PowerSupply(
                obj.get("id"),
                obj.get("name"),
                Double.parseDouble(obj.get("price")),
                obj.get("type"),
                Integer.parseInt(obj.get("wattage")),
                obj.get("certification"),
                Boolean.parseBoolean(obj.get("modular"))
            ));
        }
        return psus;
    }
    
}