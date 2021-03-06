package de.coolepizza.bingo.manager;

import de.coolepizza.bingo.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class BingoSettings {
    private int MAX_PLAYERS = 8;

    private int maxplayersinteam;
    private int items;
    private BingoDifficulty difficulty;
    private boolean damage;
    private boolean backpack;
    private boolean ttp;

    public BingoSettings(int maxplayersinteam, int items, BingoDifficulty difficulty) {
        this.maxplayersinteam = maxplayersinteam;
        this.items = items;
        this.difficulty = difficulty;
        damage = false;
        backpack = true;
        ttp = false;
        System.out.println("Creating BingoSettings");
    }
    public void openSettingsInventory(Player player){
        Inventory settings = Bukkit.createInventory(null ,9*5 , "§9Bingo §7>> §9Einstellungen");
        for (int i = 0; i < 9*5; i++) {
                settings.setItem(i  , new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setDisplayname(" ").build());
        }
        settings.setItem(19 , new ItemBuilder(Material.WHITE_BED).setDisplayname("§9Maximale Teamgröße").setLore("§7Gerade auf " + maxplayersinteam + " Spieler").build());
        settings.setItem(20 , new ItemBuilder(Material.CRAFTING_TABLE).setDisplayname("§9Items").setLore("§7Gerade auf " + items + " Items").build());
        settings.setItem(21 , new ItemBuilder(Material.NETHER_STAR).setDisplayname("§9Schwierigkeit der Items").setLore("§7Gerade auf "  + difficulty.name()).build());

        settings.setItem(22 , new ItemBuilder(Material.IRON_SWORD).setDisplayname("§9Schaden").setLore("§7Gerade auf "+ (damage?"AUS":"AN")).build());
        settings.setItem(23 , new ItemBuilder(Material.CHEST_MINECART).setDisplayname("§9Backpack").setLore("§7Gerade auf "+ (backpack?"AN":"AUS")).build());
        settings.setItem(24 , new ItemBuilder(Material.COMPASS).setDisplayname("§9Team Teleport").setLore("§7Gerade auf "+ (ttp?"AN":"AUS")).build());

        settings.setItem(26 , new ItemBuilder(Material.LIME_DYE).setDisplayname("§aEinstellungen Bestätigen").setLore("§7Teamauswahl starten!").build());

        addButtons(settings);

        player.openInventory(settings);
        player.updateInventory();
    }
    public void addButtons(Inventory inv){
        int players_next = maxplayersinteam+1;
        int players_last = maxplayersinteam-1;

        int items_next = items+3;
        int items_last = items-3;


        if (!(maxplayersinteam >= MAX_PLAYERS)){
            addButton("§9+1 (Dann " + players_next + ")" , 10 , inv , "maxplayers+");
        }else {
            addButton("§cMaximal Wert (" + maxplayersinteam +")" , 10 , inv , "max");

        }
        if (maxplayersinteam >= 2){
            addButton("§9-1 (Dann " + players_last + ")" , 28 , inv , "maxplayers-");
        }else {
            addButton("§cMinimaler Wert (" + maxplayersinteam +")" , 28 , inv , "max");

        }

        if (items != 3){
            addButton("§9-3 (Dann " + items_last + ")" , 29 , inv , "items-");
        }else {
            addButton("§cMinimaler Wert (" + items +")" , 29 , inv , "max");

        }
        if (items != 24){
            addButton("§9+3 (Dann " + items_next + ")" , 11 , inv , "items+");
        }else {
            addButton("§cMaximal Wert (" + items +")", 11 , inv , "max");
        }

        if (items != 3){
            addButton("§9-3 (Dann " + items_last + ")" , 29 , inv , "items-");
        }else {
            addButton("§cMinimaler Wert (" + items +")" , 29 , inv , "max");

        }
        if (items != 24){
            addButton("§9+3 (Dann " + items_next + ")" , 11 , inv , "items+");
        }else {
            addButton("§cMaximal Wert (" + items +")" , 11 , inv , "max");
        }

        if (difficulty == BingoDifficulty.NORMAl ){
            addButton("§9Schwieriger (Dann " + Difficulty.HARD.name() + ")" , 12 , inv , "dif_" +Difficulty.HARD.name() );
            addButton("§9Einfacher (Dann " + Difficulty.EASY.name() + ")" , 30 , inv , "dif_" +Difficulty.EASY.name() );
        }else if (difficulty == BingoDifficulty.EASY ){
            addButton("§9Schwieriger (Dann " + Difficulty.NORMAL.name() + ")" , 12 ,  inv , "dif_" + Difficulty.NORMAL.name());
            addButton("§cAm Einfachsten (" + Difficulty.EASY.name() + ")" , 30 , inv , "max");
        }else if (difficulty == BingoDifficulty.HARD ){
            addButton("§cAm Schwierigsten (" + Difficulty.HARD.name() + ")" , 12 , inv , "max");
            addButton("§9Einfacher (Dann " + Difficulty.NORMAL.name() + ")" , 30 , inv , "dif_" +Difficulty.NORMAL.name() );

        }


    }
    public void addButton(String name ,  int slot , Inventory inv , String local){
        if (local == "max"){
            inv.setItem(slot, new ItemBuilder(Material.CRIMSON_BUTTON).setDisplayname(name).setLocalizedName(local).build());
        }else {
            inv.setItem(slot, new ItemBuilder(Material.OAK_BUTTON).setDisplayname(name).setLocalizedName(local).build());
        }
    }

    public void addMaxPlayers(Player player) {
        maxplayersinteam++;
        openSettingsInventory(player);
        player.playSound(player.getLocation() , Sound.BLOCK_NOTE_BLOCK_BIT , 1 ,1);
    }
    public void removeMaxPlayer(Player player) {
        maxplayersinteam--;
        openSettingsInventory(player);
        player.playSound(player.getLocation() , Sound.BLOCK_NOTE_BLOCK_BIT , 1 ,1);
    }
    public void addItems(Player player) {
        items = items+3;
        openSettingsInventory(player);
        player.playSound(player.getLocation() , Sound.BLOCK_NOTE_BLOCK_BIT , 1 ,1);
    }
    public void removeItems(Player player) {
        items = items-3;
        openSettingsInventory(player);
        player.playSound(player.getLocation() , Sound.BLOCK_NOTE_BLOCK_BIT , 1 ,1);
    }
    public void setDifficulty(Player player , BingoDifficulty bingoDifficulty) {
        difficulty = bingoDifficulty;
        openSettingsInventory(player);
        player.playSound(player.getLocation() , Sound.BLOCK_NOTE_BLOCK_BIT , 1 ,1);
    }
    public void setItems(int items) {
        this.items = items;
    }
    public int getMaxplayersinteam() {
        return maxplayersinteam;
    }
    public int getItems() {
        return items;
    }
    public BingoDifficulty getDifficulty() {
        return difficulty;
    }
    public boolean isDamage() {
        return damage;
    }
    public void setDamage(boolean damage) {
        this.damage = damage;
    }
    public boolean isBackpack() {
        return backpack;
    }
    public void setBackpack(boolean backpack) {
        this.backpack = backpack;
    }
    public boolean isTtp() {
        return ttp;
    }
    public void setTtp(boolean ttp) {
        this.ttp = ttp;
    }
    public void switchDamage(Player player) {
        openSettingsInventory(player);
        damage = !damage;
    }
    public void switchBackpack(Player player) {
        openSettingsInventory(player);
        backpack = !backpack;
    }
    public void switchTtp(Player player) {
        openSettingsInventory(player);
        ttp = !ttp;
    }

    public enum  BingoDifficulty {
        EASY,NORMAl,HARD
    }
    public enum  BingoSettingsType {
        TEAMS,ITEMS,DIFFICULTY,DAMAGE,BACKPACK,TTP
    }
}
