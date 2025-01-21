package model.compatibility;

import model.components.*;
import java.util.List;

public class CompatibilityChecker {
    public static boolean isCompatible(Motherboard motherboard, GraphicsCard graphicsCard) {
        return graphicsCard.getCompatibleMotherboards().contains(motherboard.getType());
    }

    public static boolean isCompatible(Motherboard motherboard, Processor processor) {
        return motherboard.getSocketType().equals(processor.getSocketType());
    }

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

        // Ajout d'une marge de sécurité de 100W pour les autres composants
        totalPower += 100;

        return psu.getWattage() >= totalPower;
    }

    public static String getCompatibilityIssues(List<Component> components) {
        StringBuilder issues = new StringBuilder();

        // Vérification de la présence des composants essentiels
        boolean hasMotherboard = components.stream().anyMatch(c -> c instanceof Motherboard);
        boolean hasCPU = components.stream().anyMatch(c -> c instanceof Processor);
        boolean hasRAM = components.stream().anyMatch(c -> c instanceof Ram);
        boolean hasPSU = components.stream().anyMatch(c -> c instanceof PowerSupply);

        if (!hasMotherboard) issues.append("Carte mère manquante\n");
        if (!hasCPU) issues.append("Processeur manquant\n");
        if (!hasRAM) issues.append("RAM manquante\n");
        if (!hasPSU) issues.append("Alimentation manquante\n");

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