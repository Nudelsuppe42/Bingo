package de.coolepizza.bingo.commands;

import de.coolepizza.bingo.Bingo;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) return true;
        Bingo.getBingoManager().getBingosettings().openSettingsInventory((Player) commandSender);
        return true;
    }
}
