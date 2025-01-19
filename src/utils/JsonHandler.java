// utils/JsonHandler.java
package utils;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class JsonHandler {
    // Une implémentation simple sans dépendance externe
    public List<Map<String, String>> readJsonArray(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        List<Map<String, String>> result = new ArrayList<>();
        
        // Parser JSON basique
        StringBuilder currentObject = new StringBuilder();
        boolean inObject = false;
        
        for (String line : lines) {
            line = line.trim();
            if (line.startsWith("{")) {
                inObject = true;
                currentObject = new StringBuilder();
            }
            
            if (inObject) {
                currentObject.append(line);
            }
            
            if (line.endsWith("},") || line.endsWith("}")) {
                inObject = false;
                String objectStr = currentObject.toString();
                result.add(parseJsonObject(objectStr));
            }
        }
        
        return result;
    }
    
    private Map<String, String> parseJsonObject(String jsonStr) {
        Map<String, String> map = new HashMap<>();
        jsonStr = jsonStr.replaceAll("[{}\"]", "");
        String[] pairs = jsonStr.split(",");
        
        for (String pair : pairs) {
            String[] keyValue = pair.split(":");
            if (keyValue.length == 2) {
                String key = keyValue[0].trim();
                String value = keyValue[1].trim();
                map.put(key, value);
            }
        }
        
        return map;
    }

    public void writeJsonArray(List<Map<String, String>> data, String filePath) throws IOException {
        StringBuilder json = new StringBuilder("[\n");
        for (int i = 0; i < data.size(); i++) {
            json.append("  {");
            Map<String, String> obj = data.get(i);
            int j = 0;
            for (Map.Entry<String, String> entry : obj.entrySet()) {
                json.append("\"").append(entry.getKey()).append("\":\"")
                    .append(entry.getValue()).append("\"");
                if (j < obj.size() - 1) json.append(",");
                j++;
            }
            json.append("}");
            if (i < data.size() - 1) json.append(",");
            json.append("\n");
        }
        json.append("]");
        
        Files.write(Paths.get(filePath), json.toString().getBytes());
    }
}