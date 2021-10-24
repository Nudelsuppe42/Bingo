package de.coolepizza.bingo.commands;

import de.coolepizza.bingo.Bingo;
import de.coolepizza.bingo.manager.BingoManager;
import de.coolepizza.bingo.team.Team;
import de.coolepizza.bingo.utils.ItemBuilder;
import de.coolepizza.bingo.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;

import java.util.ArrayList;

public class BackpackCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)){
            return false;
        }
        if (Bingo.getBingoManager().bingoState == BingoManager.BingoState.INGAME && Bingo.getBingoManager().getBingosettings().isBackpack()) {
            Player player = (Player) commandSender;
            Team team = Bingo.getBingoManager().getTeamManager().getTeamFromPlayer(player);

            player.openInventory(team.getBackpack());
        } else {
            commandSender.sendMessage("§cDieser Command ist nur während des Spiels freigeschaltet!");
        }
        return false;

    }
}
