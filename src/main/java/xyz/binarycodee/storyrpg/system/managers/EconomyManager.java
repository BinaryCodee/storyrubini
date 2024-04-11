package xyz.binarycodee.storyrpg.system.managers;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.binarycodee.storyrpg.StoryRubini;

import java.io.File;
import java.io.IOException;

public class EconomyManager {
    private static File dataFile;
    private static FileConfiguration data;
    private static JavaPlugin plugin;

    public static void setupDataFile() {
        dataFile = new File(StoryRubini.getInstance().getDataFolder(), "data.yml");

        if (!dataFile.exists()) {
            dataFile.getParentFile().mkdirs();
            StoryRubini.getInstance().saveResource("data.yml", false);
        }

        data = YamlConfiguration.loadConfiguration(dataFile);
    }

    public static int getBalance(Player player) {
        String playerName = player.getName();
        if (data.contains(playerName)) {
            return data.getInt(playerName);
        }
        return 0;
    }

    public static void resetBalance(Player player) {
        String playerName = player.getName();
        data.set(playerName, 0);
        saveDataFile();
    }

    public static void giveRubini(Player player, int amount) {
        String playerName = player.getName();
        int currentBalance = getBalance(player);
        int newBalance = currentBalance + amount;
        data.set(playerName, newBalance);
        saveDataFile();
    }

    public static void giveRubiniToAllPlayers(int amount) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            giveRubini(player, amount);
        }
    }

    public static void takeRubini(Player player, int amount) {
        String playerName = player.getName();
        int currentBalance = getBalance(player);
        int newBalance = currentBalance - amount;
        if (newBalance < 0) {
            newBalance = 0;
        }
        data.set(playerName, newBalance);
        saveDataFile();
    }

    private static void saveDataFile() {
        try {
            data.save(dataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
