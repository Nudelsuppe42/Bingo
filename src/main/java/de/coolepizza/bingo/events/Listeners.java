package de.coolepizza.bingo.events;


import de.coolepizza.bingo.Bingo;
import de.coolepizza.bingo.manager.BingoManager;
import de.coolepizza.bingo.manager.BingoSettings;
import de.coolepizza.bingo.team.Team;
import de.coolepizza.bingo.utils.ItemBuilder;
import de.coolepizza.bingo.utils.ScoreboardUtils;
import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;

public class Listeners implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        ScoreboardUtils.setCurrentScoreboard(e.getPlayer(), "§lBTE GERMANY BINGO");
        Bingo.getBingoManager().getTeamManager().initPlayer(e.getPlayer());
        e.setJoinMessage("§a» §7" + e.getPlayer().getName() + "");
        e.getPlayer().setPlayerListHeader("§lBTE GERMANY BINGO");
        if (Bingo.getBingoManager().bingoState == BingoManager.BingoState.SETTINGS) {
            if(e.getPlayer().hasPermission("bingo.admin")) {
                e.getPlayer().getInventory().clear();
                e.getPlayer().getInventory().addItem(new ItemBuilder(Material.NETHER_STAR).setDisplayname("§9Spiel Einstellungen").build());
            }
            World w = Bukkit.getWorld("world");
            int y = w.getHighestBlockYAt((int) w.getSpawnLocation().getX(), (int) w.getSpawnLocation().getZ());
            e.getPlayer().teleport(new Location(w, (int) w.getSpawnLocation().getX() + 5, y - 1, (int) w.getSpawnLocation().getZ() + 5));
        } else if (Bingo.getBingoManager().bingoState == BingoManager.BingoState.TEAM_JOIN) {
            e.getPlayer().getInventory().clear();
            e.getPlayer().getInventory().addItem(new ItemBuilder(Material.WHITE_BED).setDisplayname("§9Teamauswahl").build());
            if (e.getPlayer().hasPermission("bingo.admin")) {
                e.getPlayer().getInventory().setItem(8, new ItemBuilder(Material.LIME_DYE).setDisplayname("§aRunde starten").build());
            }
        }
        if (Bingo.getInstance().wasReset()) {
            World w = Bukkit.getWorld("world");
            int spawnx = (int) w.getSpawnLocation().getX();
            int spawnz = (int) w.getSpawnLocation().getZ();

            if (Bingo.getBingoManager().bingoState != BingoManager.BingoState.INGAME) {
                int y = w.getHighestBlockYAt(spawnx, spawnz);
                e.getPlayer().teleport(new Location(w, spawnx + 5, y - 1, spawnz + 5));
            }
            Team t = Bingo.getBingoManager().getTeamManager().getTeamFromPlayer(e.getPlayer());
            if (t != Team.SPECTATOR) {
                Bingo.getBingoManager().getItemManager().updateScoreboard(t);
            }
        } else {
            if (e.getPlayer().hasPermission("bingo.admin")) {
                e.getPlayer().sendMessage("§aWenn du die Welt zurücksetzen willst gebe /reset ein!");
            }
        }
        if (Bingo.getBingoManager().getTeamManager().getTeamFromPlayer(e.getPlayer())== Team.SPECTATOR && Bingo.getBingoManager().bingoState == BingoManager.BingoState.INGAME){
            e.getPlayer().sendMessage("§7Du bist nun Spectator!");
        }

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage("§a« §7" + e.getPlayer().getName() + "");
        if (Bingo.getBingoManager().getTeamManager().getTeamFromPlayer(e.getPlayer()) != Team.SPECTATOR && Bingo.getBingoManager().bingoState != BingoManager.BingoState.INGAME) {
            Bingo.getBingoManager().getTeamManager().setTeam(e.getPlayer(), Team.SPECTATOR);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (Bingo.getTimer().isPaused()) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if(Bingo.getTimer().isPaused()) {
            e.setFormat("§a" + e.getPlayer().getName() + "§7» " + e.getMessage());
            e.setCancelled(false);
        }else{
            Team team = Bingo.getBingoManager().getTeamManager().getTeamFromPlayer(e.getPlayer());
            Bingo.getBingoManager().getTeamManager().getPlayersInTeam(team).forEach(player -> {
                Bukkit.getPlayer(player).sendMessage("§9Teamchat§7» §a" +  Bukkit.getPlayer(player).getName() + "§7:" + e.getMessage());
            });
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onDamage(InventoryClickEvent e) {
        if (Bingo.getTimer().isPaused()) {
            e.setCancelled(true);
        }else if(!Bingo.getBingoManager().getBingosettings().isDamage()) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        if (Bingo.getTimer().isPaused()) {
            e.setCancelled(true);
        } else {
            e.setCancelled(false);
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if (Bingo.getTimer().isPaused()) {
            e.setCancelled(true);
        } else {
            e.setCancelled(false);
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (e.getItem() == null) {
            return;
        }
        if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§9Spiel Einstellungen") && Bingo.getBingoManager().bingoState == BingoManager.BingoState.SETTINGS) {
            Bingo.getBingoManager().getBingosettings().openSettingsInventory(e.getPlayer());
            e.setCancelled(true);
        } else if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§9Teamauswahl") && Bingo.getBingoManager().bingoState == BingoManager.BingoState.TEAM_JOIN) {
            Bingo.getBingoManager().getTeamManager().openTeamGUI(e.getPlayer());
            e.setCancelled(true);
        } else if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aRunde starten") && Bingo.getBingoManager().bingoState == BingoManager.BingoState.TEAM_JOIN) {
            Bingo.getBingoManager().startIngameState();
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockBreak(PlayerDropItemEvent e) {
        if (Bingo.getTimer().isPaused()) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPickup(EntityPickupItemEvent e) {
        if (Bingo.getTimer().isPaused()) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onSpawn(EntitySpawnEvent e) {
        if (Bingo.getTimer().isPaused()) {
            if (e.getEntityType() != EntityType.PLAYER)
                e.setCancelled(true);
        }
    }


    @EventHandler
    public void onFoodChange(FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        if (e.getView().getTitle() == "§9Bingo §7>> §9Einstellungen") {
            e.setCancelled(true);
            ItemStack itemStack = e.getCurrentItem();
            Player player = (Player) e.getWhoClicked();

            if (itemStack != null) {
                String local = itemStack.getItemMeta().getLocalizedName();
                if (local.equalsIgnoreCase("max")) {
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 1, 1);
                }

                if (itemStack.getType() == Material.LIME_DYE) {
                    Bingo.getBingoManager().startTeamState();
                    return;
                } else if (itemStack.getType() == Material.IRON_SWORD) {
                    Bingo.getBingoManager().getBingosettings().switchDamage(player);
                } else if (itemStack.getType() == Material.CHEST_MINECART) {
                    Bingo.getBingoManager().getBingosettings().switchBackpack(player);
                } else if (itemStack.getType() == Material.COMPASS) {
                    Bingo.getBingoManager().getBingosettings().switchTtp(player);
                }

                if (local.equalsIgnoreCase("maxplayers+")) {
                    Bingo.getBingoManager().getBingosettings().addMaxPlayers(player);
                } else if (local.equalsIgnoreCase("maxplayers-")) {
                    Bingo.getBingoManager().getBingosettings().removeMaxPlayer(player);
                } else if (local.equalsIgnoreCase("items-")) {
                    Bingo.getBingoManager().getBingosettings().removeItems(player);
                } else if (local.equalsIgnoreCase("items+")) {
                    Bingo.getBingoManager().getBingosettings().addItems(player);
                } else if (local.startsWith("dif_")) {
                    BingoSettings.BingoDifficulty difficulty = null;
                    String dif = local.replace("dif_", "");
                    if (dif.equalsIgnoreCase("NORMAL")) {
                        difficulty = BingoSettings.BingoDifficulty.NORMAl;
                    } else if (dif.equalsIgnoreCase("HARD")) {
                        difficulty = BingoSettings.BingoDifficulty.HARD;
                    } else if (dif.equalsIgnoreCase("EASY")) {
                        difficulty = BingoSettings.BingoDifficulty.EASY;
                    }
                    Bingo.getBingoManager().getBingosettings().setDifficulty(player, difficulty);
                }
            }
        } else if (e.getView().getTitle().equalsIgnoreCase("§9Teamauswahl")) {
            if (e.getCurrentItem() != null) {
                Team team = Team.valueOf(e.getCurrentItem().getItemMeta().getLocalizedName());
                Team playerteam = Bingo.getBingoManager().getTeamManager().getTeamFromPlayer((Player) e.getWhoClicked());

                if (team.getTeamid() == playerteam.getTeamid()) {
                    e.getWhoClicked().sendMessage("§cDu bist bereits in dem Team!");
                    ((Player) e.getWhoClicked()).playSound(e.getWhoClicked().getLocation(), Sound.BLOCK_ANVIL_USE, 1, 1);
                    e.getWhoClicked().closeInventory();
                    return;
                }
                if (Bingo.getBingoManager().getTeamManager().getPlayersInTeam(team).size() >= Bingo.getBingoManager().getBingosettings().getMaxplayersinteam()) {
                    e.getWhoClicked().sendMessage("§cDas Team ist voll!");
                    ((Player) e.getWhoClicked()).playSound(e.getWhoClicked().getLocation(), Sound.BLOCK_ANVIL_BREAK, 1, 1);
                    e.getWhoClicked().closeInventory();
                    return;
                }

                Bingo.getBingoManager().getTeamManager().setTeam((Player) e.getWhoClicked(), team);
                e.getWhoClicked().sendMessage("§aDu bist jetz in Team " + team.getTeamid() + " !");
                ((Player) e.getWhoClicked()).playSound(e.getWhoClicked().getLocation(), Sound.BLOCK_NOTE_BLOCK_BIT, 1, 1);
                e.getWhoClicked().closeInventory();

            }
        } else if (e.getView().getTitle().equals("§9Bingo Items")) {
            e.setCancelled(true);
        } else if (e.getView().getTitle().equals(ChatColor.BLUE+"Team Backpack")) {
            e.setCancelled(false);
        }
    }

    @EventHandler
    public void onInventory(InventoryCloseEvent e) {
        if(e.getView().getTitle().equals(ChatColor.BLUE+"Team Backpack")) {
            Team team = Bingo.getBingoManager().getTeamManager().getTeamFromPlayer((Player) e.getPlayer());
            team.updateBackpack(e.getInventory().getContents());
        }
    }

}
