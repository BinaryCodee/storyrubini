package xyz.binarycodee.storyrpg.system.guis;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.binarycodee.storyrpg.system.managers.EconomyManager;
import xyz.binarycodee.storyrpg.system.utils.ChatUtils;
import xyz.binarycodee.storyrpg.system.utils.PlayerUtils;

public class MainGUI {
    private final Inventory inventory;
    private final Player player;

    public MainGUI(Player player) {
        this.player = player;
        this.inventory = Bukkit.createInventory(null, 27, ChatUtils.colorize("&8 v0.1   &6• &E• &f• &d\uD83D\uDC8E ʀᴜʙɪɴɪ \uD83D\uDC8E&f •&E • &6•"));
        setPlayerHead();
        setBalanceLore();
        fillWithBarrier();
        setCloseItem();
        setCloseItemLore();
        setBuyRubyItem();
        setSellRubyItem();
    }

    public void open() {
        player.openInventory(inventory);
    }

    // Testa Giocatore - Todo 28/10/2023
    private void setPlayerHead() {
        ItemStack head = PlayerUtils.getPlayerHead(player.getName());
        ItemMeta headMeta = head.getItemMeta();
        headMeta.setDisplayName(ChatUtils.colorize("&b&lɪ ᴛᴜᴏɪ ʀᴜʙɪɴɪ"));
        head.setItemMeta(headMeta);
        inventory.setItem(4, head);
    }

    private void setBalanceLore() {
        int balance = EconomyManager.getBalance(player);
        ItemStack item = inventory.getItem(4);

        if (item != null) {
            item = ChatUtils.addLore(item, ChatUtils.colorize("&7"));
            item = ChatUtils.addLore(item, ChatUtils.colorize("&8ℹ • &dʀᴜʙɪɴɪ: &a" + balance + " &d\uD83D\uDC8E"));
            item = ChatUtils.addLore(item, ChatUtils.colorize("&7"));
            inventory.setItem(4, item);
        }
    }

    // Chiudi - Todo 28/10/2023
    public void setCloseItem() {
        ItemStack close = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatUtils.colorize("&c&l✘ &cᴄʜɪᴜᴅɪ"));
        close.setItemMeta(closeMeta);
        inventory.setItem(22, close);
    }

    public void setCloseItemLore() {
        ItemStack close = inventory.getItem(22);

        if (close != null) {
            close = ChatUtils.addLore(close, ChatUtils.colorize("&7"));
            close = ChatUtils.addLore(close, ChatUtils.colorize("&8• &2ᴄʟɪᴄᴋ-ᴅᴇsᴛʀᴏ &7ᴠᴀɪ ᴀʟ &C&Lᴛᴜᴛᴏʀɪᴀʟ"));
            close = ChatUtils.addLore(close, ChatUtils.colorize("&8• &aᴄʟɪᴄᴋ-sɪɴɪsᴛʀᴏ &7ᴘᴇʀ ᴄʜɪᴜᴅᴇʀᴇ ɪʟ &6&lᴍᴇɴᴜ̀"));
            close = ChatUtils.addLore(close, ChatUtils.colorize("&7"));
            inventory.setItem(22, close);
        }
    }

    // Compra & Vendi Rubini - Todo 28/10/2023
    public void setBuyRubyItem() {
        ItemStack buy = new ItemStack(Material.LIME_SHULKER_BOX);
        ItemMeta buyMeta = buy.getItemMeta();
        buyMeta.setDisplayName(ChatUtils.colorize("&a&lᴀᴄǫᴜɪsᴛᴀ ʀᴜʙɪɴɪ"));
        buy.setItemMeta(buyMeta);
        inventory.setItem(11, buy);
    }

    public void setSellRubyItem() {
        ItemStack sell = new ItemStack(Material.RED_SHULKER_BOX);
        ItemMeta sellMeta = sell.getItemMeta();
        sellMeta.setDisplayName(ChatUtils.colorize("&c&lᴠᴇɴᴅɪ ʀᴜʙɪɴɪ"));
        sell.setItemMeta(sellMeta);
        inventory.setItem(15, sell);
    }

    private void fillWithBarrier() {
        ItemStack panel = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);

        for (int i = 0; i < inventory.getSize(); i++) {
            if (i != 4) {
                inventory.setItem(i, panel);
            }
        }
    }

    public static class MainGUIEvents implements Listener {
        @EventHandler
        public void onInventoryClick(InventoryClickEvent event) {
            Player player = (Player) event.getWhoClicked();
            Inventory clickedInventory = event.getClickedInventory();

            if (clickedInventory != null) {
                InventoryHolder holder = clickedInventory.getHolder();
                if (holder instanceof MainGUI) {
                    event.setCancelled(true);

                    if (event.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY || event.getAction() == InventoryAction.HOTBAR_SWAP) {
                        event.setCancelled(true);
                    } else {
                        ItemStack clickedItem = event.getCurrentItem();
                        if (clickedItem != null && (clickedItem.getType() == Material.PLAYER_HEAD || clickedItem.getType() == Material.GRAY_STAINED_GLASS_PANE)) {
                            event.setCancelled(true);
                        }
                        if (clickedItem != null && (clickedItem.getType() == Material.RED_SHULKER_BOX || clickedItem.getType() == Material.LIME_SHULKER_BOX)) {
                            event.setCancelled(true);
                        }
                        if (event.getClick().isRightClick()) {
                            if (clickedItem != null && clickedItem.getType() == Material.RED_STAINED_GLASS_PANE) {
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "dm open tutorial " + player.getName());
                            }
                        } else if (event.getClick().isLeftClick()) {
                            player.closeInventory();
                        }
                    }
                }
            }
        }

        @EventHandler
        public void onInventoryDrag(InventoryDragEvent event) {
            if (event.getInventory().getHolder() instanceof MainGUI) {
                event.setCancelled(true);
            }
        }
    }
}
