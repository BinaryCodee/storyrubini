package xyz.binarycodee.storyrpg.system.placeholders;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import xyz.binarycodee.storyrpg.system.managers.EconomyManager;

public class RubiniHooks extends PlaceholderExpansion {
    public String getIdentifier() {
        return "storyrpg";
    }

    public String getAuthor() {
        return "BinaryCodee";
    }

    public String getVersion() {
        return "1.0";
    }

    public String onPlaceholderRequest(Player player, String identifier) {
        if (player == null) {
            return "";
        }

        if (identifier.equals("rubini")) {
            double balance = EconomyManager.getBalance(player);
            int balanceInt = (int) balance;
            return String.valueOf(balanceInt);
        }
        return null;
    }
}
