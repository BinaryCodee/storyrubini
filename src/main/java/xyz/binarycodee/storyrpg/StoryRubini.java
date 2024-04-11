package xyz.binarycodee.storyrpg;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.binarycodee.storyrpg.system.commands.DailyCommand;
import xyz.binarycodee.storyrpg.system.commands.RubiniCommands;
import xyz.binarycodee.storyrpg.system.guis.MainGUI;
import xyz.binarycodee.storyrpg.system.listeners.PlayerKSListener;
import xyz.binarycodee.storyrpg.system.managers.EconomyManager;
import xyz.binarycodee.storyrpg.system.placeholders.RubiniHooks;

public class StoryRubini extends JavaPlugin {
    private static StoryRubini instance;

    public void onEnable() {
        instance = this;

        getCommand("daily").setExecutor(new DailyCommand(this));
        getCommand("rubini").setExecutor(new RubiniCommands());
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerKSListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new MainGUI.MainGUIEvents(), this);

        EconomyManager.setupDataFile();

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new RubiniHooks().register();
        }
    }

    public static StoryRubini getInstance() {
        return instance;
    }
}
