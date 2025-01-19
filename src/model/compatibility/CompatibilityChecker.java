// model/compatibility/CompatibilityChecker.java
package model.compatibility;

import model.components.*;

public class CompatibilityChecker {
    public static boolean isCompatible(Motherboard motherboard, GraphicsCard graphicsCard) {
        return graphicsCard.getCompatibleMotherboards().contains(motherboard.getType());
    }
}