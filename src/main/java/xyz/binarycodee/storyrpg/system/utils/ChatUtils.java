package xyz.binarycodee.storyrpg.system.utils;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ChatUtils {
    public static String colorize(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static ItemStack addLore(ItemStack item, String lore) {
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            List<String> itemLore = meta.getLore();
            if (itemLore == null) {
                itemLore = new ArrayList<>();
            }
            itemLore.add(lore);
            meta.setLore(itemLore);
            item.setItemMeta(meta);
        }

        return item;
    }
}