package de.coolepizza.bingo.commands;

import de.coolepizza.bingo.Bingo;
import de.coolepizza.bingo.manager.BingoManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HelpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(commandSender.hasPermission("bingo.admin")) {
            commandSender.sendMessage(ChatColor.BLUE+"/start "+ChatColor.WHITE+"Starte eine neue Runde von Bingo!");
            commandSender.sendMessage(ChatColor.BLUE+"/reset "+ChatColor.WHITE+"Stoppe den Server und spiele eine neue Runde!");
        }
        if(Bingo.getBingoManager().bingoState == BingoManager.BingoState.INGAME) {
            commandSender.sendMessage(ChatColor.BLUE+"/bingo "+ChatColor.WHITE+"Listet dir alle zu findenden Items auf!");
            commandSender.sendMessage(ChatColor.BLUE+"/top "+ChatColor.WHITE+"Bringt dich zurück an die Oberfläche!");
            commandSender.sendMessage(ChatColor.BLUE+"/backpack "+ChatColor.WHITE+"Öffnet den Team-Backpack!");
            commandSender.sendMessage(ChatColor.BLUE+"/ttp <Spieler> "+ChatColor.WHITE+"Teleportier dich zu einem Mitspieler!");
            commandSender.sendMessage(ChatColor.BLUE+"/gc <Nachricht> "+ChatColor.WHITE+"Schreibe im globalen Chat!");
        }



        return true;
    }
}
