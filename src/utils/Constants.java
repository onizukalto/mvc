package utils;

public class Constants {
    // Chemins des fichiers
    public static final String GRAPHICS_CARDS_PATH = "resources/data/graphics_cards.json";
    public static final String MOTHERBOARDS_PATH = "resources/data/motherboards.json";
    public static final String PROCESSORS_PATH = "resources/data/processors.json";
    public static final String RAM_PATH = "resources/data/ram.json";
    public static final String POWER_SUPPLIES_PATH = "resources/data/power_supplies.json";
    
    // Messages d'erreur
    public static final String ERROR_FILE_NOT_FOUND = "Fichier non trouvé : ";
    public static final String ERROR_INVALID_INPUT = "Entrée invalide";
    public static final String ERROR_COMPATIBILITY = "Problème de compatibilité : ";
    public static final String ERROR_POWER_INSUFFICIENT = "Alimentation insuffisante : ";
    
    // Messages système
    public static final String WELCOME_MESSAGE = "Bienvenue dans le configurateur PC";
    public static final String GOODBYE_MESSAGE = "Merci d'avoir utilisé notre configurateur et pour votre achat !";
    
    private Constants() {
        // Empêche l'instanciation
    }
}