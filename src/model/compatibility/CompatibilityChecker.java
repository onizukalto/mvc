package model.compatibility;

import model.components.*;
import java.util.List;

/**
 * Gestionnaire de vérification de compatibilité entre les composants PC.
 * Fournit des méthodes statiques pour vérifier la compatibilité des différents composants.
 */
public class CompatibilityChecker {
    
    /**
     * Vérifie la compatibilité entre une carte mère et une carte graphique.
     * 
     * @param motherboard Carte mère à vérifier
     * @param graphicsCard Carte graphique à vérifier
     * @return Vrai si les composants sont compatibles, faux sinon
     */
    public static boolean isCompatible(Motherboard motherboard, GraphicsCard graphicsCard) {
        return graphicsCard.getCompatibleMotherboards().contains(motherboard.getType());
    }

    /**
     * Vérifie la compatibilité entre une carte mère et un processeur.
     * 
     * @param motherboard Carte mère à vérifier
     * @param processor Processeur à vérifier
     * @return Vrai si les composants sont compatibles, faux sinon
     */
    public static boolean isCompatible(Motherboard motherboard, Processor processor) {
        return motherboard.getSocketType().equals(processor.getSocketType());
    }

    /**
     * Vérifie si l'alimentation est suffisante pour les composants sélectionnés.
     * 
     * @param psu Alimentation à vérifier
     * @param components Liste des composants à alimenter
     * @return Vrai si l'alimentation est suffisante, faux sinon
     */
    public static boolean isCompatible(PowerSupply psu, List<Component> components) {
        int totalPower = components.stream()
            .filter(c -> c instanceof GraphicsCard)
            .mapToInt(c -> ((GraphicsCard) c).getPowerRequirement())
            .sum();

        // Ajout de la consommation du processeur s'il y en a un
        totalPower += components.stream()
            .filter(c -> c instanceof Processor)
            .mapToInt(c -> ((Processor) c).getTdp())
            .sum();

        totalPower += 100;

        return psu.getWattage() >= totalPower;
    }

    /**
     * Récupère les problèmes de compatibilité dans une liste de composants.
     * 
     * @param components Liste des composants à vérifier
     * @return Chaîne contenant les problèmes de compatibilité, vide si aucun problème
     */
    public static String getCompatibilityIssues(List<Component> components) {
        StringBuilder issues = new StringBuilder();

        boolean hasMotherboard = components.stream().anyMatch(c -> c instanceof Motherboard);
        boolean hasCPU = components.stream().anyMatch(c -> c instanceof Processor);
        boolean hasPSU = components.stream().anyMatch(c -> c instanceof PowerSupply);


        // Vérifications spécifiques si tous les composants essentiels sont présents
        if (hasMotherboard && hasCPU) {
            Motherboard mb = (Motherboard) components.stream()
                .filter(c -> c instanceof Motherboard)
                .findFirst()
                .get();
            
            Processor cpu = (Processor) components.stream()
                .filter(c -> c instanceof Processor)
                .findFirst()
                .get();

            if (!isCompatible(mb, cpu)) {
                issues.append("Le socket du processeur n'est pas compatible avec la carte mère\n");
            }
        }

        // Vérification de l'alimentation
        if (hasPSU) {
            PowerSupply psu = (PowerSupply) components.stream()
                .filter(c -> c instanceof PowerSupply)
                .findFirst()
                .get();

            if (!isCompatible(psu, components)) {
                issues.append("L'alimentation n'est pas assez puissante pour cette configuration\n");
            }
        }

        return issues.toString();
    }
}