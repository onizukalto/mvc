package utils;

/**
 * Classe de constantes centralisées pour l'application de configuration de PC.
 * Contient les chemins de fichiers, messages d'erreur et messages système.
 */
public class Constants {
    // Chemins des fichiers
    /**
     * Chemin vers le fichier des cartes graphiques.
     */
    public static final String GRAPHICS_CARDS_PATH = "resources/data/graphics_cards.json";
    
    /**
     * Chemin vers le fichier des cartes mères.
     */
    public static final String MOTHERBOARDS_PATH = "resources/data/motherboards.json";
    
    /**
     * Chemin vers le fichier des processeurs.
     */
    public static final String PROCESSORS_PATH = "resources/data/processors.json";
    
    /**
     * Chemin vers le fichier des barrettes RAM.
     */
    public static final String RAM_PATH = "resources/data/ram.json";
    
    /**
     * Chemin vers le fichier des alimentations.
     */
    public static final String POWER_SUPPLIES_PATH = "resources/data/power_supplies.json";
    
    // Messages d'erreur
    /**
     * Message d'erreur pour un fichier introuvable.
     */
    public static final String ERROR_FILE_NOT_FOUND = "Fichier non trouvé : ";
    
    /**
     * Message d'erreur pour une entrée invalide.
     */
    public static final String ERROR_INVALID_INPUT = "Entrée invalide";
    
    /**
     * Message d'erreur pour un problème de compatibilité.
     */
    public static final String ERROR_COMPATIBILITY = "Problème de compatibilité : ";
    
    /**
     * Message d'erreur pour une alimentation insuffisante.
     */
    public static final String ERROR_POWER_INSUFFICIENT = "Alimentation insuffisante : ";
    
    // Messages système
    /**
     * Message de bienvenue affiché à l'utilisateur.
     */
    public static final String WELCOME_MESSAGE = "Bienvenue dans le configurateur PC";
    
    /**
     * Message d'adieu affiché à l'utilisateur.
     */
    public static final String GOODBYE_MESSAGE = "Merci d'avoir utilisé notre configurateur et pour votre achat !";
    
    /**
     * Constructeur privé pour empêcher l'instanciation de la classe.
     */
    private Constants() {
        // Empêche l'instanciation
    }
}
