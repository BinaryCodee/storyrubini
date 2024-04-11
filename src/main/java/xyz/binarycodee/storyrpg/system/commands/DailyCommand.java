package xyz.binarycodee.storyrpg.system.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.binarycodee.storyrpg.system.managers.EconomyManager;
import xyz.binarycodee.storyrpg.system.utils.ChatUtils;

public class DailyCommand implements CommandExecutor {
    private final JavaPlugin plugin;

    public DailyCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatUtils.colorize("&cǫᴜᴇѕᴛᴏ ᴄᴏᴍᴀɴᴅᴏ ᴘᴜᴏ' ᴇѕѕᴇʀᴇ ᴇѕᴇɢᴜɪᴛᴏ ѕᴏʟᴏ ᴅᴀ ɢɪᴏᴄᴀᴛᴏʀɪ."));
            return true;
        }
        Player player = (Player) sender;

        if (canReceiveDailyReward(player)) {
            EconomyManager.giveRubini(player, 1);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "crates key give " + player.getName() + " spiran_key 1");

            setLastDailyRewardTimestamp(player);
            sender.sendMessage(ChatUtils.colorize("&aʜᴀɪ ʀɪᴄᴇᴠᴜᴛᴏ ɪʟ ᴘʀᴇᴍɪᴏ ɢɪᴏʀɴᴀʟɪᴇʀᴏ!"));
        } else {
            sender.sendMessage(ChatUtils.colorize("&cʜᴀɪ ɢɪᴀ' ʀɪᴄᴇᴠᴜᴛᴏ ɪʟ ᴘʀᴇᴍɪᴏ ɢɪᴏʀɴᴀʟɪᴇʀᴏ! ᴛᴏʀɴᴀ ᴅᴏᴍᴀɴɪ ᴘᴇʀ ᴜɴ ᴀʟᴛʀᴏ ᴘʀᴇᴍɪᴏ."));
        }

        return true;
    }

    private boolean canReceiveDailyReward(Player player) {
        FileConfiguration config = plugin.getConfig();
        long lastClaimedTimestamp = config.getLong("daily_rewards." + player.getUniqueId(), 0);
        long currentTime = System.currentTimeMillis();
        long oneDayMillis = 24 * 60 * 60 * 1000;

        return (currentTime - lastClaimedTimestamp) >= oneDayMillis;
    }

    private void setLastDailyRewardTimestamp(Player player) {
        FileConfiguration config = plugin.getConfig();
        config.set("daily_rewards." + player.getUniqueId(), System.currentTimeMillis());
        plugin.saveConfig();
    }
}
