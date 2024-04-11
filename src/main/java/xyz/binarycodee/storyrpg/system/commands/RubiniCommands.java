package xyz.binarycodee.storyrpg.system.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.binarycodee.storyrpg.system.guis.MainGUI;
import xyz.binarycodee.storyrpg.system.managers.EconomyManager;
import xyz.binarycodee.storyrpg.system.utils.ChatUtils;

public class RubiniCommands implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("rubini")) {
            if (sender instanceof Player) {
                if (args.length == 0) {
                    Player player = (Player) sender;
                    player.sendMessage(ChatUtils.colorize("&cThis server is running &6&lStoryRubini v1.1 &cby &6@BinaryCodee&e!"));
                    player.sendMessage(ChatUtils.colorize("&cAttualmente in sviluppo, Usa: &7/rubini help&e!"));
                }
                if (args.length == 1 && args[0].equalsIgnoreCase("help")) {
                    Player player = (Player) sender;
                    player.sendMessage(ChatUtils.colorize("&6&lѕᴛᴏʀʏʀᴘɢ &8- &c&lᴄᴏᴍᴀɴᴅɪ"));
                    player.sendMessage(ChatUtils.colorize("&6"));
                    player.sendMessage(ChatUtils.colorize("&4&lAttenzione:"));
                    player.sendMessage(ChatUtils.colorize("&cAttualmente il sistema dei &lRubini&c è"));
                    player.sendMessage(ChatUtils.colorize("&c&nin sviluppo&c, quindi, potrai solo farmarli"));
                    player.sendMessage(ChatUtils.colorize("&cuccidendo i &6&lGiocatori&e!"));
                    player.sendMessage(ChatUtils.colorize("&6"));
                    player.sendMessage(ChatUtils.colorize("&8* &6/rubini help &7-&e ᴍᴏѕᴛʀᴀ ʟᴀ ʟɪѕᴛᴀ ᴅᴇɪ ᴄᴏᴍᴀɴᴅɪ ʀᴜʙɪɴɪ"));
                    player.sendMessage(ChatUtils.colorize("&8* &6/rubini balance &7-&e ᴍᴏѕᴛʀᴀ ɪʟ ѕᴀʟᴅᴏ ᴅᴇɪ ʀᴜʙɪɴɪ"));
                    player.sendMessage(ChatUtils.colorize("&8* &6/rubini pay [player] [quantità] &7-&e ᴘᴀɢᴀ ʀᴜʙɪɴɪ ᴀᴅ ᴜɴ ɢɪᴏᴄᴀᴛᴏʀᴇ"));
                    player.sendMessage(ChatUtils.colorize("&8* &6/rubini admin &7-&e ᴄᴏᴍᴀɴᴅɪ ᴀᴅᴍɪɴ"));
                    player.sendMessage(ChatUtils.colorize("&6"));
                }
                if (args.length == 1 && args[0].equalsIgnoreCase("gui")) {
                    if (sender instanceof Player) {
                        Player player = (Player) sender;
                        MainGUI mainGUI = new MainGUI(player);
                        mainGUI.open();
                    } else {
                        sender.sendMessage(ChatUtils.colorize("&cDevi essere un giocatore per aprire la GUI!"));
                    }
                    return true;
                }
                if (args.length == 1 && args[0].equalsIgnoreCase("admin")) {
                    Player player = (Player) sender;
                    if (player.hasPermission("storyrpg.rubini.admin")) {
                        player.sendMessage(ChatUtils.colorize("&6&lѕᴛᴏʀʏʀᴘɢ &8- &c&lᴄᴏᴍᴀɴᴅɪ ᴀᴅᴍɪɴ"));
                        player.sendMessage(ChatUtils.colorize("&6"));
                        player.sendMessage(ChatUtils.colorize("&8* &6/rubini help &7-&e ᴍᴏѕᴛʀᴀ ʟᴀ ʟɪѕᴛᴀ ᴅᴇɪ ᴄᴏᴍᴀɴᴅɪ ʀᴜʙɪɴɪ"));
                        player.sendMessage(ChatUtils.colorize("&8* &6/rubini balance &7-&e ᴍᴏѕᴛʀᴀ ɪʟ ѕᴀʟᴅᴏ ᴅᴇɪ ʀᴜʙɪɴɪ"));
                        player.sendMessage(ChatUtils.colorize("&8* &6/rubini pay [player] [quantità] &7-&e ᴘᴀɢᴀ ʀᴜʙɪɴɪ ᴀᴅ ᴜɴ ɢɪᴏᴄᴀᴛᴏʀᴇ"));
                        player.sendMessage(ChatUtils.colorize("&8* &6/rubini give [player/all] [quantità] &7-&e ᴅᴏɴᴀ ʀᴜʙɪɴɪ ᴀ ᴜɴ ɢɪᴏᴄᴀᴛᴏʀᴇ ᴏ ᴀ ᴛᴜᴛᴛɪ"));
                        player.sendMessage(ChatUtils.colorize("&8* &6/rubini remove [player] [quantità] &7-&e ʀɪᴍᴜᴏᴠɪ ʀᴜʙɪɴɪ ᴀᴅ ᴜɴ ɢɪᴏᴄᴀᴛᴏʀᴇ"));
                        player.sendMessage(ChatUtils.colorize("&8* &6/rubini reset [player] &7-&e ʀᴇɪᴍᴘᴏѕᴛᴀ ɪʟ ѕᴀʟᴅᴏ ᴅᴇɪ ʀᴜʙɪɴɪ ᴅɪ ᴜɴ ɢɪᴏᴄᴀᴛᴏʀᴇ"));
                        player.sendMessage(ChatUtils.colorize("&8* &6/rubini admin &7-&e ᴄᴏᴍᴀɴᴅɪ ᴀᴅᴍɪɴ"));
                        player.sendMessage(ChatUtils.colorize("&6"));
                    } else {
                        player.sendMessage(ChatUtils.colorize("&cɴᴏɴ ʜᴀɪ ɪʟ ᴘᴇʀᴍᴇѕѕᴏ ᴘᴇʀ ᴜᴛɪʟɪᴢᴢᴀʀᴇ ǫᴜᴇѕᴛᴏ ᴄᴏᴍᴀɴᴅᴏ."));
                    }
                    return true;
                }
                if (args.length == 1 && args[0].equalsIgnoreCase("balance")) {
                    if (sender instanceof Player) {
                        Player player = (Player) sender;
                        int balance = (int) EconomyManager.getBalance(player);
                        player.sendMessage(ChatUtils.colorize("&6ɪ ᴛᴜᴏɪ ʀᴜʙɪɴɪ:: " + balance));
                        return true;
                    } else {
                        sender.sendMessage(ChatUtils.colorize("&cᴅᴇᴠɪ ᴇѕѕᴇʀᴇ ᴜɴ ɢɪᴏᴄᴀᴛᴏʀᴇ ᴘᴇʀ ᴜᴛɪʟɪᴢᴢᴀʀᴇ ǫᴜᴇѕᴛᴏ ᴄᴏᴍᴀɴᴅᴏ."));
                    }
                }
                if (args.length == 3 && args[0].equalsIgnoreCase("pay")) {
                    if (sender instanceof Player) {
                        Player player = (Player) sender;
                        String targetPlayerName = args[1];
                        double amount;

                        try {
                            amount = Double.parseDouble(args[2]);
                        } catch (NumberFormatException e) {
                            player.sendMessage(ChatUtils.colorize("&cɪɴѕᴇʀɪѕᴄɪ ᴜɴ ɪᴍᴘᴏʀᴛᴏ ᴠᴀʟɪᴅᴏ."));
                            return true;
                        }

                        Player targetPlayer = Bukkit.getPlayer(targetPlayerName);

                        if (targetPlayer == null) {
                            player.sendMessage(ChatUtils.colorize("&cɪʟ ɢɪᴏᴄᴀᴛᴏʀᴇ ѕᴘᴇᴄɪꜰɪᴄᴀᴛᴏ ɴᴏɴ È ᴏɴʟɪɴᴇ ᴏ ɴᴏɴ ᴇѕɪѕᴛᴇ."));
                            return true;
                        }

                        if (amount <= 0) {
                            player.sendMessage(ChatUtils.colorize("&cʟ'ɪᴍᴘᴏʀᴛᴏ ᴅᴇᴠᴇ ᴇѕѕᴇʀᴇ ѕᴜᴘᴇʀɪᴏʀᴇ ᴀ 0."));
                            return true;
                        }

                        int playerBalance = (int) EconomyManager.getBalance(player);

                        if (playerBalance < amount) {
                            player.sendMessage(ChatUtils.colorize("&cɴᴏɴ ʜᴀɪ ᴀʙʙᴀѕᴛᴀɴᴢᴀ ʀᴜʙɪɴɪ ᴘᴇʀ ǫᴜᴇѕᴛᴀ ᴛʀᴀɴѕᴀᴢɪᴏɴᴇ."));
                            return true;
                        }

                        EconomyManager.takeRubini(player, (int) amount);
                        EconomyManager.giveRubini(targetPlayer, (int) amount);

                        player.sendMessage(ChatUtils.colorize("&aʜᴀɪ ᴘᴀɢᴀᴛᴏ " + amount + " ʀᴜʙɪɴɪ ᴀ " + targetPlayer.getName()));
                        targetPlayer.sendMessage(ChatUtils.colorize("&aʜᴀɪ ʀɪᴄᴇᴠᴜᴛᴏ " + amount + " ʀᴜʙɪɴɪ ᴅᴀ " + player.getName()));

                        return true;
                    } else {
                        sender.sendMessage(ChatUtils.colorize("&cᴅᴇᴠɪ ᴇѕѕᴇʀᴇ ᴜɴ ɢɪᴏᴄᴀᴛᴏʀᴇ ᴘᴇʀ ᴜᴛɪʟɪᴢᴢᴀʀᴇ ǫᴜᴇѕᴛᴏ ᴄᴏᴍᴀɴᴅᴏ."));
                    }
                }
                if (args.length == 3 && args[0].equalsIgnoreCase("remove")) {
                    Player player = (Player) sender;
                    double amount = 0;
                    if (sender.hasPermission("storyrpg.rubini.admin")) {
                        String targetPlayerName = args[1];

                        try {
                            amount = Double.parseDouble(args[2]);
                        } catch (NumberFormatException e) {
                            sender.sendMessage(ChatUtils.colorize("&cɪɴѕᴇʀɪѕᴄɪ ᴜɴ ɪᴍᴘᴏʀᴛᴏ ᴠᴀʟɪᴅᴏ."));
                            return true;
                        }

                        if (amount <= 0) {
                            sender.sendMessage(ChatUtils.colorize("&cʟ'ɪᴍᴘᴏʀᴛᴏ ᴅᴇᴠᴇ ᴇѕѕᴇʀᴇ ѕᴜᴘᴇʀɪᴏʀᴇ ᴀ 0."));
                            return true;
                        }

                        if (targetPlayerName.equalsIgnoreCase("all")) {
                            int playerBalance = (int) EconomyManager.getBalance(player);

                            if (playerBalance >= amount) {
                                EconomyManager.takeRubini(player, (int) amount);
                            }

                            sender.sendMessage(ChatUtils.colorize("&aʜᴀɪ ʀɪᴍᴏѕѕᴏ " + amount + " ʀᴜʙɪɴɪ ᴅᴀ ᴛᴜᴛᴛɪ ɪ ɢɪᴏᴄᴀᴛᴏʀɪ ᴏɴʟɪɴᴇ."));
                        } else {
                            Player targetPlayer = Bukkit.getPlayer(targetPlayerName);
                            if (targetPlayer == null) {
                                sender.sendMessage(ChatUtils.colorize("&cɪʟ ɢɪᴏᴄᴀᴛᴏʀᴇ ѕᴘᴇᴄɪꜰɪᴄᴀᴛᴏ ɴᴏɴ È ᴏɴʟɪɴᴇ ᴏ ɴᴏɴ ᴇѕɪѕᴛᴇ."));
                                return true;
                            }

                            int playerBalance = (int) EconomyManager.getBalance(targetPlayer);

                            if (playerBalance < amount) {
                                sender.sendMessage(ChatUtils.colorize("&cɪʟ ɢɪᴏᴄᴀᴛᴏʀᴇ ɴᴏɴ ʜᴀ ᴀʙʙᴀѕᴛᴀɴᴢᴀ ʀᴜʙɪɴɪ ᴘᴇʀ ǫᴜᴇѕᴛᴀ ᴛʀᴀɴѕᴀᴢɪᴏɴᴇ."));
                                return true;
                            }

                            EconomyManager.takeRubini(targetPlayer, (int) amount);

                            sender.sendMessage(ChatUtils.colorize("&aʜᴀɪ ʀɪᴍᴏѕѕᴏ " + amount + " ʀᴜʙɪɴɪ ᴀ " + targetPlayer.getName()));
                            targetPlayer.sendMessage(ChatUtils.colorize("&cʜᴀɪ ᴘᴇʀѕᴏ " + amount + " ʀᴜʙɪɴɪ ᴀ ᴄᴀᴜѕᴀ ᴅɪ ᴜɴ'ᴀᴢɪᴏɴᴇ ᴅɪ ᴀᴍᴍɪɴɪѕᴛʀᴀᴢɪᴏɴᴇ."));
                        }
                    }
                }
                if (args.length == 3 && args[0].equalsIgnoreCase("give")) {
                    if (sender.hasPermission("storyrpg.rubini.admin")) {
                        String targetPlayerName = args[1];
                        double amount;

                        try {
                            amount = Double.parseDouble(args[2]);
                        } catch (NumberFormatException e) {
                            sender.sendMessage(ChatUtils.colorize("&cɪɴѕᴇʀɪѕᴄɪ ᴜɴ ɪᴍᴘᴏʀᴛᴏ ᴠᴀʟɪᴅᴏ."));
                            return true;
                        }

                        if (amount <= 0) {
                            sender.sendMessage(ChatUtils.colorize("&cʟ'ɪᴍᴘᴏʀᴛᴏ ᴅᴇᴠᴇ ᴇѕѕᴇʀᴇ ѕᴜᴘᴇʀɪᴏʀᴇ ᴀ 0."));
                            return true;
                        }

                        if (targetPlayerName.equalsIgnoreCase("all")) {
                            for (Player player : Bukkit.getOnlinePlayers()) {
                                EconomyManager.giveRubini(player, (int) amount);
                            }

                            sender.sendMessage(ChatUtils.colorize("&aʜᴀɪ ᴅᴀᴛᴏ " + amount + " ʀᴜʙɪɴɪ ᴀ ᴛᴜᴛᴛɪ ɪ ɢɪᴏᴄᴀᴛᴏʀɪ ᴏɴʟɪɴᴇ."));
                        } else {
                            Player targetPlayer = Bukkit.getPlayer(targetPlayerName);

                            if (targetPlayer == null) {
                                sender.sendMessage(ChatUtils.colorize("&cɪʟ ɢɪᴏᴄᴀᴛᴏʀᴇ ѕᴘᴇᴄɪꜰɪᴄᴀᴛᴏ ɴᴏɴ È ᴏɴʟɪɴᴇ ᴏ ɴᴏɴ ᴇѕɪѕᴛᴇ."));
                                return true;
                            }

                            EconomyManager.giveRubini(targetPlayer, (int) amount);

                            sender.sendMessage(ChatUtils.colorize("&aʜᴀɪ ᴅᴀᴛᴏ " + amount + " ʀᴜʙɪɴɪ ᴀ " + targetPlayer.getName()));
                            targetPlayer.sendMessage(ChatUtils.colorize("&aʜᴀɪ ʀɪᴄᴇᴠᴜᴛᴏ " + amount + " ʀᴜʙɪɴɪ ᴅᴀ ᴜɴ ᴀᴍᴍɪɴɪѕᴛʀᴀᴛᴏʀᴇ."));
                        }
                        return true;
                    } else {
                        sender.sendMessage(ChatUtils.colorize("&cɴᴏɴ ʜᴀɪ ɪ ᴘᴇʀᴍᴇѕѕɪ ᴘᴇʀ ᴜᴛɪʟɪᴢᴢᴀʀᴇ ǫᴜᴇѕᴛᴏ ᴄᴏᴍᴀɴᴅᴏ."));
                    }
                }
            }
        }
        return true;
    }
}
