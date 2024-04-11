package xyz.binarycodee.storyrpg.system.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import xyz.binarycodee.storyrpg.system.managers.EconomyManager;
import xyz.binarycodee.storyrpg.system.utils.ChatUtils;

public class PlayerKSListener implements Listener {
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (event.getEntity() instanceof Player) {
            Player victim = (Player) event.getEntity();
            if (victim.getKiller() instanceof Player) {
                Player killer = victim.getKiller();
                EconomyManager.giveRubini(killer, 1);
                killer.sendMessage(ChatUtils.colorize("&6ʜᴀɪ ᴜᴄᴄɪѕᴏ &c" + victim.getName() + " &6ᴇ ʜᴀɪ ɢᴜᴀᴅᴀɢɴᴀᴛᴏ &e&l1 ʀᴜʙɪɴᴏ&c."));

                String message = ChatUtils.colorize("&c%killer%&6 ʜᴀ ᴜᴄᴄɪѕᴏ &c%victim%&6 ᴇ ʜᴀ ɢᴜᴀᴅᴀɢɴᴀᴛᴏ &e&l1 ʀᴜʙɪɴᴏ&c.");
                message = message.replace("%killer%", killer.getName()).replace("%victim%", victim.getName());
                Bukkit.broadcastMessage(message);
            }
        }
    }
}
